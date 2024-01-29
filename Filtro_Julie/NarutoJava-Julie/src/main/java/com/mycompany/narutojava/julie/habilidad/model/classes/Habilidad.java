/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.habilidad.model.classes;

/**
 *
 * @author user
 */
public class Habilidad {
    private int HabilidadID;
    private int NinjaID;
    private String Nombre;
    private String Descripcion;

    
    //constructor
    public Habilidad() {
    }

    public Habilidad( int NinjaID, String Nombre, String Descripcion) {
        this.NinjaID = NinjaID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
    }
    
    //getter setter

    public int getHabilidadID() {
        return HabilidadID;
    }

    public void setHabilidadID(int HabilidadID) {
        this.HabilidadID = HabilidadID;
    }

    public int getNinjaID() {
        return NinjaID;
    }

    public void setNinjaID(int NinjaID) {
        this.NinjaID = NinjaID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    
    
    //tostring

    @Override
    public String toString() {
        return "Habilidad{" + "HabilidadID=" + HabilidadID + ", NinjaID=" + NinjaID + ", Nombre=" + Nombre + ", Descripcion=" + Descripcion + '}';
    }
    
}