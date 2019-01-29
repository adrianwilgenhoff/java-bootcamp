/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aew.exercise3.Topic6.model;

/**
 *
 * @author Adrian
 */
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Columns;
import org.springframework.stereotype.Repository;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "usersTopic6")

public class User implements Serializable{
    
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "username")
    private String username;
    
    @Column(name = "name")
    private String name;
       
    @Column(name = "nickname")
    private String nickname;
    
    @Column(name = "password")
    private String password;
   
    @Column(name = "email")
    private String email;

}
