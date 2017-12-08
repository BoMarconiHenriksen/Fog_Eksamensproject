package Data;

import Domain.Odetaljer;
import Domain.Exception.NewException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BenedikteEva
 */
public class OdetaljeMapper {

    public static final Logger logger = Logger.getLogger(MaterialeMapper.class.getName());

    public static void addOdetaljertoOdetaljeListe(int ordre_id, Odetaljer od) throws NewException {

        try {

            Connection conn = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO odetaljer (ordre_id, carport_length, carport_width, carport_height, length_redskabsrum, width_redskabsrum) VALUES (?, ?, ?, ?,?,?)";
            PreparedStatement orderPstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            orderPstmt.setInt(1, ordre_id);
            orderPstmt.setDouble(2, od.getCarportLength());
            orderPstmt.setDouble(3, od.getCarportWidth());
            orderPstmt.setDouble(4, od.getCarportHeight());
            orderPstmt.setDouble(5, od.getLengthRedskabsrum());
            orderPstmt.setDouble(6, od.getWidthRedskabsrum());
            orderPstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Fejl i addOdetaljertoOdetaljeListe", ex);
            throw new NewException(ex.getMessage());
        }

    }

    public static void saveOdetaljertoDesignGemning(int user_id, Odetaljer OdG) throws NewException {

        try {

            Connection conn = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO designgemning (user_id, ordre_status, carport_length, carport_width, carport_height, length_redskabsrum, width_redskabsrum) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement orderPstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            orderPstmt.setInt(1, user_id);
            orderPstmt.setString(2, OdG.getOrdreStatus());
            orderPstmt.setDouble(3, OdG.getCarportLength());
            orderPstmt.setDouble(4, OdG.getCarportWidth());
            orderPstmt.setDouble(5, OdG.getCarportHeight());
            orderPstmt.setDouble(6, OdG.getLengthRedskabsrum());
            orderPstmt.setDouble(7, OdG.getWidthRedskabsrum());
            orderPstmt.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Fejl i saveOdetaljertoDesignGemning", ex);
            throw new NewException(ex.getMessage());
        }

    }

    public static Odetaljer getOrderByOrderId2(int ordre_id) throws NewException {

        Odetaljer o = null;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM odetaljer WHERE ordre_id=" + ordre_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            while (rs.next()) {

                int odetaljerId = rs.getInt("odetaljer_id");

                int vareId = rs.getInt("vareid");
                int linjelisteId = rs.getInt("linjeliste_id");
                double carportLength = rs.getDouble("carport_length");
                double carportWidth = rs.getDouble("carport_width");
                double carportHeight = rs.getDouble("carport_height");
                double lengthRedskabsrum = rs.getDouble("length_redskabsrum");
                double widthRedskabsrum = rs.getDouble("width_redskabsrum");
                int tagType = rs.getInt("tagtype");
                String ordreStatus = rs.getString("ordre_status");

                o = new Odetaljer(odetaljerId, ordre_id, vareId, linjelisteId, ordreStatus,
                        carportLength, carportWidth,
                        carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType);

                return o;
            }
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Fejl i getOrderByOrderId2", ex);
            throw new NewException(ex.getMessage());
        }
        return o;

    }

    public static void updateOrdreStatus(int order_id, String ordre_status) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update odetaljer set ordre_status=? where ordre_id=" + order_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ordre_status);

            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Fejl i updateOrdreStatus", ex);
            throw new NewException(ex.getMessage());
        }

    }

    public static void addOdetailstoOrdermedSkur(Odetaljer ods) throws NewException {
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
            logger.log(Level.SEVERE, "Fejl i addOdetailstoOrdermedSkur", ex);
            throw new NewException(ex.getMessage());
        }
    }

    public static Odetaljer getOdetailsByOrderId(int ordre_id) throws NewException {
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
                o = new Odetaljer(odetaljerId, ordreId, vareId, linjelisteId, ordreStatus, carportLength, carportWidth, carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType);
            }
            return o;
        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getOdetailsByOrderId", ex);
            throw new NewException(ex.getMessage());
        }

    }

    //    Bruges til test
    public static void main(String[] args) throws NewException {

        OdetaljeMapper orderList = new OdetaljeMapper();
        Odetaljer od = new Odetaljer(1, 480.00, 300.00, 225.00);
        orderList.addOdetaljertoOdetaljeListe(1, od);
        String ordre_status = "Afsendt";
        orderList.updateOrdreStatus(2, ordre_status);
//        System.out.println("ordre liste:");
//        try {
//            System.out.println(orderList.getOrderList());
//        } catch (Exception ex) {
//            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
        System.out.println(OdetaljeMapper.getOrderByOrderId2(2).getOrdreStatus());
        System.out.println("ordre detalje liste:");

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
                o = new Odetaljer(odetaljerId, ordreId, vareId, linjelisteId, ordreStatus, carportLength, carportWidth, carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }
        return null;
    }

    public static void AddOdetailstoOrderudenSkur(Odetaljer od) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO odetaljer( ordre_status, carport_length, carport_width, carport_height) VALUES ( ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, od.getOrdreStatus());
            ps.setDouble(2, od.getCarportLength());
            ps.setDouble(3, od.getCarportWidth());
            ps.setDouble(4, od.getCarportHeight());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            od.setOrdreId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }
    }

    public static void AddOdetailstoOrdermedSkur(int ordre_id, Odetaljer ods) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO odetaljer( ordre_id, ordre_status, carport_length, carport_width, carport_height, length_redskabsrum, width_redskabsrum) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ordre_id);
            ps.setString(2, ods.getOrdreStatus());
            ps.setDouble(3, ods.getCarportLength());
            ps.setDouble(4, ods.getCarportWidth());
            ps.setDouble(5, ods.getCarportHeight());
            ps.setDouble(6, ods.getLengthRedskabsrum());
            ps.setDouble(7, ods.getWidthRedskabsrum());
            ps.executeUpdate();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }
    }
}
