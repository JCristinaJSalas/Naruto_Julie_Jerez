/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.narutojava.julie.DAO;

/**
 *
 * @author user
 */
public interface IGetByIdDAO<T> extends IDAO{
    /**
     * Retrieves an object by its unique identifier.
     *
     * @param id The unique identifier of the object.
     * @return The object with the specified identifier, or null if not found.
     */
    T getById(int id);
}
