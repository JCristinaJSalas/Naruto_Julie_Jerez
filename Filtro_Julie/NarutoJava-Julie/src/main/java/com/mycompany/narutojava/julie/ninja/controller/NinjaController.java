/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.ninja.controller;

import com.mycompany.narutojava.julie.ninja.model.DAO.NinjaDAO;
import com.mycompany.narutojava.julie.ninja.model.clases.Ninja;
import java.util.List;

/**
 *
 * @author user
 */
public class NinjaController {
    private static NinjaDAO ninjaDAO = new NinjaDAO();

    
     public void insertNinja(Ninja ninja) {
        ninjaDAO.save(ninja);
    }
    public void deleteNinja(int ninjaId) {
        ninjaDAO.delete(ninjaId);
    }
    public List<Ninja> getAllNinjas(){
        return ninjaDAO.getAll();
    }
  
}
