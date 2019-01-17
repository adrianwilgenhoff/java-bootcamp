/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adrian
 */
public class SingletonPattern {

    public static void main(String[] args) {

        SingletonConnection myConnection = SingletonConnection.getInstance("jdbc:mysql://localhost:3306/usuarios", "root", "");
        SingletonConnection myConnection2 = SingletonConnection.getInstance("jdbc:mysql://localhost:3306/resty", "root", "");

        System.out.println("My connection instance has been connected to the bbdd: " + myConnection.getUrl());
        System.out.println("My connection instance has been connected to the bbdd: " + myConnection2.getUrl());

    }

}
