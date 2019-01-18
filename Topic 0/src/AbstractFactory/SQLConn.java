/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import java.sql.Connection;

/**
 * AbstractProduct SQL :Interfaces que definen la estructura de los objetos para
 * crear familias. Define la interfaz de los objetos de tipo MySQLCOnn
 * OracleConn
 *
 * @author Adrian
 */
public abstract class SQLConn {

    public abstract MySQLConn getInstance();

    public abstract Connection getConnection();

}
