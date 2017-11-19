package Utillities;

import Business.LogicFacade;
import Domain.Ordre;
import Presentation.NewException;
import java.util.List;

/**
 *
 * @author Bo
 */
public class RendUtilOrderList {

    public static String invoiceList(List<Ordre> ordreList) throws NewException {

        ordreList = LogicFacade.getOrderList();

        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>InvoiceId</th><th>Date</th><th></th></tr>\n");
        for (Ordre o : ordreList) {

            sb.append("<tr><form name=\"invoice_detailAdmin\" action=\"InvoiceHistoryCustomerServlet\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detailAdmin\">");
            sb.append("<td>").append("" + o.getOrdre_id()).append("</td>");
            sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
            sb.append("<td>\n <input type=\"radio\" name=\"id\" value=\"" + o.getOrdre_id() + "\"><br>\n\n</td>");

            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=invoice_detail\">See order</button> ");
        sb.append("</form>\n");
        return sb.toString();

    }

}
