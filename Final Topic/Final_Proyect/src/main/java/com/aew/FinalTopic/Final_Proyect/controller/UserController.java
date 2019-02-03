/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Proyect.controller;

import com.aew.FinalTopic.Final_Proyect.model.User;
import com.aew.FinalTopic.Final_Proyect.services.CartService;
import com.aew.FinalTopic.Final_Proyect.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adrian Wilgenhoff
 */
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    //Retrieve all users
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUsers() {

        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Retrieve a user    
    @RequestMapping(value = "/users/{username}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Create a User
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody User user) {

        if (userService.isUserExist(user)) {
            return new ResponseEntity<>("User already exists", HttpStatus.CONFLICT);
        }
        userService.addUser(user);
        //Cart cart = new Cart(null,user);
        //cartService.addCart(new Cart(null,user));
        return new ResponseEntity<>("Successfully created user", HttpStatus.CREATED);
    }

    //Update a User
    @RequestMapping(value = "/users/{username}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable("username") String username, @RequestBody User user) {

        User currentUser = userService.findByUsername(username);
        if (currentUser == null) {
            return new ResponseEntity<>("Non-existent user", HttpStatus.NOT_FOUND);
        }
        currentUser.setPassword(user.getPassword());
        userService.updateUser(currentUser);
        return new ResponseEntity<>("Password changed", HttpStatus.OK);
    }

    //Delete a User
    @RequestMapping(value = "/users/{username}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>("Non-existent user", HttpStatus.NOT_FOUND);
        }
        userService.deleteUser(username);
        return new ResponseEntity<>("User Deleted", HttpStatus.OK);
    }

    //Logging an user
    @RequestMapping(value = "/user/login/{username}/{password}", method = RequestMethod.GET)
    public ResponseEntity<String> loginUser(@PathVariable("username") String username, @PathVariable("password") String password) {
        User user = userService.findByUsername(username);
        if (user == null) {
            return new ResponseEntity<>("Non-existent user", HttpStatus.NOT_FOUND);
        } else if (user.getPassword().equals(password)) {
            return new ResponseEntity<>("Successful login", HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>("Incorrect password", HttpStatus.CONFLICT);
        }

    }

}
