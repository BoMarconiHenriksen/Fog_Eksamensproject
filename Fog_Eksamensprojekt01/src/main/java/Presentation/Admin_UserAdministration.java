/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.DataFacade;
import Domain.Exception.NewException;
import Domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ticondrus
 */
public class Admin_UserAdministration extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        
        request.setAttribute("userID", user.getUser_id());
        request.setAttribute("userRole", user.getRole());
        request.setAttribute("userEmail", user.getEmail());
        request.setAttribute("userFirstname", user.getFirstname());
        request.setAttribute("userLastname", user.getLastname());
        request.setAttribute("userPostcode", user.getZip());
        request.setAttribute("userAddress", user.getAddress());
        request.setAttribute("userTlfnummer", user.getTlfnummer());
        request.setAttribute("userPassword", user.getPassword());

        String UpdateUser = request.getParameter("Admin_UserAdministration");
        int userNotifyValue = 0;
        request.setAttribute("outprintnotifystatus", userNotifyValue);
        String newEmail = null;

        if (UpdateUser != null && newEmail.contains("@")) {

            String newRole = request.getParameter("uRole");
            newEmail = request.getParameter("uEmail");
            String newFirstname = request.getParameter("uFirstname");
            String newLastName = request.getParameter("uLastname");
            int newPostcode = Integer.parseInt(request.getParameter("uPostcode"));
            String newAddress = request.getParameter("uAddress");
            String newPassword = request.getParameter("uPassword");
            int newTlfnummer = Integer.parseInt(request.getParameter("uTlfnummer"));
            DataFacade.updateWholeUserButID(user.getUser_id(), newPostcode, newEmail, newPassword, newRole, newFirstname, newLastName, newAddress, newTlfnummer);
            
            userNotifyValue = 1;
            request.setAttribute("outprintnotifystatus", userNotifyValue);
            return "employee_usercontrolpage";
            
        } else if (UpdateUser != null) {
            userNotifyValue = 2;
            request.setAttribute("outprintnotifystatus", userNotifyValue);
            return "employee_usercontrolpage";
        } else {

            return "employee_usercontrolpage";

        }
    }
}
