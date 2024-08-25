package com.kiam.service.impl;

import com.kiam.domain.model.User;
import com.kiam.domain.repository.UserRepository;
import com.kiam.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + id));
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByEmail(userToCreate.getEmail())) {
            throw new IllegalArgumentException("User with email: " + userToCreate.getEmail() + " already exists");
        }
        return userRepository.save(userToCreate);
    }
}
