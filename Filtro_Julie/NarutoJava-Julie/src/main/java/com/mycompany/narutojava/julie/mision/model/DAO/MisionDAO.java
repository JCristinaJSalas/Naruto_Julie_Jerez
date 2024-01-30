/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.narutojava.julie.mision.model.DAO;

import com.mycompany.narutojava.julie.DAO.IDeleteDAO;
import com.mycompany.narutojava.julie.DAO.ISaveDAO;
import com.mycompany.narutojava.julie.mision.model.classes.Mision;
import com.mycompany.narutojava.julie.ninja.model.clases.Ninja;
import com.mycompany.narutojava.julie.persistence.BDConnection;
import com.mycompany.narutojava.julie.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class MisionDAO implements ISaveDAO<Mision>, IDeleteDAO<Mision> {

    public void save(Mision mision) {

        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO Mision ( Descripcion, Rango, Recompensa,Tiempo) VALUES (?,?,?,?);";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, mision.getDescripcion());
            ps.setString(2, mision.getRango());
            ps.setString(3, mision.getRecompensa());
            ps.setInt(4, mision.getTiempo());

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

    public List<Mision> getAll() {
        List<Mision> listMision = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Mision";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);
            while (rs.next()) {
                Mision mision = new Mision();
                mision.setMisionId(rs.getInt("MisionID"));
                mision.setDescripcion(rs.getString("Descripcion"));
                mision.setRango(rs.getString("Rango"));
                mision.setRecompensa(rs.getString("Recompensa"));

                listMision.add(mision);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listMision;
    }

    public Mision getById(int MisionID) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from Mision where MisionID = ? ;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, MisionID);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Mision mision = new Mision();
                mision.setMisionId(rs.getInt("MisionID"));
                mision.setDescripcion(rs.getString("Descripcion"));
                mision.setRango(rs.getString("Rango"));
                mision.setRecompensa(rs.getString("Recompensa"));
                mision.setTiempo(rs.getInt("Tiempo"));

                return mision;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
