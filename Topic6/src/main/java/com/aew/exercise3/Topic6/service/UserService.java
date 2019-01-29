/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.exercise3.Topic6.service;

import com.aew.exercise3.Topic6.model.User;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface UserService {

    void addUser(User user);

    void deleteUser(String username);

    void updateUser(User user);
    
    User findByUsername(String username);

    User findByName(String name);

    User findByNickname(String nickname);

    List<User> findAllUsers();
    
    boolean isUserExist(User user);
    
}
