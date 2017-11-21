package Business;

import Data.LineItemMapper;
import Data.MaterialeMapper;
import Data.StykLinjeMapper;
import Domain.LineItem;
import Domain.Materiale;
import Domain.Order;
import Domain.StykLinje;
import Domain.User;
import Presentation.NewException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The purpose of LogicFacade is to...
 *
 * Author @ BenedikteEva
 */
public class LogicFacade {

    public static List<Materiale> getMaterial() throws NewException {
        return MaterialeMapper.getMaterial();

    }

    public static Materiale getMaterialeByVarenummer(int varenummer) throws NewException {
        String materialetype = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialetype();
        String materialenavn = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMaterialenavn();
        double enhedspris = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhedspris();
        String enhed = MaterialeMapper.getMaterialeByVarenummer(varenummer).getEnhed();
        double msr = MaterialeMapper.getMaterialeByVarenummer(varenummer).getMsr();
        Materiale mat = new Materiale(varenummer, materialetype, materialenavn, enhedspris, enhed, msr);
        return mat;
    }

    public static List<StykLinje> getStykLinje() throws NewException {
        return StykLinjeMapper.getStykLinje();
    }

    public static List<LineItem> getLineItem() throws NewException {
        return LineItemMapper.getLineItems();
    }
    
    public static Order placeAnOrder(int user_id, String receiveddate) throws NewException{
        Order theOrdered = new Order(user_id, receiveddate);
        LineItemMapper.addOrdertoOrderList(theOrdered);
        return theOrdered;
        
    }
    
    public static List<Order> getOrderList() throws NewException{
        return LineItemMapper.getOrderList();
    }

    public static Materiale changeMaterialePris(int vareid, double enhedspris) throws NewException {
        Materiale mat = new Materiale(vareid, enhedspris);
        MaterialeMapper.changeMaterialePris(vareid, enhedspris);
        return mat;
    }

    public static void main(String[] args) throws NewException, ClassNotFoundException, SQLException {

        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));
        LogicFacade.changeMaterialePris(7, 29.95);
        System.out.println(MaterialeMapper.getMaterialeByVarenummer(7));

        System.out.println(StykLinjeMapper.getStykLinje());

        System.out.println(StykLinjeMapper.getStykLinjeById(2));

    }

//    public static User login(String username, String email, String password) throws BenedikteEvasNewException {
//        return UserMapper.login(email, password);
//    }
//
//    public static User createUser(String username, String email, String password) throws BenedikteEvasNewException {
//        User user = new User(username, email, password);
//        UserMapper.createUser(user);
//        return user;
//    }
//
//    public static List<User> getAllUsers() throws BenedikteEvasNewException {
//        return UserMapper.getAllUsers();
//    }
}
