package com.akbulutmehmet.authservice.service;


import com.akbulutmehmet.authservice.model.Role;
import com.akbulutmehmet.authservice.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = false)
    public Role createRole (Role role) {
        return roleRepository.save(role);
    }
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
