package Presentation;

import Domain.Exception.NewException;
import Business.LogicFacade;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOrderList;
import Utillities.RendUtilUserList;
import Utillities.RendUtilUserlist_FullDiscription;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bo
 */
public class OrdreList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        //  List<Ordre> invoiceList = LogicFacade.getOrderList();
        //   RendUtilOrderList.invoiceList(invoiceList);
        //   request.setAttribute("invoiceList", invoiceList);
        List<User> userList = LogicFacade.getUserList();
        String admin_Userlist = RendUtilUserlist_FullDiscription.UserListAdmin(userList);

        List<Ordre> ordreList = LogicFacade.getOrderList();
        String admin_Orderlist = RendUtilOrderList.invoiceList(ordreList);

        request.setAttribute("admin_userlist", admin_Userlist);

        if (ordreList.isEmpty()) {

            request.setAttribute("admin_orderlist", "Der er ikke nogen ordre."
                    + "Hvis der er nogen der har bestilt en ordre, vil den fremgå her på siden.");

        } else {

            request.setAttribute("admin_orderlist", admin_Orderlist);

        }
        return "ordre_liste";
    }
}
