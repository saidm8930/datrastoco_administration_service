package com.datrastoco.administration_service.users.controllers;

import com.datrastoco.administration_service.users.entities.Role;
import com.datrastoco.administration_service.users.entities.User;
import com.datrastoco.administration_service.users.services.roles.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class RoleController {

    @Autowired
    private RoleServiceImpl roleServiceImpl;

//  CREATE ROLE........................................

    @RequestMapping(value="/v1/roles", method= RequestMethod.POST)
    public Role createRole(@RequestBody Role role) {
        return roleServiceImpl.createRole(role);
    }

//  GET ROLES .........................................

    @RequestMapping(value="/v1/roles", method=RequestMethod.GET)
    public List<Role> readRoles() {
        return roleServiceImpl.getRoles();
    }

//  GET ROLE ..........................................

    @RequestMapping(value = "/v1/roles/{roleId}", method = RequestMethod.GET)
    public Role getRole(@PathVariable(value = "roleId") Integer id){
        return roleServiceImpl.getRole(id);
    }

//  UPDATE ROLE........................................

    @RequestMapping(value="/v1/roles/{roleId}", method=RequestMethod.PUT)
    public Role updateRole(@PathVariable(value = "roleId") Integer id, @RequestBody Role roleDetails) {
        return roleServiceImpl.updateRole(id, roleDetails);
    }



}
