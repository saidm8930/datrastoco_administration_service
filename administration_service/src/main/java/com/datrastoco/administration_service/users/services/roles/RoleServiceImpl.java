package com.datrastoco.administration_service.users.services.roles;

import com.datrastoco.administration_service.users.entities.Role;
import com.datrastoco.administration_service.users.repositories.roles.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleRepository roleRepository;

//    CREATE ROLES.........................

    @Override
    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

//  GET ROLES..........................

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

//    UPDATE ROLE.......................

    @Override
    public Role updateRole(Integer roleId, Role roleDetails) {

        Role role = roleRepository.findById(roleId).get();
        role.setName(roleDetails.getName());
        role.setCode(roleDetails.getCode());
        role.setDescription(roleDetails.getDescription());
        role.setStatus(roleDetails.getStatus());

        return roleRepository.save(role);
    }

//    DELETE ROLE......................

    @Override
    public Role deleteUser(Integer roleId, Role roleDetails) {
        Role role = roleRepository.findById(roleId).get();
        role.setStatus(roleDetails.getStatus());

        return roleRepository.save(role);
    }

//    GET ROLE.....................................

    @Override
    public Role getRole(Integer roleId) {
        Optional<Role> role = roleRepository.findById(roleId);
        if(role.isPresent()){
            return role.get();
        } throw new RuntimeException("User is not found for id:" + roleId);
    }
}
