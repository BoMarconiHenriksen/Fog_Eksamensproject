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

/**
 *
 * @author Ejer
 */
public class MaterialeMapper {

    public static List<Materiale>getMaterial() throws NewException {
       List <Materiale> mats = null; 
       try {
           
            Materiale mat;
            Connection con = DBConnector.connection();
            String sql = "select * from materialeliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;
            
            while (rs.next()) {
                int varenummer = rs.getInt("varenummer");
                String materialetype = rs.getString("materialetype");
                String materialenavn= rs.getString("materialenavn");
                double enhedspris = rs.getDouble("enhedspris");
                String enhed = rs.getString("enhed");
                
                double msr= rs.getDouble("længde");
                
                if (varenummer != lastId) {
                    mat = new Materiale( varenummer,  materialetype, materialenavn, enhedspris, enhed,  msr);
                    mats = new ArrayList<>();
                    mats.add(mat);
                    
                }
            }
            return mats;
        } catch (SQLException | ClassNotFoundException ex) {
          throw new NewException(ex.getMessage());
        }
     
    }
    
     public static void main(String[] args) throws NewException {
         
         MaterialeMapper matMap = new MaterialeMapper ();
         System.out.println(matMap.getMaterial());
     }
}
