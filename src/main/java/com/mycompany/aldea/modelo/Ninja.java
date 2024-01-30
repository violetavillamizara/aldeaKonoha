/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.modelo;

import java.util.List;

/**
 *
 * @author user
 */
public class Ninja {

    //attributes
    private Long ninjaID;
    private String nombre;
    private RangoNinja rango;
    private String aldea;
    private List<Mision> misiones;
    
    //void constructor

    public Ninja() {
    }

    //constructor method
    public Ninja(Long ninjaID, String nombre, RangoNinja rango, String aldea, List<Mision> misiones) {
        this.ninjaID = ninjaID;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
        this.misiones = misiones;
    }

    //getters
    public Long getNinjaID() {
        return ninjaID;
    }

    public String getNombre() {
        return nombre;
    }

    public RangoNinja getRango() {
        return rango;
    }

    public String getAldea() {
        return aldea;
    }

    public List<Mision> getMisiones() {
        return misiones;
    }

    
    //setters
    public void setNinjaID(Long ninjaID) {
        this.ninjaID = ninjaID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRango(RangoNinja rango) {
        this.rango = rango;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }

    public void setMisiones(List<Mision> misiones) {
        this.misiones = misiones;
    }
    
    
    
    
}
