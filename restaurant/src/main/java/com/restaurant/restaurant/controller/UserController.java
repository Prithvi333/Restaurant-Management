package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
  @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }
    @GetMapping("/login")
    public ResponseEntity<String> userLogin(Authentication authentication){
      String message="";
      if(authentication.isAuthenticated())
          message= "User login successfully";
      else
          message="Invalid login credentials";
      return new ResponseEntity<>(message,HttpStatus.OK);
    }


}
