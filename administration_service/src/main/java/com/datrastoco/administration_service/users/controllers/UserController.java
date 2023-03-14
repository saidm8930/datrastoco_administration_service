package com.datrastoco.administration_service.users.controllers;

import com.datrastoco.administration_service.users.dto.AuthRequest;
import com.datrastoco.administration_service.users.entities.User;
import com.datrastoco.administration_service.users.entities.AuthenticateUser;
import com.datrastoco.administration_service.users.services.JwtService;
import com.datrastoco.administration_service.users.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@CrossOrigin

public class UserController {

    @Autowired
    private UserServiceImpl userServiceImplementation;

    @Autowired
    private JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;


    @GetMapping(value = "/v1/welcome")
    public String welcome(){ return "Welcome page"; }

//  REGISTER

    @RequestMapping(value = "/v1/register", method = RequestMethod.POST)
    public AuthenticateUser register(@RequestBody AuthenticateUser authenticateUser){
        return userServiceImplementation.createUserAuthentication(authenticateUser);
    }

//  AUTHENTICATION

    @RequestMapping(value = "/v1/login", method = RequestMethod.POST)
    public String login(@RequestBody AuthRequest authRequest){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(),authRequest.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(authRequest.getUsername());
        }else {
            throw new UsernameNotFoundException("user not found");
        }
    }


//    CREATE USER

    @RequestMapping(value="/v1/users", method= RequestMethod.POST)
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public User createUser(@RequestBody User user) {
        return userServiceImplementation.createUser(user);
    }


//    GET LIST OF USER

    @RequestMapping(value="/v1/users", method=RequestMethod.GET)
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> readUsers() {
        return userServiceImplementation.getUsers();
    }


//    UPDATE USER

    @RequestMapping(value="/v1/users/{userId}", method=RequestMethod.PUT)
    public User updateUser(@PathVariable(value = "userId") Integer id, @RequestBody User userDetails) {
        return userServiceImplementation.updateUser(id, userDetails);
    }


//    GET USER

    @RequestMapping(value = "/v1/users/{userId}", method = RequestMethod.GET)
    public User getUser(@PathVariable(value = "userId") Integer id){
        return userServiceImplementation.getUser(id);
    }


//    DELETE USER

    @RequestMapping(value="/v1/deleteUser/{userId}", method=RequestMethod.PUT)
    public User deleteUser(@PathVariable(value = "userId") Integer id, @RequestBody User userDetails) {
        return userServiceImplementation.deleteUser(id, userDetails);
    }

}
