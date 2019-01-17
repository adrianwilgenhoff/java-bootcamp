/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

/**
 *
 * @author Adrian
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnectionReal implements SQLConnection {

    @Override
    public void connect(String user, String pass, String url) {

        try {
            Connection myConnection = DriverManager.getConnection(url, user, pass);
            System.out.println("CONNECTION SUCCESFULL");

        } catch (SQLException e) {
            System.out.println("CONNECTION REFUSED");
        }

    }
}
