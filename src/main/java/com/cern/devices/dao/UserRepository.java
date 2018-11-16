package com.cern.devices.dao;

import com.cern.devices.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByUserNameAndPassword(String username,String password);
    User findUsersById(Long id);
}
