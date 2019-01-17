/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proxy;

/**
 *
 * @author Adrian
 */
public class SQLConnectionProxy implements SQLConnection {

    SQLConnection connReal;

    public SQLConnectionProxy() {

        connReal = new SQLConnectionReal();
    }

    public void connect(String user, String pass, String url) throws Exception {
        System.out.println("CONNECTING...");
        connReal.connect(user, pass, url);
    }

}
