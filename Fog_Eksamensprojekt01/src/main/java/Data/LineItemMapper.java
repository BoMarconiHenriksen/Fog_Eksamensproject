package Data;

import Domain.LineItem;
import Domain.Materiale;
import Domain.Odetaljer;
import Domain.Ordre;
import Domain.StykLinje;
import Domain.User;
import Presentation.NewException;
import com.mysql.cj.mysqlx.protobuf.MysqlxCrud;
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

    public static LineItem updateVareId(int linjeliste_id, int vareid, double msr) throws NewException {
        StykLinje styl = null;
        Materiale mat = null;
        try {

            Connection con = DBConnector.connection();
            String SQL;
            SQL = "update lineitem, linjeliste set vareid=?, baselength=? where lineitem.linjeliste_id=" + linjeliste_id;
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, vareid);
            ps.setDouble(2, msr);
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new NewException(ex.getMessage());
        }
        return null;

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

              

                int antal = rs.getInt("antal");
                int id = rs.getInt("linjeliste_id");
                if (id != lastId) {
                    mat = new Materiale(materialetype, materialenavn, enhedspris, enhed, msr);

                    styk = new StykLinje(materialetype, dimension, baseLength, antal, beskrivelse);
                    li = new LineItem(mat, styk);
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
