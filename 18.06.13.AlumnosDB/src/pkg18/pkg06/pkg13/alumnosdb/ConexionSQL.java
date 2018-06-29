/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg18.pkg06.pkg13.alumnosdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seba
 */
public class ConexionSQL {
    //atributos - caracteristicas propias (privadas)
    static Connection conectar;
    static final String driver = "com.mysql.jdbc.Driver";
    static final String user = "root";
    static final String pass = "32412433";
    static final String url = "jdbc:mysql://localhost:3306/Facultad";
    
    //propiedades caracteristicas (publicas)
    //constructor
    public ConexionSQL() {
        conectar = null;
    }
    
    //metodos
    public Connection Conectar2 () throws ClassNotFoundException {
        conectar = null;
        
        Class.forName(driver);
        try {
            conectar = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            System.out.println("Error de conexion" + ex);
        }
    return conectar;
    
    }

}