package com.restaurant.restaurant.service.user;

import com.restaurant.restaurant.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {
    public String createUser(User user);
    public User updateUser(int userId,UserDto userDto);
    public String deleteUser(int userId);
    public List<User> getAllUser();
}
