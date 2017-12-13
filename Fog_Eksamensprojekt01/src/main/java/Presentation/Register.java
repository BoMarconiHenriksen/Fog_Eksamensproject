package Presentation;

import Business.DataFacade;
import Domain.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordRetype = request.getParameter("passwordRetype");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("addresse");
        int zipcode = Integer.parseInt(request.getParameter("postnummer"));
        int tlfnummer = Integer.parseInt(request.getParameter("telefonnummer"));
        if (password.equals(passwordRetype)) {
            try {
                User user = DataFacade.createUser(email, password, firstname, lastname, address, zipcode, tlfnummer);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                session.setAttribute("username", user.getFirstname());
                return user.getRole() + "page";
            } catch (Domain.Exception.NewException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
           return "index";
        }
        return "register";
    }

}
