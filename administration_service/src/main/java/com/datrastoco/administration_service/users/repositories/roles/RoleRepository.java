package com.datrastoco.administration_service.users.repositories.roles;

import com.datrastoco.administration_service.users.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository <Role, Integer> {
}
