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
import javax.persistence.Embeddable;

/**
 *
 * @author Adrian
 */
@Embeddable
public class ProductCartPK implements Serializable{

    private static final long serialVersionUID = 2445678945687L;
    
    @Basic(optional = false)
    @Column(name = "idCart")
    @JsonIgnore
    private Integer idCart;
    
    
    @Basic(optional = false)
    @Column(name = "idProduct")
    @JsonIgnore
    private Integer idProduct;

    public ProductCartPK() {
    }

    public ProductCartPK(Integer idCart, Integer idProduct) {
        this.idCart = idCart;
        this.idProduct = idProduct;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public int getIdProducto() {
        return idProduct;
    }

    public void setIdProducto(Integer idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.idCart);
        hash = 31 * hash + Objects.hashCode(this.idProduct);
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
        final ProductCartPK other = (ProductCartPK) obj;
        return true;
    }
    
    
    

}
