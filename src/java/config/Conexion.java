/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import java.sql.*;
/**
 *
 * @author estua
 */
public class Conexion {
    Connection con;
    String url = "jdbc:mysql://localhost:3306/bd_ventas";
    String user = "root";
    String pass = "";
    public Connection Conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            //TODO: handle exception
        }        
        return con;
    }
}
