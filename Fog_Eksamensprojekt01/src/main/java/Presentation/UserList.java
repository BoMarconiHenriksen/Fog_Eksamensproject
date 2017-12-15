/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.LogicFacade;
import Business.Exception.NewException;
import Business.Domain.User;
import Business.Utilities.RendUtilUserlist_FullDiscription;
import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ejer
 */
public class UserList extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException, IOException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<User> userList = LogicFacade.getUserList();
        String employee_Userlist = RendUtilUserlist_FullDiscription.invoiceList(userList);
        request.setAttribute("employee_userlist", employee_Userlist);
        return "employee_user_list";
    }

}
