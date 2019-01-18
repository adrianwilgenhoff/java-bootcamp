/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 * AbstractProduct NOSQL :Interfaces que definen la estructura de los objetos
 * para crear familias. Define la interfaz de los objetos de tipo MongoConn
 * MariaConn.
 *
 * @author Adrian
 */
public abstract class NOSQLConn {

    public abstract NOSQLConn getInstance();

}
