package Data;

import Domain.Odetaljer;
import Domain.Ordre;
import Presentation.NewException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bo
 */
public class OrdreMapper {

    public static List<Ordre> getOrderList() throws NewException {
        List<Ordre> ordreList = new ArrayList<>();
        Ordre o;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM ordreliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            while (rs.next()) {
                int ordre_id = rs.getInt("ordre_id");
                int user_id = rs.getInt("user_id");
                String reciveddate = rs.getString("receiveddate");

                o = new Ordre(ordre_id, reciveddate, user_id);
                ordreList.add(o);
            }

            return ordreList;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

  
    public static Odetaljer getOrderByOrderId(int ordre_id) throws NewException {
        Odetaljer o = null;
        try {

            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM odetaljer WHERE ordre_id=" + ordre_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            int odetaljerId = rs.getInt("odetaljer_id");
            int ordreId = rs.getInt("ordre_id");
            int vareId = rs.getInt("vareid");
            int linjelisteId = rs.getInt("linjeliste_id");
//            String ordreStatus = rs.getString("ordre_status");
            double carportLength = rs.getDouble("length");
            double carportWidth = rs.getDouble("width");
            double carportHeight = rs.getDouble("height");
            double lengthRedskabsrum = rs.getDouble("lengthredskabsrum");
//            double widthRedskabsrum = rs.getDouble("width_redskabsrum");
            int tagType = rs.getInt("tagtype");

            o = new Odetaljer(odetaljerId, ordreId, vareId, linjelisteId,
                    carportLength, carportWidth,
                    carportHeight, lengthRedskabsrum, tagType);

            return o;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }

//    Bruges til test
    public static void main(String[] args) throws NewException {

      
//        System.out.println("ordre liste:");
//        try {
//            System.out.println(orderList.getOrderList());
//        } catch (Exception ex) {
//            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println(OrdreMapper.getOrderByOrderId(2));
        System.out.println("ordre detalje liste:");

//            System.out.println(orderList.getOrdersByOrderId(2));
    }

}
