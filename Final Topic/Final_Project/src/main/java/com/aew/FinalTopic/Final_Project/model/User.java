/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.FinalTopic.Final_Project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Adrian
 */
@Entity
@Table(name = "user")
@ApiModel(value = "Client Entity", description = "Complete data of a Entity Client of ShopCart")
public class User implements Serializable {

    private static final long serialVersionUID = 87890213232L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "username")
    @ApiModelProperty(value = "The id of Client", required = true,example="Adrian", position=1)
    private String username;

    @JsonIgnore
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    @ApiModelProperty(value="The password of the Client", required = true,example="miPW", position=2)
    private String password;

    
    //@OneToOne
    //private Cart cart;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "username")
    @JsonIgnore
    private Collection<Cart> cartCollection;

    public User() {
    }

    public User(String username) {
        this.username = username;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Collection<Cart> getCartCollection() {
        return cartCollection;
    }

    public void setCartCollection(Collection<Cart> cartCollection) {
        this.cartCollection = cartCollection;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

}
