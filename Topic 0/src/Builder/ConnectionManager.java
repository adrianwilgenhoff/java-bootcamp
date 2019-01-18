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
public class ConnectionManager {

    private ConnectionBuilder connectionBuilder;

    public void constructConnection() {
        connectionBuilder.createConnection();
        connectionBuilder.buildDriver();
        connectionBuilder.buildPW();
        connectionBuilder.buildUser();

    }

    /*public ConnectionManager(ConnectionBuilder conn) {

        this.connectionBuilder = conn;

    }*/

    public void setConnectionBuilder(ConnectionBuilder conn) {

        this.connectionBuilder = conn;

    }

    public ConnectionBBDD getConnection() {

        return connectionBuilder.getConnection();

    }

}
