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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConn extends SQLConn {

    private String user = "root";
    private String pass = "";
    private String url = "jdbc:mysql://localhost:3306/usuarios";
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

                conn = DriverManager.getConnection(url, user, pass);
                System.out.println("CONNECTION SUCCESFULL");
            }
        } catch (SQLException e) {
            System.out.println("CONNECTION REFUSED");
        }

        return conn;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
}
