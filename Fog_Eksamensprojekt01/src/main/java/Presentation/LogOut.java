/*
 * BenedikteEva
 * Lego Houses
 */
package Presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ejer
 */
public class LogOut extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return "index";

    }

}
