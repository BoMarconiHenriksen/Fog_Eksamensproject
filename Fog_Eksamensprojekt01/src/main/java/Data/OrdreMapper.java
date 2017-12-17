package Data;

import Business.Domain.Ordre;
import Business.Exception.NewException;
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
 * OrdreMapper: Håntere alle forbindelser til og fra databasen vedr. en ordre. (Men en ordres nærmere detaljer, hånteres i stedet i OdetaljeMapper.)
 *
 * @author Bo
 */
public class OrdreMapper {

    public static final Logger logger = Logger.getLogger(MaterialeMapper.class.getName());
    
    /**
     * getrderlist: opretter en liste og indsætter den med alle databasens ordre.
     * @return ordreList
     * @throws NewException 
     */

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
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getOrderList", ex);
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordreList;
    }
    
    /**
     * getOrderListByUserID: Opretter en liste og indsætter alle ordre fra databasen, der er tilknyttet et bestemt user id.
     * @param user_id
     * @return ordreList
     * @throws NewException 
     */

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
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getOrderListByUserID", ex);
            throw new NewException(ex.getMessage());
        }

    }
    
    /**
     * deleteOrderListByOrderID: sletter en ordre fra databasen der indeholder et bestemt id.
     * @param ordre_id
     * @throws NewException 
     */
    public static void deleteOrderListByOrderID(int ordre_id) throws NewException {

        try {
            Connection con = DBConnector.connection();
            String sql = "DELETE FROM ordreliste WHERE ordre_id=" + ordre_id;
            PreparedStatement ps = con.prepareStatement(sql);

            ps.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i deleteOrderListByOrderID", ex);
            throw new NewException(ex.getMessage());
        }

    }
    
    /**
     * deleteOrderDetailsByOrderID: Metoden her omfatter untagelsesvis en handling vedr. en ordres nærmere detaljer,
     * da en sletning af en ordre kræver at der udføeres denne og forrige metode samtidigt. 
     * Metoden her gør næsten det samme som ovenstående metode: Den sletter en ordres nærmere detaljer ud fra et bestemt id.
     * @param ordre_id
     * @throws NewException 
     */

    public static void deleteOrderDetailsByOrderID(int ordre_id) throws NewException {

        try {
            Connection con = DBConnector.connection();
            String sql = "DELETE FROM odetaljer WHERE ordre_id=" + ordre_id;
            PreparedStatement ps = con.prepareStatement(sql);

            ps.execute();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i deleteOrderDetailsByOrderID", ex);
            throw new NewException(ex.getMessage());
        }

    }
    
    /**
     * getOrdreByOrdreId: Henter en ordre fra databasen der tilhører et bestemt ordre id.
     * @param ordre_id
     * @return or
     * @throws NewException 
     */

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

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getOrdreByOrdreId", ex);
            throw new NewException(ex.getMessage());
        }
        return or;
    }
    
    /**
     * getLastInvoiceId: Henter det seneste ordre, der blev lagt i databasen.
     * @return invoiceid
     * @throws NewException 
     */

    public static int getLastInvoiceId() throws NewException {

        int invoiceid = 0;
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT MAX(ordre_id) as ordre_id from ordreliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();

            if (rs.next()) {

                invoiceid = rs.getInt("ordre_id");

            }
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getLastInvoiceId", ex);
            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

        return invoiceid;
    }
    
    /**
     * addOrdertoOrderlist: Tilføjer en ordre til ordreliste tabellen i databasen, med det user_id, ordren tilhører.
     * @param or
     * @throws NewException 
     */

    public static void addOrdertoOrderList(Ordre or) throws NewException {
        try {
            Connection conn = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO ordreliste (user_id, receiveddate) VALUES (?, ?)";
            PreparedStatement orderPstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            orderPstmt.setInt(1, or.getUser_id());
            orderPstmt.setString(2, or.getReciveddate());
            orderPstmt.executeUpdate();
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i addOrdertoOrderList", ex);
            throw new NewException(ex.getMessage());
        }
    }

    /**
     * Mainmetode: Er kun brugt til OrdreMapper tests.
     * Denne metode bruges ikke i det kørende program.
     * @param args
     * @throws NewException 
     */
    public static void main(String[] args) throws NewException {

        OrdreMapper.deleteOrderDetailsByOrderID(4);
        OrdreMapper.deleteOrderListByOrderID(4);

    }
}
