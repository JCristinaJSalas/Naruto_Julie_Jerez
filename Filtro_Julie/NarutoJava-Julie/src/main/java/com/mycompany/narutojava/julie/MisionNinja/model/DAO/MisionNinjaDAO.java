/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.MisionNinja.model.DAO;

import com.mycompany.narutojava.julie.MisionNinja.model.classes.MisionNinja;
import com.mycompany.narutojava.julie.persistence.BDConnection;
import com.mycompany.narutojava.julie.persistence.Operations;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            ps.setInt(2, misionNinja.getMisionID());
            ps.setString(3, misionNinja.getFechaInicio().toString());
            ps.setString(4, null);

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
    
    public List<MisionNinja> getAll() {
        List<MisionNinja> listMisionNinja = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM misionninja";
        
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);
            while (rs.next()) {
                MisionNinja mision = new MisionNinja();
                mision.setMisionID(rs.getInt("MisionID"));
                mision.setNinjaID(rs.getInt("NinjaID"));
                mision.setFechaInicio(LocalDate.parse(rs.getString("FechaInicio")));
                mision.setFechaFin(null);
                
                listMisionNinja.add(mision);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMisionNinja;
    }
    
    public void update(MisionNinja t) {
        try (Connection connection = BDConnection.MySQLConnection(); PreparedStatement ps = connection.prepareStatement("UPDATE misionninja SET FechaFin = ? WHERE NinjaID = ? AND MisionID = ?")) {
            ps.setString(1, t.getFechaFin().toString());
            ps.setInt(2, t.getNinjaID());
            ps.setInt(3, t.getMisionID());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
