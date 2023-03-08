package com.datrastoco.administration_service.users.repositories;

import com.datrastoco.administration_service.users.entities.AuthenticateUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthenticateUserRepository extends JpaRepository <AuthenticateUser, Integer>{
    Optional<AuthenticateUser> findUserByUsername(String username);
}
