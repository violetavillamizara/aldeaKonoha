/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.aldea.modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author user
 */
public class ManejoArchivos {

    File archivo;
    
    //informe de misiones completadas
    
    public void verMisionesCompletadas(String nombreArchivo) throws FileNotFoundException, IOException{
        File archivo = new File(nombreArchivo);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String lectura = reader.readLine();
            while(lectura !=null){
                System.out.println(lectura);
                lectura = reader.readLine();
            }
            reader.close();
        } catch(IOException e){
            System.out.println(e);
        }
    }
    
    //crear con el nombre del archivo
    private void crearArchivo(String nombreArchivo) throws IOException{
        archivo = new File(nombreArchivo);
        
        try{
            if(archivo.createNewFile()){
                System.out.println("Creado como: " +archivo.getName());
            }    
        } catch(IOException ex){
            System.err.println("No se creó " + ex);
        }
    }
    
    private void escribirArchivo(String texto){
        
        try{
            javax.swing.JFileChooser jfile = new javax.swing.JFileChooser();
            jfile.showOpenDialog(jfile);
            String path = jfile.getSelectedFile().getAbsolutePath();
            
            archivo = new File(path);
            
            try (FileWriter writer = new FileWriter(archivo, true)) {
                writer.write(texto);
                writer.close();
            }
            System.out.println("acción completada");
            
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }

    }
    
    private void sobreescribirArchivo(String texto){
        try{
            javax.swing.JFileChooser jfile = new javax.swing.JFileChooser();
            jfile.showOpenDialog(jfile);
            String path = jfile.getSelectedFile().getAbsolutePath();
            
            archivo = new File(path);
            
            try (FileWriter writer = new FileWriter(archivo)) {
                writer.write(texto);
                writer.close();
            }
            System.out.println("acción completada");
            
        } catch(IOException ex){
            System.err.println(ex.getMessage());
        }
    }
    
    private void eliminarArchivo(String nombreArchivo){
        archivo = new File(nombreArchivo);
        
        if(archivo.exists()){
            archivo.delete();
            System.out.println("Se eliminó el archivo: " + archivo.getName()+" ruta: "+archivo.getAbsolutePath());
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        ManejoArchivos info = new ManejoArchivos();
        
        info.crearArchivo("pruebaInforms");
        
        
        
    }
    
}
