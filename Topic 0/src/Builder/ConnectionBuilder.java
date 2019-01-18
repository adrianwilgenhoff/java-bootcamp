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
public abstract class ConnectionBuilder {

    protected ConnectionBBDD connection;
    //protected String url;

    public ConnectionBBDD getConnection() {

        return connection;

    }

    public void createConnection() {

        connection = new ConnectionBBDD();

    }

    public abstract void buildDriver();
    public abstract void buildUser();
    public abstract void buildPW();
}
