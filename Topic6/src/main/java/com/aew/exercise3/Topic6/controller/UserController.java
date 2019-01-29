/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.exercise3.Topic6.controller;

import com.aew.exercise3.Topic6.model.User;
import com.aew.exercise3.Topic6.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Adrian
 */
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String users() {

        return "TOPIC 6 EXERCISE 3: REST API to Management Users";

    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {

        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET/*, produces = MediaType.APPLICATION_JSON_VALUE*/)
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    //Create a User
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {

        if (userService.isUserExist(user)) {
            //El usuario ya existe
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userService.addUser(user);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{username}").buildAndExpand(user.getUsername()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //Update a User
    
    @RequestMapping(value = "/users/{username}", method = RequestMethod.PUT)
    public ResponseEntity <User> updateUser(@PathVariable("username")String username, @RequestBody User user){
        
        User currentUser = userService.findByUsername(username);
        if (currentUser == null){
           return new ResponseEntity <User>(HttpStatus.NOT_FOUND);
        }
        
        currentUser.setEmail(user.getEmail());
        currentUser.setName(user.getName());
        currentUser.setPassword(user.getPassword());
        currentUser.setNickname(user.getNickname());
        
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser,HttpStatus.OK);
    }
    
     //Delete a User
    
    @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
    public ResponseEntity <User> deleteUser(@PathVariable("username")String username){
        User user = userService.findByUsername(username);
        if (user ==  null){
           return new ResponseEntity <User>(HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(username);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
    
    
}
