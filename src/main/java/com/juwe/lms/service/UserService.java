package com.juwe.lms.service;
import com.juwe.lms.entity.User;
import com.juwe.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(Long id) {
        Optional<User> result = userRepository.findById(id);

        if (!result.isPresent()) {
            throw new RuntimeException("User not found");
        }

        User user = result.get();

        if (user.isDeleted()) {
            throw new RuntimeException("User not found");
        }

        return user;
    }

    public User updateUser(Long id, User updatedUser) {
        User existing = getUserById(id);
        existing.setName(updatedUser.getName());
        existing.setEmail(updatedUser.getEmail());
        return userRepository.save(existing);
    }

    public void softDeleteUser(Long id) {
        User user = getUserById(id);
        user.setDeleted(true);
        userRepository.save(user);
    }
}