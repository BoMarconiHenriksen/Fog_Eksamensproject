
package Presentation;

import Business.LogicFacade;
import Business.Exception.NewException;
import Business.Domain.User;
import Presentation.Utillities.RendUtilUserlist_FullDiscription;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 */
public class UserList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException, IOException {

        List<User> userList = LogicFacade.getUserList();
        String employee_Userlist = RendUtilUserlist_FullDiscription.invoiceList(userList);
        request.setAttribute("employee_userlist", employee_Userlist);
        return "employee_user_list";
    }

}
