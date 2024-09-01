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
        User saveUser = new User();
        saveUser.setUsername(user.getUsername());
        saveUser.setRoles(user.getRoles());
        saveUser.setPassword(user.getPassword());
        return userRepository.save(saveUser);

    }

    @Transactional
    @Override
    public void updateUser(Long id, User user) {
        User userFind = findByIdUser(id);
        if (userFind != null) {
            userFind.setUsername(user.getUsername());
            userFind.setPassword(user.getPassword());
            userFind.setRoles(user.getRoles());
            userRepository.save(userFind);
        }
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(Math.toIntExact(id));
    }

    @Transactional
    @Override
    public User findByIdUser(Long id) {
        Optional<User> userFindId = userRepository.findById(Math.toIntExact(id));
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
