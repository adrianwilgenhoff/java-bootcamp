package com.aew.FinalTopic.Final_Proyect.controller;

import com.aew.FinalTopic.Final_Proyect.model.Product;
import com.aew.FinalTopic.Final_Proyect.services.ProductService;
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
@RequestMapping(value = "/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    //------------------------- Retrieve all products ------------------------//
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAllUsers() {

        List<Product> products = productService.findAllProduct();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //----------------------- Retrieve product for name ----------------------//
    @RequestMapping(value = "/products/name/{name}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProduct(@PathVariable("name") String name) {
        Product product = productService.findByName(name);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //----------------------- Retrieve product for category ----------------------//
    @RequestMapping(value = "/products/category/{category}", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProductForCategory(@PathVariable("category") String category) {
        List<Product> products = productService.findByCategory(category);
        if (products == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    //----------------------- Create product -----------------------//
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<String> createProduct(@RequestBody Product product) {

        //reseolver problema que debo ingresar un id cualquier q no exista para que 
        //hibernate genere el siguiente en la tabla/sol:json ignore y cambiar constructor en la entidad product
        if (productService.isProductExist(product)) {
            return new ResponseEntity<>("Product already exists", HttpStatus.CONFLICT);
        }
        productService.addProduct(product);
        return new ResponseEntity<>("Successfully created product", HttpStatus.CREATED);
    }

    //----------------------- Update product -----------------------//
    @RequestMapping(value = "/product/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@PathVariable("name") String name, @RequestBody Product product) {

        Product currentProduct = productService.findByName(name);
        if (currentProduct == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        currentProduct.setName(product.getName());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setCategory(product.getCategory());
        productService.updateProduct(currentProduct);
        return new ResponseEntity<>(currentProduct, HttpStatus.OK);
    }

    //----------------------- Delete product -----------------------//
    @RequestMapping(value = "/product/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUser(@PathVariable("name") String name) {
        Product product = productService.findByName(name);
        if (product == null) {
            return new ResponseEntity<>("Non-existent product", HttpStatus.NOT_FOUND);
        }
        productService.deleteProduct(product);
        return new ResponseEntity<>("Product deleted", HttpStatus.NO_CONTENT);
    }

}
