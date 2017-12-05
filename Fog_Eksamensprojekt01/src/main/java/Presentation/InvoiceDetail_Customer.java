/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.User;
import java.io.IOException;
import java.io.PrintWriter;
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
        String LockIntoOrder = request.getParameter("InvoiceDetail_Customer");
        String DeletetheOrder = request.getParameter("InvoiceDetail_Customer_DeleteOrder");
        
       

        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);
        
         
         
        Odetaljer od = LogicFacade.getOrderByOrderId2(orderid);

        request.setAttribute("length", (Double) od.getCarportLength());
        request.setAttribute("width", (Double) od.getCarportWidth());
        request.setAttribute("height", (Double) od.getCarportHeight());
        request.setAttribute("redskabsskur_length", (Double) od.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double) od.getWidthRedskabsrum());
        request.setAttribute("od", od);
        
        if (DeletetheOrder != null){
            LogicFacade.deleteOrderDetailsByUserId(orderid);
            LogicFacade.deleteOrderListByUserId(orderid);
            return "ordrelist_customer";
        }
        if ( LockIntoOrder != null){
       
        return "invoice_detail_customer";
    } else {
            return "index";
        }
}
}