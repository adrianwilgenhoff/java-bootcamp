/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Producto concreto
 *
 * @author Adrian
 */
public class OracleConn extends SQLConn {

    private String user = "chino";
    private String pass = "chino";
    private String url = "jdbc:oracle://localhost:3066/db";
    private MySQLConn instance = null;
    private Connection conn = null;

    @Override
    public MySQLConn getInstance() {
        if (instance == null) {
            instance = new MySQLConn();
        }

        return instance;
    }

    @Override
    public Connection getConnection() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(user, pass, url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}
