package Presentation;

import Business.Exception.NewException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Denne class er en af commands'ne.
 * Benyttes på customerpage.jsp og employeepage-.jsp, til at afslutte brugerens
 * session, og logge brugeren af hjemmesiden.
 *
 */
public class LogOut extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

        try {
            request.getRequestDispatcher("index.jsp").include(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(LogOut.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "index";

    }
}
