/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.modelo;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class MisionNinja {

    private Long id;
    private Long misionID;
    private Long ninjaID;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public MisionNinja(Long id, Long misionID, Long ninjaID, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id = id;
        this.misionID = misionID;
        this.ninjaID = ninjaID;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMisionID() {
        return misionID;
    }

    public void setMisionID(Long misionID) {
        this.misionID = misionID;
    }

    public Long getNinjaID() {
        return ninjaID;
    }

    public void setNinjaID(Long ninjaID) {
        this.ninjaID = ninjaID;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public MisionNinja() {
    }
    
    
    
}
