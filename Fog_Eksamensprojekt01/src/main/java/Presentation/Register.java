package Presentation;

import Business.LogicFacade;
import Domain.Exception.NewException;
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
        String password = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("addresse");
        int zipcode = Integer.parseInt(request.getParameter("postnummer"));
        int tlfnummer = Integer.parseInt(request.getParameter("telefonnummer"));
        if (password.equals(password2)) {
            try {
                User user = LogicFacade.createUser(email, password, firstname, lastname, address, zipcode, tlfnummer);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                session.setAttribute("username", user.getFirstname());
                return user.getRole() + "page";
            } catch (Domain.Exception.NewException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
//            try {
//                throw new NewException( "De to passwords matcher ikke hinanden." );
//            } catch (NewException ex) {
//                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
//            }
        }
        return "index";
    }

}
