/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Adrian
 */
public class Client {

    public static void main(String[] args) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.setConnectionBuilder(new ConnectionMySQL());
        connectionManager.constructConnection();
        ConnectionBBDD conn = connectionManager.getConnection();
        
        try {
            Connection myConnection = DriverManager.getConnection(conn.getUrl(), conn.getUser(), conn.getPw());
            System.out.println("CONNECTION SUCCESFULL");

        } catch (SQLException e) {
            System.out.println("CONNECTION REFUSED");
            e.printStackTrace();
        }
    }

}
