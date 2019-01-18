/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import java.sql.Connection;

/**
 *
 * @author Adrian
 */
public class Client {

    public static void main(String[] args) {
        ConnectionAbstractFactory factory = new SQLConnFactory();
        SQLConn conn = factory.createSQLConn("mysql");
        Connection connection = conn.getConnection();

        System.out.println("User: " + conn.getInstance().getUser());

    }

}
