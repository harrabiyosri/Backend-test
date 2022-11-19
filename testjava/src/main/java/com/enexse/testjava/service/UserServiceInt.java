package com.enexse.testjava.service;

import com.enexse.testjava.model.User;

import java.util.List;

public interface UserServiceInt {

    User saveUser(User U);
    User updateUser(User U);
    void deleteUser(User user);
    User getUser(String id);
    List<User> getAllUsers();
}
