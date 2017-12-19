package Presentation.Utillities;

import Business.LogicFacade;
import Business.Domain.Odetaljer;
import Business.Domain.Ordre;
import Business.Exception.NewException;

/**
 * Klassen udskriver tabeller om kunden, kundens ordre og status til medarbejderen
 * 
 */
public class RendUtilOdetaljerMedArbejder {
    
    /**
     * Metoden laver en tabel, der indeholder kundens oplysninger
     * @param oDetaljer bruges til at hente kundens id
     * @return en tabel, der indeholder kundens navn, adresse, postnummer og telefonnummer.
     * @throws NewException 
     */
    public static String customerDetailsForOrder(Odetaljer oDetaljer) throws NewException {
        Ordre order = LogicFacade.getOrdreByOrderId(oDetaljer.getOrdreId());
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=1>\n");

        sb.append("<tr><form name=\"setOrderStatus\" action=\"FrontController\" method=\"POST\">");
        sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"setOrderStatus\">");
        sb.append("<tr><h3>Kundeoplysninger</h3></tr>\n");
        sb.append("<tr><th></th><th></th></tr>\n"
                + "<tr><th>Fornavn</th><th>Adresse</th><th>Postnummer</th><th>Telefon nr</th></tr>\n");
        sb.append("<td>").append("" + LogicFacade.getUserByUserId(order.getUser_id()).getFirstname() + " " 
                + LogicFacade.getUserByUserId(order.getUser_id()).getLastname() ).append("</td>");
        sb.append("<td>").append("" + LogicFacade.getUserByUserId(order.getUser_id()).getAddress()).append("</td>");
        sb.append("<td>").append("" + LogicFacade.getUserByUserId(order.getUser_id()).getZip()).append("</td>");
        sb.append("<td>").append("" + LogicFacade.getUserByUserId(order.getUser_id()).getTlfnummer()).append("</td>");

        sb.append("</table>\n");
        return sb.toString();
    }

    /**
     * Metoden bruges til at hente status på en ordre, og til at sætte en ny ordre status.
     * @param oDetaljer bruges til at hente ordre id.
     * @return en tabel, der indeholder ordre id, dato for ordre modtagelse, ordrestatus og en dropdown med de ordre statusser, der kan sættes. 
     * @throws NewException 
     */
    public static String odetailsForOrder(Odetaljer oDetaljer) throws NewException {

        Ordre order = LogicFacade.getOrdreByOrderId(oDetaljer.getOrdreId());

        StringBuilder sb = new StringBuilder();
        sb.append("<form name=\"InvoiceSetStatus\" action=\"FrontController\" method=\"POST\">");
        sb.append("<input type=\"hidden\" name=\"command\" value=\"InvoiceSetStatus\">");
        sb.append("<table border=1>\n");
        sb.append("<tr><h3>Ordre detaljer</h3></tr>\n");
        sb.append("<tr><th>InvoiceId</th><th>Date</th><th>status</th></tr>\n");
        sb.append("<td>").append("" + oDetaljer.getOrdreId()).append("</td>");
        sb.append("<td>").append("" + order.getReciveddate()).append("</td>");
        sb.append("<td>").append("" + LogicFacade.getOdetaljerByOrderId(oDetaljer.getOrdreId()).getOrdreStatus()).append("</td>");

        sb.append("</table>\n>");
        sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"id\" value=\"" + oDetaljer.getOrdreId() + "\"><br>\n\n</td>");
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
