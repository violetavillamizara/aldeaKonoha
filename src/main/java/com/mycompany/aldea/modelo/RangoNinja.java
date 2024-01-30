/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.aldea.modelo;

/**
 *
 * @author user
 */
public enum RangoNinja {
    uno("1", "uno"),
    dos("2", "dos"),
    tres("3", "tres"),
    cuatro("4", "cuatro"),
    cinco("5", "cinco"),
    seis("6", "seis");
    
    private String nombre;
    private String numero;

    private RangoNinja(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
  
}
