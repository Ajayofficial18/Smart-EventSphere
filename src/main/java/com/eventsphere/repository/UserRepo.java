package com.eventsphere.repository;

import com.eventsphere.entity.User;
import com.eventsphere.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<User,Long> {

    User findByEmail(String email);
    List<User> findByRole(Role role);

}
