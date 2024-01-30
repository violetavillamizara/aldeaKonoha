/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.mycompany.aldea.modelo;

/**
 *
 * @author user
 */
public enum RangoMision {
    diez("10", "diez"),
    veinte("20", "veinte"),
    treinta("30", "treinta"),
    cuarenta("40", "cuarenta"),
    cincuenta("50", "cincuenta"),
    sesenta("60", "sesenta");
    
    private String nombre;
    private String numero;

    private RangoMision(String nombre, String numero) {
        this.nombre = nombre;
        this.numero = numero;
    }
    
}
