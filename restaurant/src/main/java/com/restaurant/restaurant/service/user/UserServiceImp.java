package com.restaurant.restaurant.service.user;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static java.lang.StringTemplate.STR;
@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_CUSTOMER");
        userRepo.save(user);
        return STR."User is create successfully with name \{user.getFirstName()} \{user.getLastName()}";
    }
}
