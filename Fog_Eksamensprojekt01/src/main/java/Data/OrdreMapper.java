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

    public static List<Odetaljer> getOrdersByOrderId(int ordre_id) throws NewException {
        List<Odetaljer> oDetailList = new ArrayList<>();
        Odetaljer o;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM odetaljer WHERE ordre_id=" + ordre_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            while (rs.next()) {
                int odetaljerId = rs.getInt("odetaljer_id");
                int ordreId = rs.getInt("ordre_id");
                int vareId = rs.getInt("vareid");
                int linjelisteId = rs.getInt("linjeliste_id");
                String ordreStatus = rs.getString("ordre_status");
                double carportLength = rs.getDouble("carport_length");
                double carportWidth = rs.getDouble("carport_width");
                double carportHeight = rs.getDouble("carport_height");
                double lengthRedskabsrum = rs.getDouble("length_redskabsrum");
                double widthRedskabsrum = rs.getDouble("width_redskabsrum");
                int tagType = rs.getInt("tagtype");

                o = new Odetaljer(odetaljerId, ordreId, vareId, linjelisteId, 
                                    ordreStatus, carportLength, carportWidth, 
                                    carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType);
                oDetailList.add(o);
            }

            return oDetailList;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

//    Bruges til test
    public static void main(String[] args) {

        OrdreMapper orderList = new OrdreMapper();
//        System.out.println("ordre liste:");
//        try {
//            System.out.println(orderList.getOrderList());
//        } catch (Exception ex) {
//            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }

        System.out.println("ordre detalje liste:");
        try {
            System.out.println(orderList.getOrdersByOrderId(1)); 
        } catch (NewException ex) {
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
