package com.example.service;

import com.example.model.Role;
import com.example.model.User;

import java.util.List;


public interface UserService {

    User addUser(User user);

    void updateUser(Long id, User user);

    void deleteUser(Long id);

    User findByIdUser(Long id);

    List<User> findAllUser();
}
