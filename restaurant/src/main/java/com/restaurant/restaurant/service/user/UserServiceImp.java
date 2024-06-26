package com.restaurant.restaurant.service.user;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.exception.userex.EmptyUserList;
import com.restaurant.restaurant.exception.userex.UserNotFound;
import com.restaurant.restaurant.repository.UserRepo;
import com.restaurant.restaurant.utility.UserDto;
import com.restaurant.restaurant.utility.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements  UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_"+ Users.CUSTOMER);

       return userRepo.save(user);
    }

    @PatchMapping("/update")
    @Override
    public User updateUser(int userId, UserDto userDto) {
        Optional<User> user =  userRepo.findById(userId);
        if(user.isEmpty())
            throw new UserNotFound();
        else {
            User validUser= user.get();
            validUser.setFirstName(userDto.getFirstName());
            validUser.setLastName(userDto.getLastName());
            return userRepo.save(validUser);
        }
    }

    @DeleteMapping("/delete")
    @Override
    public String deleteUser(int userId) {
        Optional<User> user =  userRepo.findById(userId);
        if(user.isEmpty())
            throw new UserNotFound();
        userRepo.delete(user.get());
        return "User deleted successfully";
    }

    @Override
    public List<User> getAllUser() {
      List<User> userList = userRepo.findAll();
      if(userList.isEmpty())
          throw new EmptyUserList();
      return userList;
    }


}
