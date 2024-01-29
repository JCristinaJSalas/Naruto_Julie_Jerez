/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.ninja.model.clases;

import com.mycompany.narutojava.julie.habilidad.model.classes.Habilidad;
import java.util.List;

/**
 *
 * @author user
 */
public class NinjaHabilidades extends Ninja{
     private List<Habilidad> habilidad;

     
     public NinjaHabilidades() {
       
    }
     
    public NinjaHabilidades(List<Habilidad> habilidad, int ninjaID, String nombre, String rango, String aldea) {
        super(ninjaID, nombre, rango, aldea);
        this.habilidad = habilidad;
    }

    public List<Habilidad> getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(List<Habilidad> habilidad) {
        this.habilidad = habilidad;
    }

 @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\n ===== \n");
        if(habilidad != null){
            for (Habilidad s : habilidad){
                sb.append(s + "\n");
            }
        }
        return sb.toString();
    }

}
