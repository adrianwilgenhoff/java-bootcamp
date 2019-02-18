package com.aew.FinalTopic.Final_Proyect.controller;

import com.aew.FinalTopic.Final_Proyect.model.Cart;
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
 * @author Adrian
 */
@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    //Retrieve all Carts
    @RequestMapping(value = "/carts", method = RequestMethod.GET)
    public ResponseEntity<List<Cart>> listAllUsers() {

        List<Cart> carts = cartService.showCarts();
        if (carts.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carts, HttpStatus.OK);
    }

    //Retrieve a cart
    @RequestMapping(value = "/cart/{idCart}", method = RequestMethod.GET)
    public ResponseEntity<Cart> getCart(@PathVariable("idCart") Integer idCart) {
        Cart cart = cartService.findByIdCart(idCart);
        if (cart == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    //Create Cart for User
    @RequestMapping(value = "/cart", method = RequestMethod.POST)
    public ResponseEntity<String> createCart(@RequestBody Cart cart) {

        if (userService.findByUsername(cart.getUsername().getUsername()) == null) {
            return new ResponseEntity<>("Non-existent user", HttpStatus.CONFLICT);
        }
        cartService.addCart(cart);
        return new ResponseEntity<>("Successfully created cart", HttpStatus.CREATED);
    }

    //Delete a Cart
    @RequestMapping(value = "/cart/{idCart}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteCart(@PathVariable("idCart") Integer idCart) {
        Cart cart = cartService.findByIdCart(idCart);
        if (cart == null) {
            return new ResponseEntity<>("There is no cart for that id", HttpStatus.NOT_FOUND);
        }
        cartService.deleteCart(cart);
        return new ResponseEntity<>("Cart removed", HttpStatus.NO_CONTENT);
    }

}
