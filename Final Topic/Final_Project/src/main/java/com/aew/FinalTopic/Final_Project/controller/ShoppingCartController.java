/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Project.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adrian
 */
@RestController
@RequestMapping("/api/shopping")
public class ShoppingCartController {

    @RequestMapping("/welcome")
    String ShoppingCart() {
        return "Shopping Cart API";
    }

    
    
    
    
}
