package Data;

import Domain.Odetaljer;
import Presentation.NewException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 *
 * @author BenedikteEva
 */
public class OdetaljeMapper {

    public static void addOdetaljertoOdetaljeListe(int ordre_id, Odetaljer od) throws NewException {

        try {

            Connection conn = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO odetaljer (ordre_id, length, width, height) VALUES (?, ?, ?, ?)";
            PreparedStatement orderPstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            orderPstmt.setInt(1, ordre_id);
            orderPstmt.setDouble(2, od.getCarportLength());
            orderPstmt.setDouble(3, od.getCarportWidth());
            orderPstmt.setDouble(4, od.getCarportHeight());
            orderPstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

    public static Odetaljer getOrderByOrderId2(int ordre_id) throws NewException {

        Odetaljer o = null;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM odetaljer WHERE ordre_id=" + ordre_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            if (rs.next()) {

                int odetaljerId = rs.getInt("odetaljer_id");
                int ordreId = rs.getInt("ordre_id");
                int vareId = rs.getInt("vareid");
                int linjelisteId = rs.getInt("linjeliste_id");
//                String ordreStatus = rs.getString("ordre_status");
                double carportLength = rs.getDouble("length");
                double carportWidth = rs.getDouble("width");
                double carportHeight = rs.getDouble("height");
                double lengthRedskabsrum = rs.getDouble("lengthredskabsrum");
//                double widthRedskabsrum = rs.getDouble("widthredskabsrum");
                int tagType = rs.getInt("tagtype");

                o = new Odetaljer(odetaljerId, ordreId, vareId, linjelisteId,
                       carportLength, carportWidth,
                        carportHeight, lengthRedskabsrum,  tagType);

                return o;
            }
        } catch (SQLException | ClassNotFoundException ex) {
           throw new NewException(ex.getMessage());
        }
        return o;

    }

//    Bruges til test
    public static void main(String[] args) throws NewException {

        OdetaljeMapper orderList = new OdetaljeMapper();
        Odetaljer od = new Odetaljer(1,480.00,300.00,225.00);
        orderList.addOdetaljertoOdetaljeListe(1, od);
//        System.out.println("ordre liste:");
//        try {
//            System.out.println(orderList.getOrderList());
//        } catch (Exception ex) {
//            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println(OdetaljeMapper.getOrderByOrderId2(2));
        System.out.println("ordre detalje liste:");

    }
}
