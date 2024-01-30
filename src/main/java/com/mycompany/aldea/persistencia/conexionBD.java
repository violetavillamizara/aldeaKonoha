/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.persistencia;

import java.sql.*;
/**
 *
 * @author user
 */
public abstract class conexionBD {

    private static String url = "";
    private static String user = "";
    private static String password = "";
    public static Connection conexion = null;
    
    public static Connection MySQLConnection(){
        url = "jdbc:mysql://localhost/naruto_violetavillamizar";
        user = "root";
        password = "campus2024";
        return getConnection(url, user, password);
    }
    
    private static Connection getConnection(String url,String user, String password){
        try {
            // Conexion
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null) {
                DatabaseMetaData meta = conexion.getMetaData();
                System.out.println("Base de datos conectada " + meta.getDriverName());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conexion;
    }
}
