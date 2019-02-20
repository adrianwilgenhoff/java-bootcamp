package com.aew.FinalTopic.Final_Project.serviceImpl;

import com.aew.FinalTopic.Final_Project.model.Product;
import com.aew.FinalTopic.Final_Project.repository.ProductRepository;
import com.aew.FinalTopic.Final_Project.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Adrian
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;
    
    
    @Override
    public void addProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void updateProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> findAllProduct() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public boolean isProductExist(Product product) {
        return productRepository.existsById(product.getIdProduct());
    }

    @Override
    public Product findByIdProduct(Integer idProduct) {
       return productRepository.findByIdProduct(idProduct);
    }
    
    
    
    
}
