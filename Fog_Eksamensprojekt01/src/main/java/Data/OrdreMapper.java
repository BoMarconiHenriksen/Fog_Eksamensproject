package Data;

import Domain.Odetaljer;
import Domain.Ordre;
import Presentation.NewException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
    
        public static List<Ordre> getOrderListByUserID(int user_id) throws NewException {
        List<Ordre> ordreList = new ArrayList<>();
        Ordre o;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM ordreliste WHERE user_id=" + user_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            while (rs.next()) {
                int ordre_id = rs.getInt("ordre_id");
                int userId = rs.getInt("user_id");
                String reciveddate = rs.getString("receiveddate");

                o = new Ordre(ordre_id, reciveddate, userId);
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
            
            while(rs.next()){
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

            o = new Odetaljer(odetaljerId, ordreId, vareId, linjelisteId, ordreStatus,
                    carportLength, carportWidth,
                    carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType);
            }
            return o;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return o;
    }
 public static void AddOdetailstoOrdermedSkur(Odetaljer ods) throws NewException {

        try {

            Connection con = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO odetaljer( ordre_status, carport_length, carport_width, carport_height, length_redskabsrum, width_redskabsrum) VALUES ( ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setString(1, ods.getOrdreStatus());
            ps.setDouble(2, ods.getCarportLength());
            ps.setDouble(3, ods.getCarportWidth());
            ps.setDouble(4, ods.getCarportHeight());
            ps.setDouble(5, ods.getLengthRedskabsrum());
            ps.setDouble(6, ods.getWidthRedskabsrum());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            ods.setOrdreId(id);

        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }


//    Bruges til test
public static void main(String[] args) throws NewException {

      
//        System.out.println("ordre liste:");
//        try {
//            System.out.println(orderList.getOrderList());
//        } catch (Exception ex) {
//            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println(OrdreMapper.getOrderByOrderId(1).getOrdreStatus());
        System.out.println("ordre detalje liste:");

//            System.out.println(orderList.getOrdersByOrderId(2));
    }

}
