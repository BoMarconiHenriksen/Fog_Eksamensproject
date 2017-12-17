package Presentation.Utillities;

import Business.LogicFacade;
import Business.Exception.NewException;
import Business.Domain.User;
import java.util.List;

/**
 *
 */
public class RendUtilUserlist_FullDiscription {
    
    
    public static String invoiceList(List<User> userList) throws NewException {
    
        userList = LogicFacade.getUserList();

        StringBuilder sb = new StringBuilder();
        
        sb.append("<br><br> Vælg en bruger at ændre:"
                + "<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>Bruger ID </th><br><th>Bruger Type   </th> <th> Email Addresse  </th> <th>  Fornavn </th> <th> Efternavn  </th> <th> Postnummer  </th>"
                + " <th> Addresse  </th> <th> Tlf Nummer  </th></tr>\n");
        for (User user : userList) {

            sb.append("<tr><form name=\"InvoiceDetail\" action=\"FrontController\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail_Admin_UserEdit\">");
            sb.append("<td>").append("  " + (user.getUser_id())).append("</td>");
            sb.append("<td>").append("  " + user.getRole()).append("</td>");
            sb.append("<td>").append("  " + user.getEmail()).append("</td>");
            sb.append("<td>").append("  " + user.getFirstname()).append("</td>");
            sb.append("<td>").append("  " + user.getLastname()).append("</td>");
            sb.append("<td>").append("  " + user.getZip()).append("</td>");
            sb.append("<td>").append("  " + user.getAddress()).append("</td>");
            sb.append("<td>").append("  " + user.getTlfnummer()).append("</td>");
             sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"theUser_id\" value=\"").append(user.getUser_id()).append("\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"InvoiceDetail_Admin_UserEdit\">Ret Bruger</button> ");
        sb.append("</form>\n");
        return sb.toString();
    }
}

