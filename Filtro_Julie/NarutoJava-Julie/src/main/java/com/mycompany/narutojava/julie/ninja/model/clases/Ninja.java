package com.mycompany.narutojava.julie.ninja.model.clases;

public class Ninja {
    private int ninjaID;
    private String nombre;
    private String rango;
    private String aldea;
    
//constructor

    public Ninja() {
    }

    
    public Ninja(int ninjaID, String nombre, String rango, String aldea) {
        this.ninjaID = ninjaID;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }
    
    
    //gettera y setter
    public int getNinjaID() {
        return ninjaID;
    }

    public void setNinjaID(int NinjaID) {
        this.ninjaID = NinjaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }
    
    //tostring

    @Override
    public String toString() {
        return "Ninja{" + "NinjaID=" + ninjaID + ", nombre=" + nombre + ", rango=" + rango + ", aldea=" + aldea + '}';
    }
    
    
}

