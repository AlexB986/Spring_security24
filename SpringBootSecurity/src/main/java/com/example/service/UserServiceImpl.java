package com.example.service;


import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public User addUser(User user) {
        return userRepository.save(user);

    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        User userFind = findByIdUser(id);
        if (userFind != null) {
            userRepository.save(user);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public User findByIdUser(Long id) {
        Optional<User> userFindId = userRepository.findById(id);
        if (userFindId.isPresent()) {
            return userFindId.get();
        }
        return null;
    }

    @Transactional
    @Override
    public List<User> findAllUser() {
        List<User> users = (List<User>) userRepository.findAll();
        return users;
    }

}
