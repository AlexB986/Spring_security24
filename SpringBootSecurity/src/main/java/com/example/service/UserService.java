package com.example.service;

import com.example.model.MyUser;

import java.util.List;


public interface UserService {

    MyUser addUser(MyUser user);

    void updateUser(Long id, MyUser user);

    void deleteUser(Long id);

    MyUser findByIdUser(Long id);

    List<MyUser> findAllUser();
}
