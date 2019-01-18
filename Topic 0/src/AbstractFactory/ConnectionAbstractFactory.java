/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 *
 * @author Adrian
 */

/*
*   AbstractFactory: Es la definición de la interfaces de las factorías. 
*   Debe de proveer un método para la obtención de cada objeto que pueda crear. 
*   ("crearConexionNOSQL" y "crearConexionSQL()")
 */
public abstract class ConnectionAbstractFactory {

    public abstract SQLConn createSQLConn(String type);

    public abstract NOSQLConn createNOSQLConn(String type);

}
