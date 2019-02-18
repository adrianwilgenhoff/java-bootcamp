package com.aew.FinalTopic.Final_Proyect.repository;

import com.aew.FinalTopic.Final_Proyect.model.Cart;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adrian
 */
public interface CartRepository extends CrudRepository<Cart, Integer> {

    Cart findByUsername(String username);

    Cart findByIdCart(Integer idCart);

}
