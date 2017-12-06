package Utillities;

import Business.LogicFacade;
import Domain.Materiale;
import Domain.Exception.NewException;
import java.util.List;

/**
 * Skal måske bruges 
 *
 * @author Ticondrus
 */
public class RendUtilGetMaterials {
    
    /**
     * Metoden udsrkiver en en linje med oplysninger om et specifikt materiale.
     * @param mats
     * @return sb.toString()
     * @throws NewException 
     */

    public static String getSpecifikMaterial(List<Materiale> mats) throws NewException {

        mats = LogicFacade.getMaterial();
        String mat1 = mats.get(1).getMaterialenavn();
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n"
                + "<tr><th>Stykliste</th><th></th><th></th></tr>\n"
                + "<tr><th>Trætype </th><th>Materiale  </th><th>Type </th><th></th></tr>\n");
        for (Materiale ma : mats) {
            sb.append("<tr><form name=\"invoiceList\" action=\"FrontController\" method=\"POST\">"); //Method kan være skrevet forkert! action=\"InvoiceDetailServlet\" method=POST>
            sb.append("<tr> <input type=\"hidden\" name=\"origin\" value=\"invoice_detail\">");
            sb.append("<td>").append("" + ma.getMaterialetype()).append("</td>");
            sb.append("<td>").append("" + ma.getMaterialenavn()).append("</td>");
            sb.append("<td>").append("" + ma.getEnhed()).append("</td>");
            // sb.append("<td>\n <input type=\"radio\" name=\"id\" value=\"" + ma.getVarenummer() + "\"><br>\n\n</td>"); //location.href='invoice_detail.jsp';\
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        //  sb.append("<button type=\"submit\" value=\"action\" name=\"invoice_detail\">See order</button> ");
        sb.append("</form>\n");
        return sb.toString();

    }
}
