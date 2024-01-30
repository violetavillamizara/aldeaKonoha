/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.modelo;
import com.mycompany.aldea.persistencia.Operaciones;
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
public class NinjaDAO {

    public List<Ninja> getAllNinjas(){
        List<Ninja> ninjas = new ArrayList<>();
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "SELECT * FROM ninja";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ninja ninja = new Ninja();
                    ninja.setNinjaID(resultSet.getLong("id"));
                    ninja.setNombre(resultSet.getString("nombre"));
                    ninja.setRango((resultSet.getString("rango")));
                    ninja.setAldea(resultSet.getString("aldea"));
                    ninjas.add(ninja);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ninjas;
    }
    
    
    public List<Ninja> getAllNinjasHabilities(){
        List<Ninja> ninjas = new ArrayList<>();
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "SELECT * FROM ninja"
                    + "JOIN habilidad"
                    + "ON ninja.id = habilidad.ninjaId";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ninja ninja = new Ninja();
                    ninja.setNinjaID(resultSet.getLong("id"));
                    ninja.setNombre(resultSet.getString("nombre"));
                    ninja.setRango((resultSet.getString("rango")));
                    ninja.setAldea(resultSet.getString("aldea"));
                    //habilidad
                    ninjas.add(ninja);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ninjas;
    }
    
    public void insertNinja(Ninja ninja){
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "INSERT INTO ninja (id, nombre, rango, aldea) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, ninja.getNinjaID());
                statement.setString(2, ninja.getNombre());
                statement.setString(3, ninja.getRango());
                statement.setString(4, ninja.getAldea());
                
                
                int rows = Operaciones.insertar_actualizar_borrar(statement);
            if (rows <= 0) {
                System.out.println("No se pudo agregar el Ninja");
            } else {
                System.out.println("Ninja agregado exitosamente");
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updateNinja(){
        
    }
    
    public void deleteNinja(Long ninjaID){
        try (Connection connection = conexionBD.MySQLConnection()) {
            String sql = "DELETE FROM ninja WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, ninjaID);
                int rows = Operaciones.insertar_actualizar_borrar(statement);
            if (rows <= 0) {
                System.out.println("No se pudo DEL el Ninja");
            } else {
                System.out.println("Ninja DEL exitosamente");
            }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
