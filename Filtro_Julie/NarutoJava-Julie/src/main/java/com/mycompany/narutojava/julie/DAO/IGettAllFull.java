/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.narutojava.julie.DAO;

import java.util.List;

/**
 *
 * @author user
 */
public interface IGettAllFull <T> extends IDAO{

    /**
     * Retrieves a list of all entities of type T, potentially including all detailed information for each entity.
     * 
     * @return A List of entities of type T, which may include comprehensive details for each entity.
     */
    List<T> getAllFull();
}