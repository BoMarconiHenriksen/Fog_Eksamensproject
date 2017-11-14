/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.Materiale;
import Presentation.NewException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenedikteEva
 */
public class MaterialeMapper {

    public static List<Materiale> getMaterial() throws NewException {
        List<Materiale> mats = new ArrayList<>();
        try {

            Materiale mat;
            Connection con = DBConnector.connection();
            String sql = "select * from materialeliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;

            while (rs.next()) {
                int varenummer = rs.getInt("vareid");
                String materialetype = rs.getString("materialetype");
                String materialenavn = rs.getString("materialenavn");
                double enhedspris = rs.getDouble("enhedspris");
                String enhed = rs.getString("enhed");
                double msr = rs.getDouble("længde");
              

                if (varenummer != lastId) {
                    mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);

                    mats.add(mat);

                }
            }
            return mats;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

    public static Materiale getMaterialeByVarenummer(int varenummer) throws NewException {
 Materiale mat = null;
        try {
           
            
            
            Connection con = DBConnector.connection();
            String sql = "select * from materialeliste where vareid="+varenummer;
            
            
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            
            
            if (rs.next()) {
                String materialetype= rs.getString("materialetype");
                String materialenavn = rs.getString("materialenavn");
                double enhedspris= rs.getDouble("enhedspris");
                String enhed= rs.getString("enhed");
                double msr= rs.getDouble("længde");
                
                
                mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);
            }
            
            return mat;
        } catch (ClassNotFoundException | SQLException ex) {
           throw new NewException(ex.getMessage()) ;
        }
   

      
    }

    public static void main(String[] args) throws NewException {

  
        System.out.println(MaterialeMapper.getMaterial());
        
        System.out.println(MaterialeMapper.getMaterialeByVarenummer(20));
    }
}
