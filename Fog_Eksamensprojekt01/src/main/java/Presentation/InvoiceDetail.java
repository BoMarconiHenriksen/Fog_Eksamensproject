package Presentation;

import Domain.Exception.NewException;
import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOrderList;
import Utillities.RendUtilOrderList_Customer;
import Utillities.RendUtilUserList;
import Utillities.RendUtilUserlist_FullDiscription;
import Utillities.XXRendSvg;
import Utillities.XXRendUtilStykListe;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bo
 */
public class InvoiceDetail extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User us = new User();
        String LockIntoOrder = request.getParameter("InvoiceDetail");
        String DeletetheOrder = request.getParameter("InvoiceDetail_Admin_DeleteOrder");
        String EditUser = request.getParameter("InvoiceDetail_Admin_UserEdit");

        if (EditUser != null) {
            
            int choseUser = Integer.parseInt(request.getParameter("theUser_id"));
            
            LogicFacade.getUserByUserId(choseUser);

            request.setAttribute("customerID", us.getUser_id());
            request.setAttribute("userRole", us.getRole());
            request.setAttribute("userEmail", us.getEmail());
            request.setAttribute("userFirstname", us.getFirstname());
            request.setAttribute("userLastname", us.getLastname());
            request.setAttribute("userPostcode", us.getZip());
            request.setAttribute("userAddress", us.getAddress());
            request.setAttribute("userTlfnummer", us.getTlfnummer());
            request.setAttribute("userPassword", us.getPassword());

            int userNotifyValue = 0;
            request.setAttribute("outprintnotifystatus", userNotifyValue);

            return "employee_usercontrolpage";
        }

        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);

        Odetaljer od = LogicFacade.getOdetaljerByOrderId(orderid);
        request.setAttribute("od", od);

        double length = (Double) od.getCarportLength();
        double width = (Double) od.getCarportWidth();
        double skurlength = (Double) od.getLengthRedskabsrum();
        double skurWidth = (Double) od.getWidthRedskabsrum();
        double price = od.getPrice();
        request.setAttribute("priceTwoDecimal", price);
        XXRendUtilStykListe XXStykListe = new XXRendUtilStykListe();
        String LineItemsList;
        LineItemsList = XXStykListe.createLineItemList(length, width, skurlength, skurWidth);
        request.setAttribute("LineItemsList", LineItemsList);
        XXRendSvg svag = new XXRendSvg();
        String carportTegning = svag.simpelCarport(length, width, skurlength, skurWidth);
        request.setAttribute("carportTegning", carportTegning);

        if (DeletetheOrder != null) {
            LogicFacade.deleteOrderDetailsByUserId(orderid);
            LogicFacade.deleteOrderListByUserId(orderid);

            //Samme kode som i Ordreliste_Customer.java, men ellers vil den ikke vise det igen.
            List<Ordre> ordreList = LogicFacade.getOrderList();
            String customer_Orderlist = RendUtilOrderList.invoiceList(ordreList);
            request.setAttribute("employee_orderlist", customer_Orderlist);

            List<User> userList = LogicFacade.getUserList();
            String employee_Userlist = RendUtilUserlist_FullDiscription.invoiceList(userList);
            request.setAttribute("employee_userlist", employee_Userlist);

            return "employee_ordre_list";
        }
        if (LockIntoOrder != null) {

            return "employee_invoice_detail";
        }

        return "emplyee_invoice_detail";
    }
}
