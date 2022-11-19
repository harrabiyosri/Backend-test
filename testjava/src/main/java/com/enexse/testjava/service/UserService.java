package com.enexse.testjava.service;

import com.enexse.testjava.model.User;
import com.enexse.testjava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInt{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User saveUser(User U) {
        return userRepository.save(U);
    }

    @Override
    public User updateUser(User U) {
        return null;
    }

    @Override
    public void deleteUser(User U) {
        userRepository.delete(U);
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
