package Business;

import Data.MaterialeMapper;
import Data.OrdreMapper;
import Data.OdetaljeMapper;
import Data.UserMapper;
import Business.Domain.Materiale;
import Business.Domain.Ordre;
import Business.Domain.Odetaljer;
import Business.Domain.User;
import Business.Exception.NewException;
import java.util.List;

/**
 * Formålet med DataFacade er at lave en enkel klasse hvorigennem man kan tilgå 
 * de forskellige datamppereres metode, og skabe et ekstra lag af sikkerhed i 
 * systemet. For at se beskrivelsen af hver enkel metode se i den pågældende
 * mapper. 
 * Den er en facade mellem business/logik lag og datalaget
 *
 */
public class DataFacade {

//////////////////////////////OrdreMapperMetoder////////////////////////////////////////

    public static void placeAnOrder(int user_id, String receiveddate) throws NewException {
        Ordre theOrdered = new Ordre(user_id, receiveddate);
        OrdreMapper.addOrdertoOrderList(theOrdered);
    }

    public static List<Ordre> getOrderList() throws NewException {
        return OrdreMapper.getOrderList();
    }

    public static List<User> getUserList() throws NewException {
        return UserMapper.getUserList();
    }

    public static Ordre getOrdreByOrderId(int ordre_id) throws NewException {
        return OrdreMapper.getOrdreByOrdreId(ordre_id);
    }

    public static int getLastInvoiceId() throws NewException {
        return OrdreMapper.getLastInvoiceId();
    }

    public static List<Ordre> getOrderListByUserId(int user_id) throws NewException {
        return OrdreMapper.getOrderListByUserID(user_id);
    }

    public static void deleteOrderListByUserId(int order_id) throws NewException {
        OrdreMapper.deleteOrderListByOrderID(order_id);
    }

    public static void deleteOrderDetailsByUserId(int order_id) throws NewException {
        OrdreMapper.deleteOrderDetailsByOrderID(order_id);
    }

    //////////////////////////////OdetaljeMapperMetoder////////////////////////////////////////   

    public static void AddOdetailstoOrdermedSkur(int ordre_id, Odetaljer ods) throws NewException {
        OdetaljeMapper.AddOdetailstoOrdermedSkur(ordre_id, ods);
    }

    public static void addOdetaljertoOdetaljeListe(int ordre_id, Odetaljer od) throws NewException {
        OdetaljeMapper.addOdetaljerToOdetaljeListe(ordre_id, od);
    }

    public static void updateOrdreStatus(int order_id, String ordre_status) throws NewException {
        OdetaljeMapper.updateOrdreStatus(order_id, ordre_status);
    }

    
    public static void updateUserPassword(int user_id, String password) throws NewException {
        UserMapper.updateUserPassword(user_id, password);
    }

    public static void updateWholeUserButID(int user_id, int zip, String email, String password,
            String role, String firstname, String lastname, String address, int tlfnummer) throws NewException {

        UserMapper.updateWholeUserbutID(user_id, zip, email, password, role, firstname, lastname, address, tlfnummer);
    }

    public static Odetaljer getOdetaljerByOrderId(int ordre_id) throws NewException {
        return OdetaljeMapper.getOdetailsByOrderId(ordre_id);
    }

    public static User login(String email, String password) throws NewException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String email, String password, String role,String firstname, String lastname, String address, int zipcode, int tlfnummer) throws NewException {
        User user = new User(email, password, role, firstname, lastname, address, zipcode, tlfnummer);
        UserMapper.createUser(user);
        return user;
    }

    //////////////////////////////MaterialeMapperMetoder////////////////////////////////////////  

    public static Materiale changeMaterialePris(int vareid, double enhedspris) throws NewException {
        Materiale mat = new Materiale(vareid, enhedspris);
        MaterialeMapper.changeMaterialePris(vareid, enhedspris);
        return mat;
    }

    public static Materiale getMaterialeByVarenummer(int varenummer) throws NewException {
        String materialetype = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialetype();
        String materialenavn = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialenavn();
        double enhedspris = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhedspris();
        String enhed = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhed();
        double msr = MaterialeMapper.getMaterialeByVarenummer(varenummer).getLængde();
        Materiale mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);
        return mat;
    }

    public static List<Materiale> getMaterial() throws NewException {
        return MaterialeMapper.getMaterial();
    }

    //////////////////////////////UserMapperMetoder////////////////////////////////////////  

    public static User getUserByUserId(int user_id) throws NewException {
        return UserMapper.getUserByUserId(user_id);
    }

    public static void main(String[] args) throws NewException {

        System.out.println(DataFacade.getOdetaljerByOrderId(3));
//        DataFacade.changeMaterialePris(7, 29.95);
//        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));
//
//        System.out.println(StykLinjeMapper.getStykLinje());
//
//        System.out.println(StykLinjeMapper.getStykLinjeById(2));

    }

}
