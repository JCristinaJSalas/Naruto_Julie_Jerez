package com.mycompany.narutojava.julie.MisionNinja.Controller;


import com.mycompany.narutojava.julie.MisionNinja.model.DAO.MisionNinjaDAO;
import com.mycompany.narutojava.julie.MisionNinja.model.classes.MisionNinja;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
public class MisionNinjaController {
     private static MisionNinjaDAO misionNinjaDAO = new MisionNinjaDAO();

    
     public void insertMisionNinja(MisionNinja mision) {
        misionNinjaDAO.save(mision);
    }
}
