/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

/**
 *
 * @author Adrian
 *
 * FactoryConcrete: Representan las fábricas concretas que servirán para crear
 * las instancias de todas las clases de la familia. En esta clase debe existir
 * un método para crear cada una de las clases de la familia. En este caso como
 * familia tengo a MySQLConn y OracleConn.Implementa la interfaz de la
 * FabricaAbstracta para la creación de los distintos productos concretos.
 *
 *
 */
public class SQLConnFactory extends ConnectionAbstractFactory {

    @Override
    public SQLConn createSQLConn(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("mysql")) {
            return new MySQLConn();
        }
        if (type.equalsIgnoreCase("oracle")) {
            return new OracleConn();
        }
        return null;
    }

    @Override
    public NOSQLConn createNOSQLConn(String type) {
        return null;
    }
}
