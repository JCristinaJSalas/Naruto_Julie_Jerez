/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.mision.model.DAO;

import com.mycompany.narutojava.julie.DAO.IDeleteDAO;
import com.mycompany.narutojava.julie.DAO.ISaveDAO;
import com.mycompany.narutojava.julie.mision.model.classes.Mision;
import com.mycompany.narutojava.julie.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class MisionDAO implements ISaveDAO<Mision>, IDeleteDAO<Mision> {
    
    
    
        public void save(Mision mision) {


        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO Mision ( Descripcion, Rango, Recompensa) VALUES (?,?,?);";
        
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, mision.getDescripcion());
            ps.setString(2, mision.getRango());
            ps.setString(3, mision.getRecompensa());

            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push mision");
            } else {
                System.out.println("Successful push mision");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
     public void delete(int misionID) {
        //Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM Mision WHERE MisionID = ?;";

        // use Operation class with insert_update_delete and verify if the rows in database are affected
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setInt(1, misionID);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete mision");
                return;
            } else {
                System.out.println("not exists mision");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete mision");
        return;
    }    
        
        
        
        
}
