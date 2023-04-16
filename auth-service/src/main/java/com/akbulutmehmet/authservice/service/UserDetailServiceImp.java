package com.akbulutmehmet.authservice.service;

import com.akbulutmehmet.authservice.model.UserDetailsImp;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
public class UserDetailServiceImp implements UserDetailsService {
    private final UserService userService;

    public UserDetailServiceImp(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new UserDetailsImp(userService.loadUserByUsername(username));
    }
}
