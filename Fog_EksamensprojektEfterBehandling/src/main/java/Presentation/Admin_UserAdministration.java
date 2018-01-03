package Presentation;

import Business.DataFacade;
import Business.Domain.User;
import Business.LogicFacade;
import Business.Exception.NewException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Denne class er en af commands'ne. Commanden returner til employeepage.jsp og
 * får implementeret brugerens opdaterede oplysninger i databasen.
 */
public class Admin_UserAdministration extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        String changeOfUserDataSucces = null ;
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

        if(request.getParameter("Admin_UserAdministration") != null) {
    
            changeOfUserDataSucces = "Du har ændret brugeroplysningerne for bruger nummer: "+userId;
        }
        
        //Bliver vist for brugeren på jsp siden efter oplysningerne er ændret
        User customer=DataFacade.getUserByUserId(userId);
        request.setAttribute("customerID", customer.getUser_id());
        request.setAttribute("userRole", customer.getRole());
        request.setAttribute("userEmail", customer.getEmail());
        request.setAttribute("userFirstname", customer.getFirstname());
        request.setAttribute("userLastname", customer.getLastname());
        request.setAttribute("userPostcode", customer.getZip());
        request.setAttribute("userAddress",customer.getAddress());
        request.setAttribute("userTlfnummer",customer.getTlfnummer());
        request.setAttribute("userPassword", customer.getPassword());
        request.setAttribute("changeOfUserDataSucces", changeOfUserDataSucces);
        
        return "employee_usercontrolpage";

    }
}
