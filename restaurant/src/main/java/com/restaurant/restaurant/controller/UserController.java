package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.service.user.UserDto;
import com.restaurant.restaurant.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
  @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.createUser(user),HttpStatus.CREATED);
    }
    @PostMapping("/create/admin")
    public ResponseEntity<User> createAdmin(@RequestBody User user){
        return new ResponseEntity<>(userService.createAdmin(user),HttpStatus.CREATED);
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
    @PatchMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, UserDto userDto){
      return new ResponseEntity<>(userService.updateUser(userId,userDto),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId){
      return new ResponseEntity<>(userService.deleteUser(userId),HttpStatus.OK);
    }
    @GetMapping("/read")
    public ResponseEntity<List<User>>getAllUser(){
      return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }


}
