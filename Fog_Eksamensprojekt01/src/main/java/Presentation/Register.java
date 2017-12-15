package Presentation;

import Business.LogicFacade;
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
        String role = "customer";
        int zipcode = Integer.parseInt(request.getParameter("postnummer"));
        int tlfnummer = Integer.parseInt(request.getParameter("telefonnummer"));
        User user =  new User (email, password,  role,firstname, lastname, address, zipcode, tlfnummer);
        if (password.equals(passwordRetype)) {
            try {
                int succes= 1;
                request.setAttribute("succes", succes);
                LogicFacade.createUser(email, password, role,firstname, lastname, address, zipcode, tlfnummer);
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                session.setAttribute("username", user.getFirstname());
                request.setAttribute("pleaselogin", "Registrering var en succes. De kan nu logge ind");
                return "index";
            } catch (Domain.Exception.NewException ex) {
                Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
           return "index";
        }
        return "index";
      

}}
