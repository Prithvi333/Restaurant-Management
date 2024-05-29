package com.restaurant.restaurant.controller;

import com.restaurant.restaurant.entity.Admin;
import com.restaurant.restaurant.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class GlobalController {
    @Autowired
    private AdminRepo adminRepo;
    @PostMapping("/signIn")
    public String login(Authentication authentication){
        if(authentication.isAuthenticated())
            return "Login successfully with email "+authentication.getName();
        return "Authentication failed";
    }

    @GetMapping("/head")
    public  ResponseEntity<String> readHead(@RequestHeader(value = "name") String name){
         return new ResponseEntity<>("My name is "+name,HttpStatus.OK);
    }

}
