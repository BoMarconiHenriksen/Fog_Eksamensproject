/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Materiale;
import Domain.StykLinje;
import Presentation.NewException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenedikteEva
 */
public class StykLinjeMapper {

    public static List<StykLinje> getStykLinje() throws NewException {
        List<StykLinje> styks = new ArrayList<>();
        try {

            StykLinje styk;
            Connection con = DBConnector.connection();
            String sql = "select * from linjeliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;

            while (rs.next()) {
                int linjeid = rs.getInt("linjeliste_id");
                String materialetype = rs.getString("materialetype");
                String beskrivelse = rs.getString("beskrivelse");
                String dimension = rs.getString("dimension");
                int baseLength = rs.getInt("baselength");
                int antal = rs.getInt("antal");

                if (linjeid != lastId) {
                    styk = new StykLinje(linjeid, materialetype, dimension, baseLength, antal, beskrivelse);
                    styks.add(styk);

                }
            }
            return styks;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

    public static StykLinje getStykLinjeById(int stykLinje_id) throws ClassNotFoundException, SQLException {

     
            StykLinje styk = null;

        Connection con = DBConnector.connection();
        String sql = "select * from linjeliste where linjeliste_id=" + stykLinje_id;

        ResultSet rs = con.prepareStatement(sql).executeQuery();

        if (rs.next()) {
            int linjeid = rs.getInt("linjeliste_id");
                String materialetype = rs.getString("materialetype");
                String beskrivelse = rs.getString("beskrivelse");
                String dimension = rs.getString("dimension");
                int baseLength = rs.getInt("baselength");
                int antal = rs.getInt("antal");


           styk = new StykLinje(linjeid, materialetype, dimension, baseLength, antal, beskrivelse);
        }

        return styk;

    }

    public static void main(String[] args) throws NewException, ClassNotFoundException, SQLException {

        StykLinjeMapper stykMap = new StykLinjeMapper();
        System.out.println(stykMap.getStykLinje());

        System.out.println(StykLinjeMapper.getStykLinjeById(2));
    }
}
