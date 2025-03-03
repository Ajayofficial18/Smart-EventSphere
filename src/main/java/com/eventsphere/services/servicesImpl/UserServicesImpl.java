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
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private EventAttendeeRepository eventAttendeeRepository;
    @Autowired
    private SpeakerRepository speakerRepository;
    @Autowired
    private EventCrewRepository eventCrewRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(SignUpUserDto newUser) {

//        User excitingUser = userRepository.findByEmail(newUser.getEmail()).get();

        if (userRepository.findByEmail(newUser.getEmail()).isPresent()) {
            throw new RuntimeException("Email is already in use.");
        }
        //newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        User user = userRepository.save(new User(newUser.getEmail(),newUser.getPassword(),newUser.getName(),newUser.getRole()));

        return userRepository.save(user);

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
    @Transactional
    public String deleteUser(Long id) {
        if(userRepository.existsById(id)){
            List<Event> events = eventRepository.findByCreatedById(id);
            for(Event event : events){
                eventAttendeeRepository.deleteByEvent(event);
                eventCrewRepository.deleteByEvent(event);
                speakerRepository.deleteByEvent(event);
            }
            eventRepository.deleteByCreatedBy(userRepository.findById(id).get());
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
