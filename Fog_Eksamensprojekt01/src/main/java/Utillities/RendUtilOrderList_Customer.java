package Utillities;

import Business.LogicFacade;
import Domain.Ordre;
import Domain.Exception.NewException;
import Domain.User;
import java.util.List;

/**
 * Klassen viser en liste af kundens ordre.
 */
public class RendUtilOrderList_Customer {

    /*
     * Metoden laver en tabel, der viser en liste med kundens ordre id, navn,
     * telefonnummer og ordrestatus.
     *  
     * @param ordreList er en liste af kundens ordre.
     * @return en tabel med alle kundens ordrer.
     * @throws NewException
     */
    public static String invoiceList_Customer(List<Ordre> ordreList, User user) throws NewException {

        ordreList = LogicFacade.getOrderListByUserId(user.getUser_id());

        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>Ordre Nr.  </th><th>Dato</th><th> Pris  </th><th> Ordre Status  </th><th></th></tr>\n");
        for (Ordre o : ordreList) {

            sb.append("<tr><form name=\"InvoiceDetail_Customer\" action=\"FrontController\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail_Customer\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail_Customer_DeleteOrder\">");
            //   sb.append("<td>").append("" + DataFacade.getUserByUserId(o.getUser_id()).getFirstname()).append("</td>");
              sb.append("<td>").append("" + o.getOrdre_id()).append("</td>");
               sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
            sb.append("<td>").append("" + LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getPrice()).append("</td>");
            sb.append("<td>").append("" + LogicFacade.getOrderByOrderId2(o.getOrdre_id()).getOrdreStatus()).append("</td>");
            sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"id\" value=\"" + o.getOrdre_id() + "\"><br>\n\n</td>");

            sb.append("</tr>\n");
        }

        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"InvoiceDetail_Customer\">Se Ordren</button> ");
        sb.append("<button type=\"submit\" value=\"action\" onclick=\"javascript:return show_confirmDeletetheOrder();\" name=\"InvoiceDetail_Customer_DeleteOrder\">Slet Orderen</button> ");
        sb.append("</form>\n");
        return sb.toString();
    }
}
