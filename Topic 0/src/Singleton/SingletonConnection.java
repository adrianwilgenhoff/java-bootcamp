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
class SingletonConnection {

    private static SingletonConnection INSTANCE = null;
    private static Connection myConnection = null;
    private static String url;

    private SingletonConnection(String url) {

        this.url = url;

    }

    public static SingletonConnection getInstance(String url, String user, String pass) {
        if (INSTANCE == null) {

            try {
                myConnection = DriverManager.getConnection(url, user, pass);
                INSTANCE = new SingletonConnection(url);
                System.out.println("CONNECTION SUCCESFULL");
            } catch (SQLException e) {
                System.out.println("CONNECTION REFUSED");
            }

        }
        return INSTANCE;
    }

    public static String getUrl() {

        return url;
    }

}
