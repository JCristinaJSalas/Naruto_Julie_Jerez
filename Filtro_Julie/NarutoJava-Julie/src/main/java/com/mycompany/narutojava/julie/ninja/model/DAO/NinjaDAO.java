package com.mycompany.narutojava.julie.ninja.model.DAO;

import com.mycompany.narutojava.julie.DAO.IDeleteDAO;
import com.mycompany.narutojava.julie.DAO.IGetAllDAO;
import com.mycompany.narutojava.julie.DAO.IGetByIdDAO;
import com.mycompany.narutojava.julie.DAO.ISaveDAO;
import com.mycompany.narutojava.julie.ninja.model.clases.Ninja;
import com.mycompany.narutojava.julie.ninja.model.clases.NinjaHabilidades;
import com.mycompany.narutojava.julie.persistence.BDConnection;
import com.mycompany.narutojava.julie.persistence.Operations;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NinjaDAO implements ISaveDAO<Ninja>, IDeleteDAO<Ninja>, IGetAllDAO<Ninja>, IGetByIdDAO<Ninja> {

    @Override
    public void save(Ninja ninja) {

        // Create a query and send corresponding information in each field by replacing the character "?" with the information
        String stmInsert = "INSERT INTO Ninja ( Nombre, Rango, Aldea) VALUES ( ?, ?, ?)";
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stmInsert)) {
            ps.setString(1, ninja.getNombre());
            ps.setString(2, ninja.getRango());
            ps.setString(3, ninja.getAldea());

            // use Operation class with insert_update_delete and verify if the rows in database are affected
            int rows = Operations.insert_update_delete_db(ps);
            if (rows <= 0) {
                System.out.println("Cannot push ninja");
            } else {
                System.out.println("Successful push ninja");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int ninjaID) {
        //Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "DELETE FROM Ninja WHERE NinjaID = ?;";

        // use Operation class with insert_update_delete and verify if the rows in database are affected
        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setInt(1, ninjaID);
            int rows = Operations.insert_update_delete_db(ps);
            if (rows > 0) {
                System.out.println("successful delete ninja");
                return;
            } else {
                System.out.println("not exists ninja");
                return;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("something was wrong on delete ninja");
        return;
    }

    @Override
    public List<Ninja> getAll() {
         List<Ninja> listNinja = new ArrayList<>();
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "SELECT * FROM Ninja";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ResultSet rs = Operations.query_db(ps);
            while (rs.next()) {
                Ninja ninja = new Ninja();
                ninja.setNinjaID(rs.getInt("NinjaID"));
                ninja.setNombre(rs.getString("Nombre"));
                ninja.setRango(rs.getString("Rango"));
                ninja.setAldea(rs.getString("Aldea"));
                
                
                listNinja.add(ninja);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNinja; }
    
    @Override
    public Ninja getById(int NinjaID) {
        Operations.setConnection(BDConnection.MySQLConnection());
        String stm = "select * from Ninja where NinjaID = ? ;";

        try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
            ps.setLong(1, NinjaID);
            ResultSet rs = Operations.query_db(ps);
            if (rs.next()) {
                Ninja ninja = new Ninja();
                ninja.setNinjaID(rs.getInt("NinjaID"));
                ninja.setNombre(rs.getString("Nombre"));
                ninja.setRango(rs.getString("Rango"));
                ninja.setAldea(rs.getString("Aldea"));

                return ninja;
            } else {
                System.out.println("ERROR: The id has not been found");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
   
//    public List<NinjaHabilidades> getAllFull() {
//
//        List<Ninja> listNinjas = getAll();
//        List<NinjaHabilidades> listNinjaHabilidades = new ArrayList<>();
//        Operations.setConnection(BDConnection.MySQLConnection());
//
//        for (Ninja ninja : listNinjas){
//            NinjaHabilidades ninjaHabilidades = new NinjaHabilidades();
//
//            ninjaHabilidades.setEventId(ninja.getEventId());
//            ninjaHabilidades.setNameEventninjaevent.getNameEvent());
//            ninjaHabilidades.setCountry(ninja.getCountry());
//            ninjaHabilidades.setCity(ninja.getCity());
//            listNinjaHabilidades.add(ninjaHabilidades);
//        }
//
//        for (NinjaHabilidades eventStaffFull : listNinjaHabilidades){
//            String stm = """
//                Select n.*, h.Nombre as Habilidad from Ninja n
//                Inner join Habilidad h on n.NinjaID = h.NinjaID;
//                    """;
//            try (PreparedStatement ps = Operations.getConnection().prepareStatement(stm)) {
//                ps.setLong(1, eventStaffFull.getEventId());
//                ResultSet rs = Operations.query_db(ps);
//                List<Staff> listStaff = new ArrayList<>();
//
//                while (rs.next()) {
//                    Staff staff = new Staff();
//                    staff.setStaffId(rs.getLong("staffId"));
//                    staff.setStaffNumberId(rs.getString("staffNumberId"));
//                    staff.setNameStaff(rs.getString("nameStaff"));
//                    staff.setBirthdayStaff(LocalDate.parse(rs.getString("birthdayStaff")));
//                    staff.setStatusStaffEnum(staff.getStatusStaffEnum(rs.getString("statusStaff")));
//                    staff.setWorkerRoleId(rs.getInt("roleWorkId"));
//                    listStaff.add(staff);
//                }
//                eventStaffFull.setStaff(listStaff);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return listEventsFull;
//    }
}
    
    

