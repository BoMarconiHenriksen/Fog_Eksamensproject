package Presentation;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;
import Business.Domain.User;
import Presentation.Utillities.RendUtilOrderList_Customer;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class InvoiceDetail_Customer extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        response.setContentType("text/html;charset=UTF-8");
        String deleteTheOrder;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String lockIntoOrder = request.getParameter("InvoiceDetail_Customer");

        deleteTheOrder = request.getParameter("InvoiceDetail_Customer_DeleteOrder");

        String SetOrderStatusByCustomer = request.getParameter("InvSetOrderStatusbyCustomer");

        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);

        Odetaljer oDetaljer = LogicFacade.getOrderByOrderId2(orderid);

        request.setAttribute("length", (Double) oDetaljer.getCarportLength());
        request.setAttribute("width", (Double) oDetaljer.getCarportWidth());
        request.setAttribute("height", (Double) oDetaljer.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) oDetaljer.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) oDetaljer.getWidthRedskabsrum());
        request.setAttribute("od", oDetaljer);

        if (deleteTheOrder != null) {
            LogicFacade.deleteOrderDetailsByUserId(orderid);
            LogicFacade.deleteOrderListByUserId(orderid);

            //Samme kode som i Ordreliste_Customer.java, men ellers vil den ikke vise det igen.
            List<Ordre> ordreList = LogicFacade.getOrderListByUserId(user.getUser_id());
            String customer_Orderlist = RendUtilOrderList_Customer.invoiceList_Customer(ordreList, user);
            request.setAttribute("customer_orderlist", customer_Orderlist);
            return "customer_order_list";
        }
        if (lockIntoOrder != null) {

            return "customer_invoice_detail";
        }

        if (SetOrderStatusByCustomer != null) {

            String status = request.getParameter("status");

            LogicFacade.updateOrdreStatus(orderid, status);

            return "customer_invoice_detail";

        } else {
            return "customerpage";
        }
    }
}
