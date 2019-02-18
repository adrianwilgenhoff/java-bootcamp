package com.aew.FinalTopic.Final_Proyect.controller;

import com.aew.FinalTopic.Final_Proyect.model.Cart;
import com.aew.FinalTopic.Final_Proyect.model.ProductCart;
import com.aew.FinalTopic.Final_Proyect.model.ProductCartPK;
import com.aew.FinalTopic.Final_Proyect.services.CartService;
import com.aew.FinalTopic.Final_Proyect.services.ProductCartService;
import com.aew.FinalTopic.Final_Proyect.services.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Adrian
 */
@RestController

public class ProductCartController {

    @Autowired
    private ProductCartService productCartService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    //add product a cart
    @RequestMapping(value = "/cart/product/add/idCart={idCart}/idProduct={idProduct}/quantity={quantity}", method = RequestMethod.POST)
    public ResponseEntity<String> addProductCart(@PathVariable("idCart") Integer idCart,
            @PathVariable("quantity") int quantity,
            @PathVariable("idProduct") Integer idProduct) {

        ProductCartPK productCartPK = new ProductCartPK(idCart, idProduct);
        ProductCart productCart = new ProductCart(productCartPK, quantity);

        if (productService.findByIdProduct(idProduct) == null) {
            return new ResponseEntity<>("Incorrect ID for a product", HttpStatus.CONFLICT);
        }
        if (cartService.findByIdCart(idCart) == null) {
            return new ResponseEntity<>("Incorrect ID for a cart", HttpStatus.CONFLICT);
        }
        if (productCartService.isProductExist(productCartPK)) {
            return new ResponseEntity<>("This product already exists in your cart", HttpStatus.CONFLICT);
        }
        productCartService.addProductCart(productCart);
        return new ResponseEntity<>("Product added to cart", HttpStatus.CREATED);
    }

    //delete product of cart
    @RequestMapping(value = "/cart/product/delete/idCart={idCart}/idProduct={idProduct}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteProductCart(@PathVariable("idCart") Integer idCart,
            @PathVariable("idProduct") Integer idProduct) {

        if (cartService.findByIdCart(idCart) == null) {
            return new ResponseEntity<>("Incorrect ID for a cart", HttpStatus.CONFLICT);
        }
        if (productService.findByIdProduct(idProduct) == null) {
            return new ResponseEntity<>("Incorrect ID for a product", HttpStatus.CONFLICT);
        }
        ProductCartPK productCartPK = new ProductCartPK(idCart, idProduct);
        if (!productCartService.isProductExist(productCartPK)) {
            return new ResponseEntity<>("The product does not exist in your cart", HttpStatus.CONFLICT);
        }
        productCartService.deleteProductCart(productCartPK);
        return new ResponseEntity<>("Product removed from the cart", HttpStatus.OK);
    }

    //total price for a cart
    @RequestMapping(value = "/cart/product/total/idCart={idCart}", method = RequestMethod.GET)
    public ResponseEntity<String> totalProductCart(@PathVariable("idCart") Integer idCart) {

        if (cartService.findByIdCart(idCart) == null) {
            return new ResponseEntity<>("Incorrect ID for a cart", HttpStatus.CONFLICT);
        }
        List<ProductCart> listProductCart = cartService.findByIdCart(idCart).getProducts();
        if (listProductCart.isEmpty()) {
            return new ResponseEntity<>("There are no products in your shopping cart", HttpStatus.CONFLICT);
        }
        float total = 0;
        for (ProductCart productCart : listProductCart) {
            total = total + (productCart.getQuantity() * productCart.getProduct().getPrice());
        }
        return new ResponseEntity<>("Total purchase " + total, HttpStatus.OK);
    }

    //list products for a cart
    @RequestMapping(value = "/cart/product/list/idCart={idCart}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductCart>> listAllProducts(@PathVariable("idCart") Integer idCart) {

        List<ProductCart> listProductCart = cartService.findByIdCart(idCart).getProducts();
        Cart cart = new Cart(idCart);
        //fix visualizacion: jsonIgnore JsonProperty
        if (listProductCart.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(listProductCart, HttpStatus.OK);
    }

    //quantity product for a cart
    @RequestMapping(value = "/cart/product/quantity/idCart={idCart}", method = RequestMethod.GET)
    public ResponseEntity<String> quantityProductCart(@PathVariable("idCart") Integer idCart) {

        if (cartService.findByIdCart(idCart) == null) {
            return new ResponseEntity<>("Incorrect ID for a cart", HttpStatus.CONFLICT);
        }
        List<ProductCart> listProductCart = cartService.findByIdCart(idCart).getProducts();
        if (listProductCart.isEmpty()) {
            return new ResponseEntity<>("There are no products in your shopping cart", HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>("Quantity of different products in your cart " + listProductCart.size(), HttpStatus.OK);
    }

    //modify quantity for a product in a cart
    @RequestMapping(value = "/cart/product/update/idCart={idCart}/idProduct={idProduct}/quantity={quantity}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@PathVariable("idCart") Integer idCart,
            @PathVariable("quantity") int quantity,
            @PathVariable("idProduct") Integer idProduct) {

        ProductCartPK productCartPK = new ProductCartPK(idCart, idProduct);
        ProductCart productCart = new ProductCart(productCartPK, quantity);

        if (cartService.findByIdCart(idCart) == null) {
            return new ResponseEntity<>("Incorrect ID for a cart", HttpStatus.CONFLICT);
        }
        if (productService.findByIdProduct(idProduct) == null) {
            return new ResponseEntity<>("Incorrect ID for a product", HttpStatus.CONFLICT);
        }
        if (!productCartService.isProductExist(productCartPK)) {
            return new ResponseEntity<>("The product does not exist in your cart", HttpStatus.CONFLICT);
        }
        productCartService.updateProductCart(productCart);
        return new ResponseEntity<>("Correctly modified quantity", HttpStatus.OK);
    }

    //comprar carrito: borrar todos los produtos para un idcart/mostrar total
}
