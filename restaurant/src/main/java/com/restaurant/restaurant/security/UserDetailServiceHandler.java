package com.restaurant.restaurant.security;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.exception.userex.UserNotFound;
import com.restaurant.restaurant.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServiceHandler implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepo.findByEmail(username);
        if(user.isEmpty()){
          throw  new UserNotFound(STR."User not found with email \{username}");
        }

        else{

            User validUser = user.get();

            String userEmail = validUser.getEmail();
            String password = validUser.getPassword();

            List<GrantedAuthority> authorities  = new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(validUser.getRole()));

            return new org.springframework.security.core.userdetails.User(userEmail,password,authorities);

        }

    }
}
