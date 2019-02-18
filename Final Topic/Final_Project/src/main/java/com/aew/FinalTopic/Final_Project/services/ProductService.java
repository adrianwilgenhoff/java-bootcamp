package com.aew.FinalTopic.Final_Proyect.services;

import com.aew.FinalTopic.Final_Proyect.model.Product;
import java.util.List;

/**
 *
 * @author Adrian
 */
public interface ProductService {

    void addProduct(Product product);

    void deleteProduct(Product product);

    void updateProduct(Product product);

    List<Product> findByCategory(String category);

    Product findByName(String name);

    List<Product> findAllProduct();
    
    Product findByIdProduct(Integer idProduct);

    boolean isProductExist(Product product);

}
