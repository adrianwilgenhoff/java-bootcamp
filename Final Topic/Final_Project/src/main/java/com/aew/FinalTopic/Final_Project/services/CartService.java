package com.aew.FinalTopic.Final_Project.services;

import com.aew.FinalTopic.Final_Project.model.Cart;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface CartService {

    void addCart(Cart cart);

    void deleteCart(Cart cart);

    Cart findByUsername(String username);

    boolean isCartExist(Cart cart);

    List<Cart> showCarts();

    Cart findByIdCart(Integer idCart);

}
