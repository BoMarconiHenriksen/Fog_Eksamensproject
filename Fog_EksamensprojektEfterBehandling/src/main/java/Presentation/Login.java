package Presentation;

import Business.Exception.NewException;
import Business.LogicFacade;
import Business.Domain.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Denne class er en af commands'ne.
 * Benytes på index.jsp til at tage imod brugerens login imput, og logge
 * brugeren ind på den bruger som brugeren har intastet, hvis email og password
 * er korrekt.
 *
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        session.setAttribute("username", user.getFirstname());
        session.setAttribute("userid", user.getUser_id());
        return user.getRole() + "page";
    }
}
