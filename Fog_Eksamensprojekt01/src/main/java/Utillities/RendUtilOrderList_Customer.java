package Utillities;

import Business.LogicFacade;
import Domain.Ordre;
import Presentation.NewException;
import java.util.List;

/**
 *
 * @author Bo
 */
public class RendUtilOrderList_Customer {

    public static String invoiceList_Customer(List<Ordre> ordreList) throws NewException {

        ordreList = LogicFacade.getOrderListByUserId(2);

        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>Dit Navn</th><th>Telefonnummer</th><th>Ordre ID</th><th>Date</th><th> Ordre Status</th><th></th></tr>\n");
        for (Ordre o : ordreList) {

            sb.append("<tr><form name=\"InvoiceDetail_Customer\" action=\"FrontController\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail_Customer\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail_Customer_DeleteOrder\">");
            sb.append("<td>").append("" + LogicFacade.getUserByUserId(o.getUser_id()).getFirstname()).append("</td>");
            sb.append("<td>").append("" + LogicFacade.getUserByUserId(o.getUser_id()).getTlfnummer()).append("</td>");
            sb.append("<td>").append("" + o.getOrdre_id()).append("</td>");
            sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
            sb.append("<td>").append("" + LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getOrdreStatus()).append("</td>");
            sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"id\" value=\"" + o.getOrdre_id() + "\"><br>\n\n</td>");

            sb.append("</tr>\n");
        }

        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"InvoiceDetail_Customer\">Se Ordren</button> ");
        sb.append("<button type=\"submit\" value=\"action\" name=\"InvoiceDetail_Customer_DeleteOrder\">Slet Orderen</button> ");
        sb.append("</form>\n");
        return sb.toString();
    }
}
