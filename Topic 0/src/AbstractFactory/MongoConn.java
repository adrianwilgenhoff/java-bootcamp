/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 * Producto concreto
 *
 * @author Adrian
 */
public class MongoConn extends NOSQLConn {

    private MongoConn instance = null;
    //private OtherConnection conn = null;

    @Override
    public MongoConn getInstance() {
        if (instance == null) {
            instance = new MongoConn();
        }

        return instance;
    }

    /* @Override
    public OtherConnection getConnection() {
        /* OtherConnection is just an interface, we cannot instantiate it. For that reason, this method returns conn to complete the implementation. */
 /*     return conn;
    }

    @Override
    public void releaseConnection() {
        conn = null;

    }**/
}
