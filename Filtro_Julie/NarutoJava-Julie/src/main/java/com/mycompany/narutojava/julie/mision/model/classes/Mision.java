/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.mision.model.classes;

/**
 *
 * @author user
 */
public class Mision {
    private int misionId;
    private String descripcion;
    private String rango;
    private String recompensa;

    
    //constructer
    public Mision() {
    }

    public Mision( String descripcion, String rango, String recompensa) {
        
        this.descripcion = descripcion;
        this.rango = rango;
        this.recompensa = recompensa;
    }
    
    
    //getter and setters

    public int getMisionId() {
        return misionId;
    }

    public void setMisionId(int misionId) {
        this.misionId = misionId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }
    
    //toStirng

    @Override
    public String toString() {
        return "Mision{" + "misionId=" + misionId + ", descripcion=" + descripcion + ", rango=" + rango + ", recompensa=" + recompensa + '}';
    }
    
    
}
