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
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return invoiceid;
    }

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

//            System.out.println(orderList.getOrdersByOrderId(2));
    }

}
