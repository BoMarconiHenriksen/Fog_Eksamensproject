package Data;

import Business.Domain.Materiale;
import Business.Exception.NewException;
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
 * Håntere metoderne til og fra databasen med alt om materialer.
 */
public class MaterialeMapper {

    public static final Logger logger = Logger.getLogger(MaterialeMapper.class.getName());


    /**
     * Her hentes alle information om et materiale for alle materialerne fra materialeliste tabellen.
     *
     * @return mats der er en liste af alle materialer og deres informationer.
     * @throws NewException ved fejl.
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
                double længde = rs.getDouble("længde");

                if (varenummer != lastId) {
                    mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, længde);

                    mats.add(mat);

                }
            }
            return mats;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getMaterial", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Her fåes et materiale ud fra et angivet vareid.
     *
     * @param varenummer er materialets varenummer
     * @return materiale som er information om et beatemt materiale.
     * @throws NewException ved fejl.
     */
    public static Materiale getMaterialeByVarenummer(int varenummer) throws NewException {

        Materiale materiale = null;
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

                materiale = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);
            }

            return materiale;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i getMaterialeByVarenummer", ex);
            throw new NewException(ex.getMessage());
        }

    }

    /**
     * Her ændres et materiales pris ud fra et angivet vareid.
     *
     * @param vareid er materialets id.
     * @param enhedspris er prisen på materialet.
     * @throws NewException ved fejl.
     */
    public static void changeMaterialePris(int vareid, double enhedspris) throws NewException {
        try {
            Connection con = DBConnector.connection();
            String sql = "UPDATE  materialeliste SET enhedspris=? WHERE vareid=?";

            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, enhedspris);
            ps.setInt(2, vareid);
            ps.executeUpdate();

        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Fejl i changeMaterialePris", ex);
            throw new NewException(ex.getMessage());
        }
    }

    public static void main(String[] args) throws NewException {

        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));
        MaterialeMapper.changeMaterialePris(7, 6.95);
        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7).getEnhedspris());
        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));

    }
}
