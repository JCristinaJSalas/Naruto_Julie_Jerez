/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.narutojava.julie.DAO;

/**
 *
 * @author user
 */
public interface ISaveDAO<T> extends IDAO {
      void save(T t);
}
