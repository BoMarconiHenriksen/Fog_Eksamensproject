package Data;

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

//    public List<Order> getOrdersByUserId(int user_id) throws MakingAnException {
//        List<Order> orders = new ArrayList<>();
//        Order o;
//        try {
//            Connection con = DBConnector.connection();
//            String sql = "SELECT * FROM orderlist WHERE user_id=" + user_id;
//            ResultSet rs = conn.prepareStatement(sql).executeQuery();
//
//            while (rs.next()) {
//                int order_id = rs.getInt("order_id");
//                String reciveddate = rs.getString("received");
//
//                o = new Order(order_id, user_id, reciveddate);
//                orders.add(o);
//            }
//
//            return orders;
//        } catch (SQLException | NumberFormatException | NullPointerException ex) {
//            ex.getCause();
//        }
//        return orders;
//    }
    //Bruges til test
//    public static void main(String[] args) {
//        
//        OrdreMapper orderList = new OrdreMapper();
//        System.out.println("ordre liste:");
//        try {
//            System.out.println(orderList.getOrderList());
//        } catch (Exception ex) {
//            Logger.getLogger(OrdreMapper.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//    }
}
