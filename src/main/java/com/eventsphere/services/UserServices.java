package com.eventsphere.services;

import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;

import java.util.List;

public interface UserServices {
    User registerUser(User user);
    User authenticateUser(String email, String password);
    User getUserById(Long id);
    List<User> getUsersByRole(Role role);
    User updateUser(User user);
    void deleteUser(Long id);
}
