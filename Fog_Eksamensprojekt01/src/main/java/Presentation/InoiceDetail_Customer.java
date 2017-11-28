/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.LogicFacade;
import Domain.Odetaljer;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ticondrus
 */

public class InoiceDetail_Customer extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        response.setContentType("text/html;charset=UTF-8");
        
       
    
        int orderid = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("orderid", orderid);
        Odetaljer od = LogicFacade.getOrderByOrderId2(orderid);

        

        request.setAttribute("length", (Double)od.getCarportLength());
        request.setAttribute("width", (Double)od.getCarportWidth());
        request.setAttribute("height", (Double)od.getCarportHeight());
        request.setAttribute("redskabsskur_length",(Double) od.getLengthRedskabsrum());
        request.setAttribute("redskabsskur_width", (Double)od.getWidthRedskabsrum());
        request.setAttribute("od", od);
        return "invoice_detail_customer";
    }
}