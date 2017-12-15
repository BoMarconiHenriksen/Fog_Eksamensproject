package Business.Utilities;

import Business.LogicFacade;
import Business.Exception.NewException;
import Business.Domain.User;
import java.util.List;

/**
 *
 * @author Ticondrus
 */
public class RendUtilUserList {
    
    /**
     *
     * @param userList
     * @return
     * @throws NewException
     */
    public static String invoiceUserList(List<User> userList) throws NewException {
    
        userList = LogicFacade.getUserList();

        StringBuilder sb = new StringBuilder();
        
        sb.append("<br><br> Vælg en kunde som ordren skal bestilles til:"
                + "<table>\n"
                + "<tr><th></th><th></th></tr>\n"
                + "<tr><th>Kunde ID </th><br><th>Kunde Email   </th><th>Kunde Tlf-Nummer  </th></tr>\n");
        for (User u : userList) {

         //   sb.append("<tr><form name=\"Employee_OrderCarport\" action=\"FrontController\" method=\"POST\">");
         //   sb.append("<tr> <input type=\"hidden\" name=\"command\" value=\"Employee_OrderCarport\">");
            sb.append("<td>").append("  " + (u.getUser_id())).append("</td>");
            sb.append("<td>").append("  " + u.getEmail()).append("</td>");
            sb.append("<td>").append("  " + u.getTlfnummer()).append("</td>");
            sb.append("<td>\n <input type=\"radio\"checked=\"checked\" name=\"kunde_id\" value=\"" + u.getUser_id() + "\"><br>\n\n</td>");
            sb.append("</tr>\n");
        }
        sb.append("</table>\n");
     //   sb.append("<button type=\"submit\" value=\"action\" name=\"Employee_OrderCarport\">Se Ordre</button> ");
     //   sb.append("</form>\n");
        return sb.toString();
    }

}
  
