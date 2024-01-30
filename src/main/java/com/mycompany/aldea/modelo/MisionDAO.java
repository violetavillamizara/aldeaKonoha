/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.modelo;

import com.mycompany.aldea.persistencia.Operaciones;
import static com.mycompany.aldea.persistencia.Operaciones.rs;
import com.mycompany.aldea.persistencia.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MisionDAO {
    
    public List<MisionNinja> misionesCompletadas(){
        List<MisionNinja> misiones = new ArrayList<>();
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "SELECT * FROM mision_ninja WHERE fecha_fin is not NULL ";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    MisionNinja mision = new MisionNinja();
                    mision.setId(resultSet.getLong("id"));
                    mision.setMisionID(resultSet.getLong("misionId"));
                    mision.setNinjaID(resultSet.getLong("ninjaId"));
                    mision.setFecha_inicio(LocalDate.parse(resultSet.getString("fecha_inicio")));
                    mision.setFecha_fin(LocalDate.parse(resultSet.getString("fecha_fin")));
                    misiones.add(mision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return misiones;
    }
    
    public List<MisionNinja> misionesDisponibles(){
        List<MisionNinja> misiones = new ArrayList<>();
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "SELECT * FROM mision_ninja WHERE fecha_fin is NULL ";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    MisionNinja mision = new MisionNinja();
                    mision.setId(resultSet.getLong("id"));
                    mision.setMisionID(resultSet.getLong("misionId"));
                    mision.setNinjaID(resultSet.getLong("ninjaId"));
                    mision.setFecha_inicio(LocalDate.parse(resultSet.getString("fecha_inicio")));
//                    mision.setFecha_fin(resultSet.getString("fecha_fin") == null ? null : LocalDate.parse(resultSet.getString("fecha_fin")));
                    mision.setFecha_fin(null);
                    misiones.add(mision);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return misiones;
    }

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
                    mision.setRango(resultSet.getString("rango"));
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
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "INSERT INTO mision (id, descripcion, rango, recompensa) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, mision.getMisionID());
                statement.setString(2, mision.getDescripcion());
                statement.setString(3, mision.getRango());
                statement.setLong(4, mision.getRecompensa());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateMision() {

    }

    public void deleteMision(Long misionID) {

        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "DELETE FROM mision WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, misionID);
                int rows = Operaciones.insertar_actualizar_borrar(statement);
            if (rows <= 0) {
                System.out.println("No se pudo DEL MISION");
            } else {
                System.out.println("MISION DEL exitosamente");
            }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
