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
public class MariaConn extends NOSQLConn {

    private MariaConn instance = null;

    @Override
    public MariaConn getInstance() {
        if (instance == null) {
            instance = new MariaConn();
        }

        return instance;
    }

}
