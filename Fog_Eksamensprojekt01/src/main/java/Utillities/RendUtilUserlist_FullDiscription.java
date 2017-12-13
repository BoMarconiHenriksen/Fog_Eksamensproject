/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utillities;

import Business.LogicFacade;
import Domain.Exception.NewException;
import Domain.User;
import java.util.List;

/**
 *
 * @author Ticondrus
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
        for (User u : userList) {

            sb.append("<tr><form name=\"InvoiceDetail_Admin_UserEdit\" action=\"FrontController\" method=\"POST\">");
            sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"InvoiceDetail_Admin_UserEdit\">");
            sb.append("<td>").append("  " + (u.getUser_id())).append("</td>");
            sb.append("<td>").append("  " + u.getRole()).append("</td>");
            sb.append("<td>").append("  " + u.getEmail()).append("</td>");
            sb.append("<td>").append("  " + u.getFirstname()).append("</td>");
            sb.append("<td>").append("  " + u.getLastname()).append("</td>");
            sb.append("<td>").append("  " + u.getZip()).append("</td>");
            sb.append("<td>").append("  " + u.getAddress()).append("</td>");
            sb.append("<td>").append("  " + u.getTlfnummer()).append("</td>");
            sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"theUser_id\" value=\"" + u.getUser_id() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
        sb.append("<button type=\"submit\" value=\"action\" name=\"InvoiceDetail_Admin_UserEdit\">Ret Bruger</button> ");
        sb.append("</form>\n");
        return sb.toString();
    }
}

