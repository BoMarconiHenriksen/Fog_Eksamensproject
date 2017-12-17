package Presentation;

import Business.LogicFacade;
import Business.Exception.NewException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
public class Admin_UserAdministration extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        int userId = Integer.parseInt(request.getParameter("customerID"));
        String role = request.getParameter("uRole");
        String email = request.getParameter("uEmail");
        String firstname = request.getParameter("uFirstname");
        String lastname = request.getParameter("uLastname");
        int zipcode = Integer.parseInt(request.getParameter("uPostcode"));
        String address = request.getParameter("uAddress");
        int phone = Integer.parseInt(request.getParameter("uTlfnummer"));
        String password = request.getParameter("uPassword");

        LogicFacade.updateWholeUserButID(userId, zipcode, email, password, role, firstname, lastname, address, phone);

        request.setAttribute("userID", userId);
        request.setAttribute("userRole", role);
        request.setAttribute("userEmail", email);
        request.setAttribute("userFirstname", firstname);
        request.setAttribute("userLastname", lastname);
        request.setAttribute("userPostcode", zipcode);
        request.setAttribute("userAddress", address);
        request.setAttribute("userTlfnummer", phone);
        request.setAttribute("userPassword", password);

        return "employeepage";

    }
}
