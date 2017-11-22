package Data;

import Domain.LineItem;
import Domain.Materiale;
import Domain.Ordre;
import Domain.StykLinje;
import Domain.User;
import Presentation.NewException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author Ejer
 */
public class LineItemMapper {

    public static void addOrdertoOrderList(Ordre or) throws NewException {


        try {

            Connection conn = DBConnector.connection();
            String SQL;
            SQL = "INSERT INTO ordreliste (user_id, receiveddate) VALUES (?, ?)";
            PreparedStatement orderPstmt = conn.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            orderPstmt.setInt(1, or.getUser_id());
            orderPstmt.setString(2, or.getReciveddate());
            orderPstmt.executeUpdate();


        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }
    
   public static List<LineItem> getLineItems() throws NewException {
        List<LineItem> lis = new ArrayList<>();
        try {

            LineItem li;
            Materiale mat;
            StykLinje styk;
            Connection con = DBConnector.connection();
            String sql = "select længde,baselength, dimension, lineitem.linjeliste_id, materialeliste.materialetype, linjeliste.beskrivelse,"
                    + " materialeliste.materialenavn,enhed, enhedspris, antal from linjeliste, lineitem, "
                    + "materialeliste where linjeliste.linjeliste_id=lineitem.linjeliste_id "
                    + "and materialeliste.vareid=linjeliste.linjeliste_id;";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;

            while (rs.next()) {

                String materialenavn = rs.getString("materialenavn");
                double enhedspris = rs.getDouble("enhedspris");
                String enhed = rs.getString("enhed");
                double msr = rs.getDouble("længde");
                String materialetype = rs.getString("materialetype");
                String beskrivelse = rs.getString("beskrivelse");
                String dimension = rs.getString("dimension");
                double baseLength = rs.getDouble("baselength");

                int linjelisteid = rs.getInt("linjeliste_id");
                int antal = rs.getInt("antal");
                int id = rs.getInt("linjeliste_id");
                if (id != lastId) {
                    mat = new Materiale(materialetype, materialenavn, enhedspris, enhed, msr);
                    styk = new StykLinje(materialetype, dimension, baseLength, antal, beskrivelse);
                    li = new LineItem(mat, styk, 0.00);
                    lis.add(li);
                }
            }
            return lis;
        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }

    }

    public static void main(String[] args) throws NewException {
        
        

        
        
        

        

    }
}
