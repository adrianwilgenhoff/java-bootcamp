/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Builder;

/**
 *
 * @author Adrian
 */
public class ConnectionMySQL extends ConnectionBuilder {

    private final String driver = "jdbc:mysql://localhost:3306/";

    @Override
    public void buildUser() {

        connection.setUser("root");
    }

    @Override
    public void buildPW() {

        connection.setPw("");
    }

    @Override
    public void buildDriver() {

        connection.setUrl(driver+"usuarios");
    }

}
