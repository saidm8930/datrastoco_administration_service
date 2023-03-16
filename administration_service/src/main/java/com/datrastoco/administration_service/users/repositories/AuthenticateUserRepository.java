package com.datrastoco.administration_service.users.repositories;

import com.datrastoco.administration_service.users.entities.AuthenticateUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthenticateUserRepository extends JpaRepository <AuthenticateUser, Integer>{
    Optional<AuthenticateUser> findUserByUsername(String username);
}
