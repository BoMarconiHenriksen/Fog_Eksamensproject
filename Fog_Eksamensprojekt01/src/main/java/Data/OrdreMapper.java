package Data;

import Domain.Ordre;
import Presentation.NewException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bo
 */
public class OrdreMapper {

    public static List<Ordre> getOrderList() throws NewException {
        List<Ordre> ordreList = new ArrayList<>();

        try {

            Ordre o;

            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM ordreliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;
            while (rs.next()) {
                int ordre_id = rs.getInt("ordre_id");
                int user_id = rs.getInt("user_id");
                String reciveddate = rs.getString("receiveddate");
                if (ordre_id != lastId) {

                    o = new Ordre(ordre_id, reciveddate, user_id);

                    ordreList.add(o);
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordreList;
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


    public static void deleteOrderListByOrderID(int ordre_id) throws NewException {
       
        try {
            Connection con = DBConnector.connection();
            String sql = "DELETE FROM ordreliste WHERE ordre_id=" + ordre_id;
            PreparedStatement ps = con.prepareStatement(sql);

            ps.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }
    
        public static void deleteOrderDetailsByOrderID(int ordre_id) throws NewException {
       
        try {
            Connection con = DBConnector.connection();
            String sql = "DELETE FROM odetaljer WHERE ordre_id=" + ordre_id;
            PreparedStatement ps = con.prepareStatement(sql);

            ps.execute();

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

                o = new Odetaljer(odetaljerId, ordreId, vareId, linjelisteId, ordreStatus,
                        carportLength, carportWidth,
                        carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType);

    public static Ordre getOrdreByOrdreId(int ordre_id) throws NewException {
        Ordre or = null;

        try {

            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM ordreliste WHERE ordre_id=?";
            PreparedStatement pstmt = con.prepareStatement(sql);

            pstmt.setInt(1, ordre_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                int user_id = rs.getInt("user_id");
                String receiveddate = rs.getString("receiveddate");
                or = new Ordre(ordre_id, receiveddate, user_id);


            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new NewException(ex.getMessage());
        }
        return or;
    }

    
    public static int getLastInvoiceId() throws NewException {
       
      
      int invoiceid = 0;
        try {
 Connection con = DBConnector.connection();
            String sql = "SELECT MAX(ordre_id) as ordre_id from ordreliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            if (rs.next()) {

                invoiceid = rs.getInt("ordre_id");

            }
        }  catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return invoiceid;
}

//    Bruges til test
    public static void main(String[] args) throws NewException {

        OrdreMapper.deleteOrderDetailsByOrderID(4);
        OrdreMapper.deleteOrderListByOrderID(4);

//    Bruges til test
    public static void main(String[] args) throws NewException {

//        System.out.println("ordre liste:");
//        try {
//            System.out.println(orderList.getOrderList());
//        } catch (Exception ex) {
//            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println(OrdreMapper.getOrderList());
        System.out.println("ordre detalje liste:");
}}
