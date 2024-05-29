package com.restaurant.restaurant.service.user;

import com.restaurant.restaurant.entity.User;
import com.restaurant.restaurant.utility.UserDto;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User updateUser(int userId, UserDto userDto);
    public String deleteUser(int userId);
    public List<User> getAllUser();
}
