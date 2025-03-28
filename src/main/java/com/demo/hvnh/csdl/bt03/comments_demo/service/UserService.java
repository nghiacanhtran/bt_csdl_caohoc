package com.demo.hvnh.csdl.bt03.comments_demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.demo.hvnh.csdl.bt03.comments_demo.entity.User;
import com.demo.hvnh.csdl.bt03.comments_demo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }
}