/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Proyect.services;

import com.aew.FinalTopic.Final_Proyect.model.Cart;
import com.aew.FinalTopic.Final_Proyect.model.ProductCart;
import com.aew.FinalTopic.Final_Proyect.model.ProductCartPK;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface ProductCartService {

    void addProductCart(ProductCart productCart);

    void deleteProductCart(ProductCartPK productCartPK);

    boolean isProductExist(ProductCartPK id);

    void updateProductCart(ProductCart productCart);

    List<ProductCart> findAllProductCart();

    List<ProductCart> findByCart(ProductCartPK id);

    List<ProductCart> findByIdCart(Cart idCart);

}
