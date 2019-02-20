/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "ProductCart")
public class ProductCart implements Serializable {

    private static final long serialVersionUID = 89765543424454L;

    @EmbeddedId
    @JsonIgnore
    private ProductCartPK productCartPK;

    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;

    @JoinColumn(name = "idProduct", referencedColumnName = "idProduct",/*nullable = false,*/ insertable = false, updatable = false)
    @ManyToOne()
    private Product idProduct;

    @JoinColumn(name = "idCart", referencedColumnName = "idCart", /*nullable = false,*/ insertable = false, updatable = false)
    @ManyToOne()
    @JsonIgnore
    private Cart idCart;

    public ProductCart() {
    }

    public ProductCart(ProductCartPK productCartPK) {
        this.productCartPK = productCartPK;

    }

    public ProductCart(ProductCartPK productCartPK, int quantity) {
        this.productCartPK = productCartPK;
        this.quantity = quantity;
    }

    public ProductCart(int quantity) {
        this.quantity = quantity;
    }

    public ProductCartPK getProductCarPK() {
        return productCartPK;
    }

    public void setProductCarPK(ProductCartPK productCarPK) {
        this.productCartPK = productCarPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return idProduct;
    }

    public void setProduct(Product product) {
        this.idProduct = product;
    }

    public Cart getCart() {
        return idCart;
    }

    public void setCart(Cart cart) {
        this.idCart = cart;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.productCartPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProductCart other = (ProductCart) obj;
        return true;
    }

    @Override
    public String toString() {
        return "ProductCart{" + "quantity=" + quantity + ", idProduct=" + idProduct + '}';
    }

}
