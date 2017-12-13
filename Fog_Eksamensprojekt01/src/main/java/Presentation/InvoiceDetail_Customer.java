package Presentation;

import Domain.Exception.NewException;
import Business.DataFacade;
import Domain.Odetaljer;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOrderList_Customer;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ticondrus
 */
public class InvoiceDetail_Customer extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        response.setContentType("text/html;charset=UTF-8");
        String DeletetheOrder;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String LockIntoOrder = request.getParameter("InvoiceDetail_Customer");

        DeletetheOrder = request.getParameter("InvoiceDetail_Customer_DeleteOrder");

        String SetOrderStatusbyCustomer = request.getParameter("InvSetOrderStatusbyCustomer");

        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);

        Odetaljer od = DataFacade.getOrderByOrderId2(orderid);

        request.setAttribute("length", (Double) od.getCarportLength());
        request.setAttribute("width", (Double) od.getCarportWidth());
        request.setAttribute("height", (Double) od.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) od.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) od.getWidthRedskabsrum());
        request.setAttribute("od", od);

        if (DeletetheOrder != null) {
            DataFacade.deleteOrderDetailsByUserId(orderid);
            DataFacade.deleteOrderListByUserId(orderid);

            //Samme kode som i Ordreliste_Customer.java, men ellers vil den ikke vise det igen.
            List<Ordre> ordreList = DataFacade.getOrderListByUserId(user.getUser_id());
            String customer_Orderlist = RendUtilOrderList_Customer.invoiceList_Customer(ordreList, user);
            request.setAttribute("customer_orderlist", customer_Orderlist);
            return "customer_order_list";
        }
        if (LockIntoOrder != null) {

            return "customer_invoice_detail";
        }

        if (SetOrderStatusbyCustomer != null) {

            String status = request.getParameter("status");

            DataFacade.updateOrdreStatus(orderid, status);

            return "customer_invoice_detail";

        } else {
            return "customerpage";
        }
    }
}
