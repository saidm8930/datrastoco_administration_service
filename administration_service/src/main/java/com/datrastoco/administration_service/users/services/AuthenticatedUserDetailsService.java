package com.datrastoco.administration_service.users.services;

import com.datrastoco.administration_service.details.AuthenticateUserDetails;
import com.datrastoco.administration_service.users.entities.AuthenticateUser;
import com.datrastoco.administration_service.users.repositories.AuthenticateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class AuthenticatedUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticateUserRepository authenticateUserRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AuthenticateUser> authenticateUser= authenticateUserRepository.findUserByUsername(username);

        return authenticateUser.map(AuthenticateUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("this user not found: "+ username));

    }
}
