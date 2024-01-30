/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aldea.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public abstract class Operaciones {
    
    public static Connection conexion;
    public static Statement stmt = null;
    public static ResultSet rs = null;

    public static Connection getConexion() {
        return conexion;
    }
    
    public static void closeConnection(Connection conexion){
        if(conexion !=null){
            try {
                conexion.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public static ResultSet consultas(PreparedStatement sentencia){
        try {
            rs = sentencia.executeQuery();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR: " + sqlex);
            return null;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return rs;
    }
    
    
    public static int insertar_actualizar_borrar(PreparedStatement sentencia){
        int filas;
        try {
            filas = sentencia.executeUpdate();
        } catch (SQLException | RuntimeException sqlex) {
            System.out.println("ERROR" + sqlex);
            return 0;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return 0;
        }
        return filas;
    }
    
    
    public static boolean setAutoCommitBD(boolean parametro) {
        try {
            conexion.setAutoCommit(parametro);
        } catch (SQLException sqlex) {
            System.out.println("Error al configurar el autoCommit " + sqlex.getMessage());
            return false;
        }
        return true;
    }

    public static void cerrarConexion() {
        closeConnection(conexion);
    }

    public static boolean commitBD() {
        try {
            conexion.commit();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer commit " + sqlex.getMessage());
            return false;
        }
    }

    public static boolean rollbackBD() {
        try {
            conexion.rollback();
            return true;
        } catch (SQLException sqlex) {
            System.out.println("Error al hacer rollback " + sqlex.getMessage());
            return false;
        }
    }
    
}
