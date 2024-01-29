/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.narutojava.julie.DAO;

/**
 *
 * @author user
 */
public interface IDeleteDAO<T> extends IDAO{
    /**
     * Deletes an object from the database based on its unique identifier.
     *
     * @param id The unique identifier of the object to be deleted.
     */
    void delete(int id);
}

