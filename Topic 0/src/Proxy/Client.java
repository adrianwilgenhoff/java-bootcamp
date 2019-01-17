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
public class Client {

    public static void main(String[] args) {
        SQLConnectionProxy conn = new SQLConnectionProxy();
        try {
            conn.connect("root", "", "jdbc:mysql://localhost:3306/usuarios");
        } catch (Exception e) {
        }

    }

}
