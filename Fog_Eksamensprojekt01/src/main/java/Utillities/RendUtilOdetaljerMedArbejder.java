package Utillities;

import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.Ordre;
import Presentation.NewException;

/**
 *
 * @author Bo
 */
public class RendUtilOdetaljerMedArbejder {

    public static String customerDetailsForOrder(Odetaljer od) throws NewException {
        Ordre o = LogicFacade.getOrdreByOrderId(od.getOrdreId());
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=1>\n");

        sb.append("<tr><form name=\"setOrderStatus\" action=\"FrontController\" method=\"POST\">");
        sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"setOrderStatus\">");
        sb.append("<tr><h3>Kundeoplysninger</h3></tr>\n");
        sb.append("<tr><th></th><th></th></tr>\n"
                + "<tr><th>Fornavn</th><th>Telefon nr</th></tr>\n");
        sb.append("<td>").append("" + LogicFacade.getUserByUserId(o.getUser_id()).getFirstname()).append("</td>");
        sb.append("<td>").append("" + LogicFacade.getUserByUserId(o.getUser_id()).getTlfnummer()).append("</td>");

        sb.append("</table>\n");
        return sb.toString();
    }

    public static String odetailsForOrder(Odetaljer od) throws NewException {

        Ordre o = LogicFacade.getOrdreByOrderId(od.getOrdreId());

        StringBuilder sb = new StringBuilder();
        sb.append("<form name=\"InvoiceSetStatus\" action=\"FrontController\" method=\"POST\">");
        sb.append("<input type=\"hidden\" name=\"command\" value=\"InvoiceSetStatus\">");
        sb.append("<table border=1>\n");
        sb.append("<tr><h3>Ordre detaljer</h3></tr>\n");
        sb.append("<tr><th>InvoiceId</th><th>Date</th><th>status</th></tr>\n");
        sb.append("<td>").append("" + od.getOrdreId()).append("</td>");
        sb.append("<td>").append("" + o.getReciveddate()).append("</td>");
        sb.append("<td>").append("" + LogicFacade.getOrderByOrderId2(od.getOrdreId()).getOrdreStatus()).append("</td>");

        sb.append("</table>\n>");
        sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"id\" value=\"" + od.getOrdreId() + "\"><br>\n\n</td>");
        sb.append(" <select name=\"status\">\n"
                + "  <option text=\"Ny Ordre\">Ny Ordre</option>\n"
                + "  <option text=\"Bestilt\">Bestilt</option>\n"
                + "<option text=\"Modtaget\">Modtaget</option>\n"
                + " <option text=\"Betalt\">Betalt</option>\n"
                + " <option text=\"Pakkes\">Pakkes</option>"
                + " <option text=\"Afsendt\">Afsendt</option>\n"
                + " <option text=\"Leveret\">Leveret</option>\n"
                + "</select>"
        );

        sb.append("<button type=\"submit\" value=\"action\" name=InvoiceSetStatus\">Sæt Ordre Status</button> ");
        sb.append("</form>\n");

        return sb.toString();
    }
}
