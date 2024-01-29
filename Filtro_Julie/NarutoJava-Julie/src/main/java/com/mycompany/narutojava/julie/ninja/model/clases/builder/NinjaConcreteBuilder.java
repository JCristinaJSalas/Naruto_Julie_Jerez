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
public class NinjaConcreteBuilder implements NinjaBuilder {

    private Ninja ninja = new Ninja();

    @Override
    public NinjaBuilder ninjaID(int ninjaID) {
        ninja.setNinjaID(ninjaID);
        return this;
    }

    @Override
    public NinjaBuilder nombre(String nombre) {
        ninja.setNombre(nombre);
        return this;
    }

    @Override
    public NinjaBuilder rango(String rango) {
        ninja.setRango(rango);
        return this;
    }

    @Override
    public NinjaBuilder aldea(String aldea) {
        ninja.setAldea(aldea);
        return this;
    }
public Ninja build(){
    return ninja;
}
}
