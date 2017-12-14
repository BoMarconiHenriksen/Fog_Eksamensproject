package Utillities;

import Domain.Exception.NewException;
import Business.LogicFacade;
import Domain.Odetaljer;
import Domain.Ordre;


/**
 * Klassen bruges til at lave en tabel over kundens ordrer og odredetaljer. 
 * 
 */
public class RendUtilCustomerOdetailsFunktions {
    
    
     /**
     * metoden returnerer en tabel over kundens ordrer og odredetaljer. 
     * @param od de ordredetaljer der hentes når kunden vælger en ordre
     * @param o er et eksemplar af de order brugeren skal se
     * @param sb den stringbuilder der skal bruges til lave den string der skal 
     * rendere tabellen på jsp-siden hvor den skal bruges.
     * @return 
     * @throws NewException 
     */
    
    public static String odetailsForOrder_Customer(Odetaljer od) throws NewException {

        Ordre o = LogicFacade.getOrdreByOrderId(od.getOrdreId());
        StringBuilder sb = new StringBuilder();
        
   
        if (od.getOrdreStatus().equalsIgnoreCase("Gemt Design")){
        
        sb.append("<form name=\"Checkout\" action=\"FrontController\" method=\"POST\">\n" );
        sb.append(" <input type=\"hidden\" name=\"command\" value=\"OrdertheOrder\">");
        sb.append("<table border=1>\n");
        sb.append("<tr><h3>Ordre detaljer</h3></tr>\n");
        sb.append("<tr><th>Ordre Id</th><th>Dato</th><th>Status</th></tr>\n");
        sb.append("<td>").append("").append(od.getOrdreId()).append("</td>");
        sb.append("<td>").append("").append(o.getReciveddate()).append("</td>");
        sb.append("<td>").append("").append(LogicFacade.getOrderByOrderId2(od.getOrdreId()).getOrdreStatus()).append("</td>");
        sb.append("</table>\n>");
        sb.append("<input type=\"radio\"checked=\"checked\" name=\"id\" value=\"").append(od.getOrdreId()).append("\"><br>\n");
        sb.append("<button type=\"submit\" value=\"OrdertheOrder\" name=\"Checkout\">Bestil</button> ");
        sb.append("</form>\n");

       
    } else{ sb.append("<tr><h3>Ordren er bestilt, og du kan derfor ikke ændre dens status mere. Kontakt os hvis du har spørgsmål.</h3></tr>\n");
            }
    
    return sb.toString();
}
}
