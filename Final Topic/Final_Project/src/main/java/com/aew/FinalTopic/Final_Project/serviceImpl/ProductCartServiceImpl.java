/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Project.serviceImpl;

import com.aew.FinalTopic.Final_Project.model.Cart;
import com.aew.FinalTopic.Final_Project.model.ProductCart;
import com.aew.FinalTopic.Final_Project.model.ProductCartPK;
import com.aew.FinalTopic.Final_Project.repository.ProductCartRepository;
import com.aew.FinalTopic.Final_Project.services.ProductCartService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class ProductCartServiceImpl implements ProductCartService{

    @Autowired
    private ProductCartRepository productCartRepository;
    
    @Override
    public void addProductCart(ProductCart productCart) {
        productCartRepository.save(productCart);
    }

    @Override
    public void deleteProductCart(ProductCartPK productCart) {
        productCartRepository.deleteById(productCart);
    }

    @Override
    public void updateProductCart(ProductCart productCart) {
        productCartRepository.save(productCart);
    }

    @Override
    public List<ProductCart> findAllProductCart() {
        return (List<ProductCart>) productCartRepository.findAll();
    }

    @Override
    public List<ProductCart> findByCart(ProductCartPK id) {
        return productCartRepository.findByProductCartPK(id);
    }

    @Override
    public boolean isProductExist(ProductCartPK id) {
        return productCartRepository.existsById(id);
    }

    @Override
    public List<ProductCart> findByIdCart(Cart idCart) {
        return productCartRepository.findByIdCart(idCart);
    }
    
    
    
}
