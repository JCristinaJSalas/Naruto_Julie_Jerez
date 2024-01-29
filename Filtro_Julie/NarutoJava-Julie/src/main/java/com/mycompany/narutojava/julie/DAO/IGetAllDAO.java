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
public interface IGetAllDAO<T> extends IDAO{
    /**
     * Retrieves a list of all objects of the specified type.
     *
     * @return A list containing all objects of the specified type.
     */
    List<T> getAll();
}
