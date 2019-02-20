package com.aew.FinalTopic.Final_Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "cart")
public class Cart implements Serializable {

    private static final long serialVersionUID = 926575413166436534L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCart")
    @JsonIgnore
    private Integer idCart;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCart")
    @JsonIgnore
    private Collection<ProductCart> productCartCollection;

    //@OneToOne
    //private User username;
    
    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne(optional = false)
    private User username;

    public Cart() {
    }

    public Cart(Integer idCart) {
        this.idCart = idCart;
    }

    public Cart(Integer idCart, Collection<ProductCart> productCartCollection, User username) {
        this.idCart = idCart;
        this.productCartCollection = productCartCollection;
        this.username = username;
    }

    public Cart(List<ProductCart> products, User username) {

        this.productCartCollection = products;
        this.username = username;
    }

    public Integer getIdCart() {
        return idCart;
    }

    public void setIdCart(Integer idCart) {
        this.idCart = idCart;
    }

    public List<ProductCart> getProducts() {
        return (List<ProductCart>) productCartCollection;
    }

    public void setProducts(List<ProductCart> products) {
        this.productCartCollection = products;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public User getUsername() {
        return username;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idCart);
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
        final Cart other = (Cart) obj;
        return true;
    }

}
