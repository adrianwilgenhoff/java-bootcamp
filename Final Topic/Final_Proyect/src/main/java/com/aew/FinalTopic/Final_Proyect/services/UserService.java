package com.aew.FinalTopic.Final_Proyect.services;

import com.aew.FinalTopic.Final_Proyect.model.User;
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

    List<User> findAllUsers();

    boolean isUserExist(User user);

}
