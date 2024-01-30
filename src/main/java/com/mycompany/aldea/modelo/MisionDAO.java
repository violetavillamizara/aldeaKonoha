/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.modelo;

import com.mycompany.aldea.persistencia.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MisionDAO {
    
//    public List<Mision> misionesCompletadas(){
//        List<Mision> misiones = new ArrayList<>();
//        try (Connection connection = conexionBD.MySQLConnection()) {
//            String sql = "SELECT * FROM mision_ninja WHERE fecha_fin != NULL ";
//            try (PreparedStatement statement = connection.prepareStatement(sql);
//                 ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    Mision mision = new Mision();
//                    mision.setMisionID(resultSet.getLong("id"));
//                    mision.setMisionID(resultSet.getLong("id"));
//                    mision.setDescripcion(resultSet.getString("descripcion"));
//                    mision.setRango(RangoMision.valueOf(resultSet.getString("rango")));
//                    mision.setRecompensa(resultSet.getLong("recompensa"));
//                    misiones.add(mision);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return misiones;
//    }
//    
//    public List<Mision> misionesDisponibles(){
//        List<Mision> misiones = new ArrayList<>();
//        try (Connection connection = conexionBD.MySQLConnection()) {
//            String sql = "SELECT * FROM mision_ninja WHERE fecha_fin = NULL ";
//            try (PreparedStatement statement = connection.prepareStatement(sql);
//                 ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    Mision mision = new Mision();
//                    mision.setMisionID(resultSet.getLong("id"));
//                    mision.setMisionID(resultSet.getLong("id"));
//                    mision.setDescripcion(resultSet.getString("descripcion"));
//                    mision.setRango(RangoMision.valueOf(resultSet.getString("rango")));
//                    mision.setRecompensa(resultSet.getLong("recompensa"));
//                    misiones.add(mision);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return misiones;
//    }

    public List<Mision> getAllMisiones() {
        List<Mision> misiones = new ArrayList<>();
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "SELECT * FROM mision";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Mision mision = new Mision();
                    mision.setMisionID(resultSet.getLong("id"));
                    mision.setDescripcion(resultSet.getString("descripcion"));
                    mision.setRango(RangoMision.valueOf(resultSet.getString("rango")));
                    mision.setRecompensa(resultSet.getLong("recompensa"));
                    mision.setRecompensa(resultSet.getLong("recompensa"));
                    misiones.add(mision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return misiones;
    }

//    public List<Mision> getMisionesCompletadasByNinja() {
//        
//    }

    public void insertMision(Mision mision) {
        
    }

    public void updateMision() {

    }

    public void deleteMision(Long misionID) {

        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "DELETE FROM mision WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, misionID);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
