package com.juwe.lms.service;

import com.juwe.lms.entity.User;
import com.juwe.lms.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
    public class AuthService {

        @Autowired
        private UserRepository userRepository;

        public User register(User newUser) {
            Optional<User> existing = userRepository.findByEmail(newUser.getEmail());

            if (existing.isPresent()) {
                throw new RuntimeException("Email is already registered");
            }

            return userRepository.save(newUser);
        }

        public User login(String email, String password) {
            Optional<User> result = userRepository.findByEmail(email);

            if (!result.isPresent()) {
                throw new RuntimeException("Invalid email or password");
            }

            User user = result.get();

            if (user.isDeleted()) {
                throw new RuntimeException("Invalid email or password");
            }

            if (!user.getPassword().equals(password)) {
                throw new RuntimeException("Invalid email or password");
            }

            return user;
        }
    }

