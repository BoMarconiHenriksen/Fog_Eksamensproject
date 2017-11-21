/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.LineItem;
import Domain.Materiale;
import Domain.Order;
import Domain.StykLinje;
import Domain.User;
import Presentation.NewException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ejer
 */
public class LineItemMapper {

    public static void addOrdertoOrderList(User or) throws NewException {

        Order od = new Order();

        try {

            Connection con = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO ordreliste (user_id, receiveddate) VALUES (?, ?)";
            PreparedStatement orderPstmt = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            orderPstmt.setInt(1, or.getUser_id());
            orderPstmt.setString(2, od.getReciveddate());
            orderPstmt.executeUpdate();
            ResultSet ids = orderPstmt.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            od.setOrder_id(id);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }
    
    public static LineItem updateVareId(int linjeliste_id, int vareid, double msr) throws NewException{
        StykLinje styl = null; 
        Materiale mat = null;
         try {

            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update lineitem, linjeliste set vareid=?, baselength=? where lineitem.linjeliste_id="+linjeliste_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vareid);
            ps.setDouble(2, msr);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }
        return null;

    }

   
    

    public static List<LineItem> getLineItems() throws NewException {
        List<LineItem> lis = new ArrayList<>();
        try {

            LineItem li;
            Materiale mat;
            StykLinje styk;
            Connection con = DBConnector.connection();
            String sql = "select længde,baselength, dimension, lineitem.linjeliste_id, materialeliste.materialetype, linjeliste.beskrivelse,"
                    + " materialeliste.materialenavn,enhed, enhedspris, antal from linjeliste, lineitem, "
                    + "materialeliste where linjeliste.linjeliste_id=lineitem.linjeliste_id "
                    + "and materialeliste.vareid=linjeliste.linjeliste_id;";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;

            while (rs.next()) {

                String materialenavn = rs.getString("materialenavn");
                double enhedspris = rs.getDouble("enhedspris");
                String enhed = rs.getString("enhed");
                double msr = rs.getDouble("længde");
                String materialetype = rs.getString("materialetype");
                String beskrivelse = rs.getString("beskrivelse");
                String dimension = rs.getString("dimension");
                double baseLength = rs.getDouble("baselength");


                int linjelisteid = rs.getInt("linjeliste_id");

                int antal = rs.getInt("antal");
                int id = rs.getInt("linjeliste_id");
                if (id != lastId) {
                    mat = new Materiale(materialetype, materialenavn, enhedspris, enhed, msr);

                    styk = new StykLinje( materialetype, dimension, baseLength, antal, beskrivelse);
                   li= new LineItem(mat, styk);
                   lis.add(li);

                }
            }
            return lis;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

    public static void main(String[] args) throws NewException {

        
//        LineItemMapper.updateVareId(1,1,300);
//        System.out.println(LineItemMapper.getLineItems().get(0));

    }
}
