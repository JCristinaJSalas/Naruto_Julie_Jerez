/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.mision.controller;

import com.mycompany.narutojava.julie.mision.model.DAO.MisionDAO;
import com.mycompany.narutojava.julie.mision.model.classes.Mision;
import com.mycompany.narutojava.julie.ninja.model.clases.Ninja;
import java.util.List;

/**
 *
 * @author user
 */
public class MisionController {
    private static MisionDAO misionDAO = new MisionDAO();

    
     public void insertMision(Mision mision) {
        misionDAO.save(mision);
    }
    public void deleteMision(int misionId) {
        misionDAO.delete(misionId);
    }
  
    public List<Mision> getAllMision(){
        return misionDAO.getAll();
    }       
    
    public Mision getByIdMision(int misionId){
        return misionDAO.getById(misionId);
    }
}