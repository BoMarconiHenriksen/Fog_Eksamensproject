package Presentation;

import Business.Exception.NewException;
import Business.DataFacade;
import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;
import Business.Domain.User;
import Presentation.Utillities.RendUtilOrderList;
import Presentation.Utillities.RendUtilUserlist_FullDiscription;
import Presentation.Utillities.RendSvg;
import Presentation.Utillities.RendSvgNd;
import Presentation.Utillities.RendUtilStykListe;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Denne class er en af commands'ne. Bruges på employee_order_list til at
 * navigere medarbejderen over på employee_invoice_detail.jsp og fremvise pris,
 * tegning og stykliste på den valgte ordre samt - tage imod en ny status og
 * implementere den på ordren nede i databasen Den bruges også til at navigere
 * medarbejderen tilbage til employee_ordre_list.jsp og fremvise listen af alle
 * kundernes ordre igen samt - at slette en ordre på employee_ordre_list.jsp.
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

            return "employee_usercontrolpage";
        } else {

            int orderid = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("orderid", orderid);

            Odetaljer oDetaljer = DataFacade.getOdetaljerByOrderId(orderid);
            request.setAttribute("od", oDetaljer);

            double length = (Double) oDetaljer.getCarportLength();
            double width = (Double) oDetaljer.getCarportWidth();
            double skurlength = (Double) oDetaljer.getLengthRedskabsrum();
            double skurWidth = (Double) oDetaljer.getWidthRedskabsrum();
            double price = oDetaljer.getPrice();
            request.setAttribute("priceTwoDecimal", price);
            RendUtilStykListe XXStykListe = new RendUtilStykListe();
            String LineItemsList;
            LineItemsList = XXStykListe.createLineItemList(length, width, skurlength, skurWidth);
            request.setAttribute("LineItemsList", LineItemsList);
            RendSvg svag = new RendSvg();
            String carportTegning = svag.simpelCarport(length, width, skurlength, skurWidth);
            request.setAttribute("carportTegning", carportTegning);

            RendSvgNd svagNd = new RendSvgNd();
            String carportTegningNd = svagNd.simpelCarportSide(length, width, skurlength, skurWidth);
            request.setAttribute("carportTegningNd", carportTegningNd);

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
