package com.datrastoco.administration_service.users.services;

import com.datrastoco.administration_service.users.entities.AuthenticateUser;
import com.datrastoco.administration_service.users.repositories.UserRepository;
import com.datrastoco.administration_service.users.entities.User;
import com.datrastoco.administration_service.users.repositories.AuthenticateUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticateUserRepository authenticateUserRepository;


    @Override
    public User createUser(User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    // UPDATE
    @Override
    public User updateUser(Integer userId, User userDetails) {

        User user = userRepository.findById(userId).get();
        user.setFirst_name(userDetails.getFirst_name());
        user.setMiddle_name(userDetails.getMiddle_name());
        user.setLast_name(userDetails.getLast_name());
        user.setAge(userDetails.getAge());
        user.setGender(userDetails.getGender());
        user.setDistrict(userDetails.getDistrict());
        user.setEmail(userDetails.getEmail());
        user.setNationality(userDetails.getNationality());
        user.setRegion(userDetails.getRegion());
        user.setPhone_1(userDetails.getPhone_1());
        user.setPhone_2(userDetails.getPhone_2());
        user.setStreet(userDetails.getStreet());
        user.setTribe(userDetails.getTribe());
        user.setWard(userDetails.getWard());
        user.setUsername(userDetails.getUsername());
        user.setStatus(userDetails.getStatus());

        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Integer userId, User userDetails) {
        User user = userRepository.findById(userId).get();
        user.setStatus(userDetails.getStatus());

        return userRepository.save(user);
    }

    @Override
    public AuthenticateUser createUserAuthentication(AuthenticateUser authenticateUser) {
        authenticateUser.setPassword(passwordEncoder.encode(authenticateUser.getPassword()));
        return authenticateUserRepository.save(authenticateUser);

    }

}
