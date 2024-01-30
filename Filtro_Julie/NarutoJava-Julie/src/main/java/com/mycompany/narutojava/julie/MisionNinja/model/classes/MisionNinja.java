/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.MisionNinja.model.classes;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public class MisionNinja {
    private int MisionID;
    private int NinjaID;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    //constructor
    public MisionNinja() {
    }

    public MisionNinja(int MisionID, int NinjaID, LocalDate fechaInicio, LocalDate fechaFin) {
        this.MisionID = MisionID;
        this.NinjaID = NinjaID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }
//getter and setters
    public int getMisionID() {
        return MisionID;
    }

    public void setMisionID(int MisionID) {
        this.MisionID = MisionID;
    }

    public int getNinjaID() {
        return NinjaID;
    }

    public void setNinjaID(int NinjaID) {
        this.NinjaID = NinjaID;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "MisionNinja{" + "MisionID=" + MisionID + ", NinjaID=" + NinjaID + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + '}';
    }
    
    
}
