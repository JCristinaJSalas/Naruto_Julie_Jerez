/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.MisionNinja.model.DAO;

import com.mycompany.narutojava.julie.MisionNinja.model.classes.MisionNinja;
import com.mycompany.narutojava.julie.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class MisionNinjaDAO {
        public void save(MisionNinja misionNinja) {

        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO MisionNinja ( NinjaID, MisionID, FechaInicio, FechaFin) VALUES (?, ?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setInt(1, misionNinja.getNinjaID());
            ps.setInt(2,misionNinja.getMisionID());
            ps.setString(3,misionNinja.getFechaInicio().toString());
            ps.setString(4,null);
            

            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push habilidad");
            } else {
                System.out.println("Successful push habilidad");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
