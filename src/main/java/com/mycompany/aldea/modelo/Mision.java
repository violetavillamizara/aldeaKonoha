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
public class Mision {
    //attributes
    private Long misionID;
    private String descripcion;
    private RangoMision rango;
    private Long recompensa;
    private List<Ninja> ninjas;
    
    
    //void constructor

    public Mision() {
    }
    
    //constructor method

    public Mision(Long misionID, String descripcion, RangoMision rango,Long recompensa, List<Ninja> ninjas) {
        this.misionID = misionID;
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
        this.ninjas = ninjas;
    }

    //getters
    public Long getMisionID() {
        return misionID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public RangoMision getRango() {
        return rango;
    }

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public Long getRecompensa() {
        return recompensa;
    }
    
    
    //setters
    public void setMisionID(Long misionID) {
        this.misionID = misionID;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setRango(RangoMision rango) {
        this.rango = rango;
    }

    public void setNinjas(List<Ninja> ninjas) {
        this.ninjas = ninjas;
    }

    public void setRecompensa(Long recompensa) {
        this.recompensa = recompensa;
    }
    
    
}
