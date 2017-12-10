/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Domain.Exception.NewException;
import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.Ordre;
import Domain.User;
import Utillities.RendUtilOrderList_Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        String LockIntoOrder = request.getParameter("InvoiceDetail");
        String DeletetheOrder = request.getParameter("InvoiceDetail_Admin_DeleteOrder");
        String SetOrderStatusbyCustomer = request.getParameter("InvSetOrderStatusbyCustomer");

        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);

        Odetaljer od = LogicFacade.getOrderByOrderId2(orderid);

        request.setAttribute("length", (Double) od.getCarportLength());
        request.setAttribute("width", (Double) od.getCarportWidth());
        request.setAttribute("height", (Double) od.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) od.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) od.getWidthRedskabsrum());
        request.setAttribute("od", od);

        if (DeletetheOrder != null) {
            LogicFacade.deleteOrderDetailsByUserId(orderid);
            LogicFacade.deleteOrderListByUserId(orderid);

            //Samme kode som i Ordreliste_Customer.java, men ellers vil den ikke vise det igen.
            List<Ordre> ordreList = LogicFacade.getOrderListByUserId(user.getUser_id());
            String customer_Orderlist = RendUtilOrderList_Customer.invoiceList_Customer(ordreList, user);
            request.setAttribute("customer_orderlist", customer_Orderlist);
            return "ordrelist_customer";
        }
        if (LockIntoOrder != null) {
            
            

            return "invoice_detail_customer";
        }
        
        if (SetOrderStatusbyCustomer != null){
        
        String status=request.getParameter("status");
        
        LogicFacade.updateOrdreStatus(orderid, status);
        
        
        
        return "invoice_detail_customer";
        
        } else {
            return "customerpage";
        }
    }
}
