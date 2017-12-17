package Presentation.Utillities;

import Business.LogicFacade;
import Business.Exception.NewException;
import Business.Domain.User;
import java.util.List;

/**
 *
 */
public class RendUtilUserList {
    
    public static String invoiceUserList(List<User> userList) throws NewException {
    
        userList = LogicFacade.getUserList();

        StringBuilder sb = new StringBuilder();
        
        sb.append("<br><br> Vælg en kunde som ordren skal bestilles til:"
                + "<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>Kunde ID </th><br><th>Kunde Email   </th><th>Kunde Tlf-Nummer  </th></tr>\n");
        for (User user : userList) {

            sb.append("<td>").append("  " + (user.getUser_id())).append("</td>");
            sb.append("<td>").append("  " + user.getEmail()).append("</td>");
            sb.append("<td>").append("  " + user.getTlfnummer()).append("</td>");
            sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"kunde_id\" value=\"" + user.getUser_id() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");

        return sb.toString();
    }

}
  
