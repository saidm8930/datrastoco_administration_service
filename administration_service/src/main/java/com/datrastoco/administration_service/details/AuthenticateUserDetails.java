package com.datrastoco.administration_service.details;

import com.datrastoco.administration_service.users.entities.AuthenticateUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticateUserDetails implements UserDetails {

    private final String username;
    private final String password;
    private final List<GrantedAuthority> authorityList;

    public AuthenticateUserDetails(AuthenticateUser authenticateUser){
        this.username = authenticateUser.getUsername();
        this.password = authenticateUser.getPassword();
        this.authorityList = Arrays.stream(authenticateUser.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorityList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
