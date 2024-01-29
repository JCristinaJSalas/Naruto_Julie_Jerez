/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.habilidad.controller;

import com.mycompany.narutojava.julie.habilidad.model.DAO.HabilidadesDAO;
import com.mycompany.narutojava.julie.habilidad.model.classes.Habilidad;

/**
 *
 * @author user
 */
public class HabilidadController {
    private static HabilidadesDAO habilidadDAO = new HabilidadesDAO();

    
     public void insertHabilidad(Habilidad habilidad) {
        habilidadDAO.save(habilidad);
    }
    public void deleteHabilidad(int habilidadId) {
        habilidadDAO.delete(habilidadId);
    }
}
