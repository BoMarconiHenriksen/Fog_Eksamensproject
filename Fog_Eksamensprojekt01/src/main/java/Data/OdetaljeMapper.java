package Data;

import Business.Domain.Odetaljer;
import Business.Exception.NewException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Håntere alle metoder til og fra databasen vedr. en ordres nærmere detaljer.
 *
 */
public class OdetaljeMapper {

    public static final Logger logger = Logger.getLogger(MaterialeMapper.class.getName());
    
    /**
     * Tilføjer en ordre med et bestemt ordre id's nærmere detaljer, til databasen.
     * @param ordre_id er ordrens id.
     * @throws NewException ved fejl.
     */
    public static void addOdetaljerToOdetaljeListe(int ordre_id, Odetaljer od) throws NewException {

        try {

            Connection conn = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO odetaljer (ordre_id, carport_length, carport_width, carport_height, length_redskabsrum, width_redskabsrum, price) VALUES (?, ?, ?, ?,?,?,?)";
            PreparedStatement orderPstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            orderPstmt.setInt(1, ordre_id);
            orderPstmt.setDouble(2, od.getCarportLength());
            orderPstmt.setDouble(3, od.getCarportWidth());
            orderPstmt.setDouble(4, od.getCarportHeight());
            orderPstmt.setDouble(5, od.getLengthRedskabsrum());
            orderPstmt.setDouble(6, od.getWidthRedskabsrum());
            orderPstmt.setDouble(7, od.getPrice());
            orderPstmt.executeUpdate();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i addOdetaljertoOdetaljeListe", ex);
            throw new NewException(ex.getMessage());
        }

    }
    
    /**
     * Henter en ordres nærmere detaljer, ud fra et valgt ordre id, fra databasen.
     * @param ordre_id er ordre idet.
     * @return oDetaljer en ordre.
     * @throws NewException ved fejl. 
     */
    public static Odetaljer getOrderByOrderId2(int ordre_id) throws NewException {

        Odetaljer o = null;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM odetaljer WHERE ordre_id=" + ordre_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            while (rs.next()) {

                int odetaljerId = rs.getInt("odetaljer_id");
                double carportLength = rs.getDouble("carport_length");
                double carportWidth = rs.getDouble("carport_width");
                double carportHeight = rs.getDouble("carport_height");
                double lengthRedskabsrum = rs.getDouble("length_redskabsrum");
                double widthRedskabsrum = rs.getDouble("width_redskabsrum");
                int tagType = rs.getInt("tagtype");
                String ordreStatus = rs.getString("ordre_status");
                double price =rs.getDouble("price");

                o = new Odetaljer(odetaljerId, ordre_id, ordreStatus,
                        carportLength, carportWidth,
                        carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType, price);

                return o;
            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getOrderByOrderId2", ex);
            throw new NewException(ex.getMessage());
        }
        return o;

    }
    
    /**
     * Overskrider en ordres status men en ny en i databasen.
     * @param order_id er ordre idet.
     * @param ordre_status er ordre status.
     * @throws NewException ved fejl.
     */
    public static void updateOrdreStatus(int order_id, String ordre_status) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update odetaljer set ordre_status=? where ordre_id=" + order_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ordre_status);

            ps.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i updateOrdreStatus", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Henter en ordre med et bestemt id's nærmere detaljer fra databasen.
     * @param ordre_id er ordre idet.
     * @return oDetaljer en ordre.
     * @throws NewException ved fejl.
     */
    public static Odetaljer getOdetailsByOrderId(int ordre_id) throws NewException {
        Odetaljer o = null;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM odetaljer WHERE ordre_id=" + ordre_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                int odetaljerId = rs.getInt("odetaljer_id");
                int ordreId = rs.getInt("ordre_id");
                String ordreStatus = rs.getString("ordre_status");
                double carportLength = rs.getDouble("carport_length");
                double carportWidth = rs.getDouble("carport_width");
                double carportHeight = rs.getDouble("carport_height");
                double lengthRedskabsrum = rs.getDouble("length_redskabsrum");
                double widthRedskabsrum = rs.getDouble("width_redskabsrum");
                int tagType = rs.getInt("tagtype");
                double price =rs.getDouble("price");
                o = new Odetaljer(odetaljerId, ordreId, ordreStatus, carportLength, carportWidth, carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType,price);
            }
            return o;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getOdetailsByOrderId", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Gør præcis det samme som ovenstående metode. Bør Slettes!!!
     * @param ordre_id er ordrens id.
     * @return 
     * @throws NewException ved fejl.
     */
    public static Odetaljer getOrderByOrderId(int ordre_id) throws NewException {
        Odetaljer oDetaljer = null;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT * FROM odetaljer WHERE ordre_id=" + ordre_id;
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            while (rs.next()) {
                int odetaljerId = rs.getInt("odetaljer_id");
                int ordreId = rs.getInt("ordre_id");
                String ordreStatus = rs.getString("ordre_status");
                double carportLength = rs.getDouble("carport_length");
                double carportWidth = rs.getDouble("carport_width");
                double carportHeight = rs.getDouble("carport_height");
                double lengthRedskabsrum = rs.getDouble("length_redskabsrum");
                double widthRedskabsrum = rs.getDouble("width_redskabsrum");
                int tagType = rs.getInt("tagtype");
                    double price =rs.getDouble("price");
                oDetaljer = new Odetaljer(odetaljerId, ordreId, 
                        ordreStatus, carportLength, carportWidth, carportHeight, lengthRedskabsrum, widthRedskabsrum, tagType,price);
            }
        } catch (SQLException ex) {
            throw new NewException(ex.getMessage());
        }
        return null;
    }

   /**
    * Gør præcis det samme som addOdetaljerToOdetaljeListe. Bør slettes!!!
    * @param ordre_id er ordrens id.
    * @throws NewException ved fejl.
    */
    public static void AddOdetailstoOrdermedSkur(int ordre_id, Odetaljer ods) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO odetaljer( ordre_id, ordre_status, carport_length, carport_width, carport_height, length_redskabsrum, width_redskabsrum, price) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ordre_id);
            ps.setString(2, ods.getOrdreStatus());
            ps.setDouble(3, ods.getCarportLength());
            ps.setDouble(4, ods.getCarportWidth());
            ps.setDouble(5, ods.getCarportHeight());
            ps.setDouble(6, ods.getLengthRedskabsrum());
            ps.setDouble(7, ods.getWidthRedskabsrum());
            ps.setDouble(8, ods.getPrice());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new NewException(ex.getMessage());
        }
    }
       
    /**
     * Bruges kun til nem og hurtig test af OdetaljeMapper funktionerne.
     * @throws NewException vej fejl.
     */
    public static void main(String[] args) throws NewException {

        OdetaljeMapper orderList = new OdetaljeMapper();
        Odetaljer od = new Odetaljer(1, 480.00, 300.00, 225.00);
        orderList.addOdetaljerToOdetaljeListe(1, od);
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
}
