package com.aew.FinalTopic.Final_Project.serviceImpl;

import com.aew.FinalTopic.Final_Project.model.Cart;
import com.aew.FinalTopic.Final_Project.repository.CartRepository;
import com.aew.FinalTopic.Final_Project.services.CartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public void addCart(Cart cart) {
        cartRepository.save(cart);
    }

    @Override
    public void deleteCart(Cart cart) {
        cartRepository.delete(cart);
    }

    @Override
    public Cart findByUsername(String username) {
        return cartRepository.findByUsername(username);
    }

    @Override
    public boolean isCartExist(Cart cart) {

        return cartRepository.existsById(cart.getIdCart());

    }

    @Override
    public List<Cart> showCarts() {
        return (List<Cart>) cartRepository.findAll();
    }

    @Override
    public Cart findByIdCart(Integer idCart) {
        return cartRepository.findByIdCart(idCart);
    }

}
