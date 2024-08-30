package com.example.service;


import com.example.model.MyUser;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    public MyUser addUser(MyUser user) {
        MyUser saveUser = new MyUser();
        saveUser.setLogin(user.getLogin());
        saveUser.setEmail(user.getEmail());
        saveUser.setRoles(user.getRoles());
        saveUser.setPassword(user.getPassword());
        return userRepository.save(saveUser);

    }

    @Transactional
    @Override
    public void updateUser(Long id, MyUser user) {
        MyUser userFind = findByIdUser(id);
        if (userFind != null) {
            userFind.setLogin(user.getLogin());
            userFind.setEmail(user.getEmail());
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
    public MyUser findByIdUser(Long id) {
        Optional<MyUser> userFindId = userRepository.findById(Math.toIntExact(id));
        if (userFindId.isPresent()) {
            return userFindId.get();
        }
        return null;
    }

    @Transactional
    @Override
    public List<MyUser> findAllUser() {
        List<MyUser> users = (List<MyUser>) userRepository.findAll();
        return users;
    }

}
//818b9ed8-2585-4ccb-9f7a-11548c3fb6bf