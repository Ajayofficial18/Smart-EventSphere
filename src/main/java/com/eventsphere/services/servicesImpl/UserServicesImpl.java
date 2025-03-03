package com.eventsphere.services.servicesImpl;

import com.eventsphere.dto.SignUpUserDto;
import com.eventsphere.entity.Event;
import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import com.eventsphere.repository.*;
import com.eventsphere.services.UserServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EventRepo eventRepo;
    @Autowired
    private AttendeeRepo attendeeRepo;
    @Autowired
    private SpeakerRepo speakerRepo;
    @Autowired
    private CrewRepo crewRepo;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public String registerUser(SignUpUserDto newUser) {
        User excitingUser = userRepo.findByEmail(newUser.getEmail());
        if (excitingUser!=null) {
            return "User already exists with this email!";
        }
        //newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        userRepo.save(new User(newUser.getEmail(),newUser.getPassword(),newUser.getName(),newUser.getRole()));
        return "User registered successfully!";
    }

    @Override
    public User authenticateUser(String email, String password) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        User existingUser = getUserById(user.getId());
        if(userRepo.findByEmail(user.getEmail()) != null){
            if(!user.getEmail().equals(existingUser.getEmail())){
                throw new RuntimeException("User already exists with this email!");
            }
        }
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setPhone(user.getPhone());
        userRepo.save(existingUser);
        return existingUser;
    }

    @Override
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id : "+id));
    }

    @Override
    public List<User> getUsersByRole(Role role) {
        return userRepo.findByRole(role);
    }

    @Override
    @Transactional
    public String deleteUser(Long id) {
        if(userRepo.existsById(id)){
            List<Event> events = eventRepo.findByCreatedById(id);
            for(Event event : events){
//                attendeeRepo.deleteByEvent(event);
//                crewRepo.deleteByEvent(event);
//                speakerRepo.deleteByEvent(event);
            }
            eventRepo.deleteByCreatedBy(getUserById(id));
            userRepo.deleteById(id);
            return "User deleted successfully";
        }
        return "User does not exist";
    }
}
