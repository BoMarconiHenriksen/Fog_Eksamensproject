package Business.Utilities;

import Business.LogicFacade;
import Business.Domain.Ordre;
import Business.Exception.NewException;
import java.util.List;

/**
 *
 * @author Bo Klassen bruger StringBuilder til at rendere en liste over alle
 * ordrer ,med med enkelte ordredetaljer fra odetalje klassen.
 */
public class RendUtilOrderList {

    /**
     * Metoden bruger StringBuilder til at skabe en streng der kan rendere en
     * liste over alle ordrer ,med med enkelte ordredetaljer fra odetalje
     * klassen, samt en htmlform med en submit knap der fører brugeren fra den
     * jsp side ordrelisten blever kaldt på gennem en command der hedder
     * invoicedetail.jave. Dette gøres ved at at hente en liste af alle ordrer
     * fra databasen gennem logicFacaden og derefter iterere igennem listen af
     * ordrer, og hente forskellige af de gemte værdier. 
     * @param ordreList er en liste af ordre fra databasen
     * @return sb.toString
     * @exception NewException er vores egen exception kastet fra datalaget og
     * som bliver håndteret i FrontControlleren
     * 
     */
    public static String invoiceList(List<Ordre> ordreList) throws NewException {

        ordreList = LogicFacade.getOrderList();

        StringBuilder sb = new StringBuilder();

        sb.append("<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>Ordre Id  </th><th>Dato  </th><th>Pris  </th><th>Kundens fornavn  </th><th>Telefon nr  </th><th>Status  </th></tr>\n");
        for (Ordre o : ordreList) {

            sb.append("<tr><form name=\"InvoiceDetail\" action=\"FrontController\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail\">");
            sb.append("<td>").append("  ").append(o.getOrdre_id()).append("</td>");
            sb.append("<td>").append("  ").append(o.getReciveddate()).append("</td>");
            sb.append("<td>").append("  ").append(LogicFacade.getOdetaljerByOrderId((o.getOrdre_id())).getPrice()).append("").append("</td>");
            sb.append("<td>").append("  ").append(LogicFacade.getUserByUserId((o.getUser_id())).getFirstname()).append("</td>");
            sb.append("<td>").append("  ").append(LogicFacade.getUserByUserId((o.getUser_id())).getTlfnummer()).append("</td>");
            sb.append("<td>").append("  ").append(LogicFacade.getOdetaljerByOrderId((o.getOrdre_id())).getOrdreStatus()).append("</td>");
            sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"id\" value=\"").append(o.getOrdre_id()).append("\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"InvoiceDetail\">Se Ordre</button> ");
        sb.append("<button type=\"submit\" value=\"action\" onclick=\"javascript:return show_confirmDeletetheOrder();\" name=\"InvoiceDetail_Admin_DeleteOrder\">Slet Orderen</button> ");
        sb.append("</form>\n");
        return sb.toString();
    }

}
