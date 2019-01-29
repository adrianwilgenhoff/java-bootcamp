/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.exercise3.Topic6.repository;

import com.aew.exercise3.Topic6.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adrian
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findByName(String name);

    User findByNickname(String nickname);
    
    User finByUsername (String username);

}
