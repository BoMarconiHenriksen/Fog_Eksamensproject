package Presentation.Utillities;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;

/**
 * Klassen bruges til at lave en tabel over kundens ordrer og odredetaljer.
 *
 */
public class RendUtilCustomerOdetailsFunktions {

    /**
     * metoden returnerer en tabel over kundens ordrer og odredetaljer.
     *
     * @param oDetaljer de ordredetaljer der hentes når kunden vælger en ordre
     * @return
     * @throws NewException
     */
    public static String odetailsForOrder_Customer(Odetaljer oDetaljer) throws NewException {

        Ordre order = LogicFacade.getOrdreByOrderId(oDetaljer.getOrdreId());
        StringBuilder sb = new StringBuilder();

        if (oDetaljer.getOrdreStatus().equalsIgnoreCase("Gemt Design")) {

            sb.append("<form name=\"Checkout\" action=\"FrontController\" method=\"POST\">\n");
            sb.append(" <input type=\"hidden\" name=\"command\" value=\"OrdertheOrder\">");
            sb.append("<table border=1>\n");
            sb.append("<tr><h3>Ordre detaljer</h3></tr>\n");
            sb.append("<tr><th>Ordre Id</th><th>Dato</th><th>Status</th></tr>\n");
            sb.append("<td>").append("").append(oDetaljer.getOrdreId()).append("</td>");
            sb.append("<td>").append("").append(order.getReciveddate()).append("</td>");
            sb.append("<td>").append("").append(LogicFacade.getOdetaljerByOrderId(oDetaljer.getOrdreId()).getOrdreStatus()).append("</td>");
            sb.append("</table>\n>");
            sb.append("<input type=\"radio\"checked=\"checked\" name=\"id\" value=\"").append(oDetaljer.getOrdreId()).append("\"><br>\n");
            sb.append("<button type=\"submit\" value=\"OrdertheOrder\" name=\"Checkout\">Bestil</button> ");
            sb.append("</form>\n");

        } else {
            sb.append("<tr><h3>Ordren er bestilt, og du kan derfor ikke ændre dens status mere. Kontakt os hvis du har spørgsmål.</h3></tr>\n");
        }

        return sb.toString();
    }
}
