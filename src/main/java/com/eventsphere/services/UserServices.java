package com.eventsphere.services;

import com.eventsphere.dto.SignUpUserDto;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;

import java.util.List;

public interface UserServices {
    String registerUser(SignUpUserDto user);
    User authenticateUser(String email, String password);
    User getUserById(Long id);
    List<User> getUsersByRole(Role role);
    User updateUser(User user);
    String deleteUser(Long id);
    List<User> getAllUser();
}
