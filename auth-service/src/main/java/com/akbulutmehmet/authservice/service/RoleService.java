package com.akbulutmehmet.authservice.service;


import com.akbulutmehmet.authservice.model.Role;
import com.akbulutmehmet.authservice.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = false)
    public Role saveRole (Role role) {
        return roleRepository.save(role);
    }
    @Transactional(readOnly = false)
    public List<Role> saveRoles(List<Role> roleList) {
        return roleRepository.saveAll(roleList);
    }

    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
