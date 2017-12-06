/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.Ordre;
import Presentation.NewException;

/**
 *
 * @author Ticondrus
 */
public class RendUtilCustomerOdetailsFunktions {
    
    public static String odetailsForOrder_Customer(Odetaljer od) throws NewException {

        Ordre o = LogicFacade.getOrdreByOrderId(od.getOrdreId());

        StringBuilder sb = new StringBuilder();
        sb.append("<form name=\"InvoiceDetail_Customer\" action=\"FrontController\" method=\"POST\">");
        sb.append("<input type=\"hidden\" name=\"command\" value=\"InvSetOrderStatusbyCustomer\">");
        sb.append("<table border=1>\n");
        sb.append("<tr><h3>Ordre detaljer</h3></tr>\n");
        sb.append("<tr><th>Ordre Id</th><th>Date</th><th>status</th></tr>\n");
        sb.append("<td>").append("" + od.getOrdreId()).append("</td>");
        sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
        sb.append("<td>").append("" + LogicFacade.getOrderByOrderId2(od.getOrdreId()).getOrdreStatus()).append("</td>");

        sb.append("</table>\n>");
        sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"id\" value=\"" + od.getOrdreId() + "\"><br>\n\n</td>");
        sb.append(" <select name=\"status\">\n"
                + "  <option text=\"Ny Ordre\">Ny Ordre</option>\n"
                + "  <option text=\"Bestilt\">Bestilt</option>\n"
                + "<option text=\"Gemt Design\">Gemt Design</option>\n"
                + "</select>"
        );

        sb.append("<button type=\"submit\" value=\"action\" name=\"InvSetOrderStatusbyCustomer\">Sæt Ordre Status</button> ");
        sb.append("</form>\n");

        return sb.toString();
    }
}