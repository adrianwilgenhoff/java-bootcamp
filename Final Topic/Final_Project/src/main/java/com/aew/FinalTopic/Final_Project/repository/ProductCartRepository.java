/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Project.repository;

import com.aew.FinalTopic.Final_Project.model.Cart;
import com.aew.FinalTopic.Final_Project.model.ProductCart;
import com.aew.FinalTopic.Final_Project.model.ProductCartPK;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adrian
 */
public interface ProductCartRepository extends CrudRepository<ProductCart, ProductCartPK> {

    List<ProductCart> findByProductCartPK(ProductCartPK id);
    
    List<ProductCart> findByIdCart(Cart idCart);
    
    

}
