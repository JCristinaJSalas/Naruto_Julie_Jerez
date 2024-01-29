/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.ninja.model.clases.builder;

import com.mycompany.narutojava.julie.ninja.model.clases.Ninja;

/**
 *
 * @author user
 */
public interface NinjaBuilder {
    NinjaBuilder ninjaID( int ninjaID);
    NinjaBuilder nombre( String nombre);
    NinjaBuilder rango( String rango);
    NinjaBuilder aldea( String aldea);

    public Ninja build();
    
}
