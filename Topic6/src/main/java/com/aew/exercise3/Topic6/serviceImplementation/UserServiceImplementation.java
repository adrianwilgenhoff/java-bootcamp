/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.exercise3.Topic6.serviceImplementation;

import com.aew.exercise3.Topic6.model.User;
import com.aew.exercise3.Topic6.repository.UserRepository;
import com.aew.exercise3.Topic6.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Adrian
 */
public class UserServiceImplementation implements UserService{

    @Autowired
    private UserRepository userRepository;
    
    
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
       return userRepository.finByUsername(username);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public User findByNickname(String nickname) {
        return userRepository.findByNickname(nickname);
    }

    @Override
    public List<User> findAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public boolean isUserExist(User user) {
        return userRepository.existsById(user.getUsername());
    }
    
}
