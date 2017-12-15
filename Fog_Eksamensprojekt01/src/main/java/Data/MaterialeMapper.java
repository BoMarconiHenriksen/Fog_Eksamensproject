package Data;

import Domain.Materiale;
import Domain.Exception.NewException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * MaterialleMapper: Håntere forbindelse til og fra databasen med alt vedr.
 * materialer.
 */
public class MaterialeMapper {

    public static final Logger logger = Logger.getLogger(MaterialeMapper.class.getName());


    /**
     * Her hentes alle beskrivelser på et materiale fra materialeliste tabellen.
     *
     * @return mats
     * @throws NewException
     */


    public static List<Materiale> getMaterial() throws NewException {

        List<Materiale> mats = new ArrayList();
        try {

            Materiale mat;
            Connection con = DBConnector.connection();
            String sql = "select * from materialeliste";
            ResultSet rs = con.prepareStatement(sql).executeQuery();
            int lastId = -1;

            while (rs.next()) {
                int varenummer = rs.getInt("vareid");
                String materialetype = rs.getString("materialetype");
                String materialenavn = rs.getString("materialenavn");
                double enhedspris = rs.getDouble("enhedspris");
                String enhed = rs.getString("enhed");
                double msr = rs.getDouble("længde");

                if (varenummer != lastId) {
                    mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);

                    mats.add(mat);

                }
            }
            return mats;
        } catch (SQLException | ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Fejl i getMaterial", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Her fåes et materiale ud fra et angivet vareid.
     *
     * @param varenummer
     * @return mat
     * @throws NewException
     */
    public static Materiale getMaterialeByVarenummer(int varenummer) throws NewException {

        Materiale mat = null;
        try {

            Connection con = DBConnector.connection();
            String sql = "select * from materialeliste where vareid=" + varenummer;

            ResultSet rs = con.prepareStatement(sql).executeQuery();

            if (rs.next()) {
                String materialetype = rs.getString("materialetype");
                String materialenavn = rs.getString("materialenavn");
                double enhedspris = rs.getDouble("enhedspris");
                String enhed = rs.getString("enhed");
                double msr = rs.getDouble("længde");

                mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);
            }

            return mat;
        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getMaterialeByVarenummer", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Her ændres et materiales pris ud fra et angivet vareid.
     *
     * @param vareid
     * @param enhedspris
     * @throws NewException
     */
    public static void changeMaterialePris(int vareid, double enhedspris) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String sql = "UPDATE  materialeliste SET enhedspris=? WHERE vareid=?";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, enhedspris);
            ps.setInt(2, vareid);
            ps.executeUpdate();

        } catch (ClassNotFoundException | SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i changeMaterialePris", ex);
            throw new NewException(ex.getMessage());
        }
    }

    /**
     * Dette er en mainmetode som kun benyttes til trst o forbindelse med
     * mapperens virkegrad.
     *
     * @param args
     * @throws NewException
     */
    public static void main(String[] args) throws NewException {

        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));
        MaterialeMapper.changeMaterialePris(7, 6.95);
        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7).getEnhedspris());
        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));

    }
}
