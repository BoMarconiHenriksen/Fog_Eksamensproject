/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.LineItem;
import Domain.Materiale;
import Domain.StykLinje;
import Presentation.NewException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ejer
 */
public class LineItemMapper {

    public static List<LineItem> getLineItems() throws NewException {
        List<LineItem> lis = new ArrayList<>();
        try {

            LineItem li;
            Materiale mat;
            StykLinje styk;
            Connection con = DBConnector.connection();
            String sql = "select længde,baselength, dimension, lineitem.linjeliste_id, materialeliste.materialetype, linjeliste.beskrivelse,"
                    + " materialeliste.materialenavn,enhed, enhedspris, antal from linjeliste,"
                    + " materialeliste, lineitem where materialeliste.vareid=lineitem.vareid "
                    + "and linjeliste.linjeliste_id=lineitem.linjeliste_id";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;

            while (rs.next()) {

               
                String materialenavn = rs.getString("materialenavn");
                double enhedspris = rs.getDouble("enhedspris");
                String enhed = rs.getString("enhed");
                double msr = rs.getDouble("længde");
                String materialetype = rs.getString("materialetype");
                String beskrivelse= rs.getString("beskrivelse");
                String dimension = rs.getString("dimension");
                double baseLength = rs.getDouble("baselength");
            
                int linjelisteid=rs.getInt("linjeliste_id");
                int antal = rs.getInt("antal");
                int id = rs.getInt("linjeliste_id");
                if (id != lastId) {
                    mat = new Materiale(materialetype, materialenavn, enhedspris, enhed, msr);
                    styk = new StykLinje( materialetype, dimension, baseLength, antal, beskrivelse);
                   li= new LineItem(mat, styk, 0.00);
                   lis.add(li);
                }
            }
            return lis;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

  
    public static void main(String[] args) throws NewException {

        System.out.println(LineItemMapper.getLineItems());

        System.out.println(LineItemMapper.getLineItems());
    }
}

