package com.datrastoco.administration_service.users.services.roles;

import com.datrastoco.administration_service.users.entities.Role;
import com.datrastoco.administration_service.users.entities.User;

import java.util.List;

public interface RoleService {

//  CREATE ROLE......................................
    Role createRole(Role role);

//  GET LIST ROLES...................................
    List<Role> getRoles();

//  UPDATE ROLE.......................................
    Role updateRole(Integer roleId, Role roleDetails);

//  DELETE ROLE
    Role deleteUser(Integer roleId, Role roleDetails);

//  GET ROLE
    Role getRole(Integer roleId);
}
