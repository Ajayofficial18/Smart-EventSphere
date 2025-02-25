package com.eventsphere.services.servicesImpl;

import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.UserRepository;
import com.eventsphere.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(User newUser) {

        //User excitingUser = userRepository.findByEmail(newUser.getEmail());
        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use.");
        }
        //user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);

    }

    @Override
    public User authenticateUser(String email, String password) {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());
        existingUser.setFullName(user.getFullName());
        existingUser.setPhone(user.getPhone());
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public String deleteUser(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "User does not exist";
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
