/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.modelo;

/**
 *
 * @author user
 */
public class Habilidad {

   //attributes
    private Long habilidadID;
    private String nombre;
    private String descripcion;
    private Ninja ninjaID;

    //void
    public Habilidad() {
    }
    
    //constructor method
    public Habilidad(Long habilidadID, String nombre, String descripcion, Ninja ninjaID) {
        this.habilidadID = habilidadID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ninjaID = ninjaID;
    }

    //getters
    public Long getHabilidadID() {
        return habilidadID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Ninja getNinjaID() {
        return ninjaID;
    }
    
    //setters

    public void setHabilidadID(Long habilidadID) {
        this.habilidadID = habilidadID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNinjaID(Ninja ninjaID) {
        this.ninjaID = ninjaID;
    }
    
    
    
}
