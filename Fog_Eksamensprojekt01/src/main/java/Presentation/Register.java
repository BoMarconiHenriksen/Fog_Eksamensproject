package Presentation;

import Business.LogicFacade;
import Domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws NewException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        String firstname = request.getParameter( "firstname" );
        String lastname = request.getParameter( "lastname" );
        String address = request.getParameter( "addresse" );
        int zipcode = Integer.parseInt(request.getParameter("postnummer"));
        int tlfnummer = Integer.parseInt(request.getParameter("telefonnummer"));
        if ( password.equals( password2 ) ) {
            User user = LogicFacade.createUser(email, password, firstname, lastname, address, zipcode, tlfnummer);
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new NewException( "De to passwords matcher ikke hinanden." );
        }
    }

}
