/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Project.repository;

import com.aew.FinalTopic.Final_Project.model.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Adrian
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {

    List<Product> findByCategory(String category);

    Product findByName(String name);
    
    Product findByIdProduct (Integer idProduct);

}
