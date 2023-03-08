package com.datrastoco.administration_service.users.services;

import com.datrastoco.administration_service.users.entities.User;
import com.datrastoco.administration_service.users.entities.AuthenticateUser;

import java.util.List;

public interface UserService {

//  REGISTER
    AuthenticateUser createUserAuthentication(AuthenticateUser authenticateUser);

//  CREATE USER
    User createUser(User user);

//  GET ALL USERS
    List<User> getUsers();

//  UPDATE USER
    User updateUser(Integer userId, User userDetails);

//  DELETE USER
    User deleteUser(Integer userId, User userDetails);
}
