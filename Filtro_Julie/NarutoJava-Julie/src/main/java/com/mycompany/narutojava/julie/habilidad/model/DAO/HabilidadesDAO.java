/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.habilidad.model.DAO;

import com.mycompany.narutojava.julie.DAO.IDeleteDAO;
import com.mycompany.narutojava.julie.DAO.ISaveDAO;
import com.mycompany.narutojava.julie.habilidad.model.classes.Habilidad;
import com.mycompany.narutojava.julie.persistence.BDConnection;
import com.mycompany.narutojava.julie.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class HabilidadesDAO implements ISaveDAO<Habilidad>, IDeleteDAO<Habilidad> {

    public void save(Habilidad habilidades) {

        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO Habilidad ( NinjaID, Nombre, Descripcion) VALUES (?, ?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setInt(1, habilidades.getNinjaID());
            ps.setString(2, habilidades.getNombre());
            ps.setString(3, habilidades.getDescripcion());

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

    public void delete(int habilidadesID) {
        //Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM Habilidad WHERE HabilidadID = ?;";

        // use Operation class with insert_update_delete and verify if the rows in database are affected
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setInt(1, habilidadesID);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete habilidad");
                return;
            } else {
                System.out.println("not exists habilidad");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete habilidad");
        return;
    }

    
    public Habilidad getById(int HabilidadID) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from Habilidad where HabilidadID = ? ;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, HabilidadID);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Habilidad habilidad = new Habilidad();
                habilidad.setNinjaID(rs.getInt("NinjaID"));
                habilidad.setNombre(rs.getString("Nombre"));
                habilidad.setDescripcion(rs.getString("Descripcion"));

                return habilidad;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
