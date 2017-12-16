package Presentation;

import Business.Exception.NewException;
import Business.DataFacade;
import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;
import Business.Domain.User;
import Presentation.Utillities.RendUtilOrderList;
import Presentation.Utillities.RendUtilUserlist_FullDiscription;
import Presentation.Utillities.XXRendSvg;
import Presentation.Utillities.XXRendUtilStykListe;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class InvoiceDetail extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        User us = new User();
        String lockIntoOrder = request.getParameter("InvoiceDetail");
        String deletetheOrder = request.getParameter("InvoiceDetail_Admin_DeleteOrder");
        String editUser = request.getParameter("InvoiceDetail_Admin_UserEdit");

        if (editUser != null) {

            int choseUser = Integer.parseInt(request.getParameter("theUser_id"));

            us = LogicFacade.getUserByUserId(choseUser);

            request.setAttribute("customerID", us.getUser_id());
            request.setAttribute("userRole", us.getRole());
            request.setAttribute("userEmail", us.getEmail());
            request.setAttribute("userFirstname", us.getFirstname());
            request.setAttribute("userLastname", us.getLastname());
            request.setAttribute("userPostcode", us.getZip());
            request.setAttribute("userAddress", us.getAddress());
            request.setAttribute("userTlfnummer", us.getTlfnummer());
            request.setAttribute("userPassword", us.getPassword());


//            int userNotifyValue = 0;
//            request.setAttribute("outprintnotifystatus", userNotifyValue);
            return "employee_usercontrolpage";
        } else {

            int orderid = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("orderid", orderid);

            Odetaljer od = DataFacade.getOdetaljerByOrderId(orderid);
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

            if (deletetheOrder != null) {
                DataFacade.deleteOrderDetailsByUserId(orderid);
                DataFacade.deleteOrderListByUserId(orderid);

                //Samme kode som i Ordreliste_Customer.java, men ellers vil den ikke vise det igen.
                List<Ordre> ordreList = DataFacade.getOrderList();
                String customer_Orderlist = RendUtilOrderList.invoiceList(ordreList);
                request.setAttribute("employee_orderlist", customer_Orderlist);

                List<User> userList = DataFacade.getUserList();
                String employee_Userlist = RendUtilUserlist_FullDiscription.invoiceList(userList);
                request.setAttribute("employee_userlist", employee_Userlist);

                return "employee_ordre_list";
            }
            if (lockIntoOrder != null) {

                return "employee_invoice_detail";
            }

            return "employee_invoice_detail";
        }
    }
}
