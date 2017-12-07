/*
 * BenedikteEva
 * Lego Houses
 */
package Presentation;

import Domain.Exception.NewException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ejer
 */
public class LogOut extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            request.getRequestDispatcher("index.jsp").include(request, response);
            

            HttpSession session = request.getSession();
            session.invalidate();

            out.print("Du er nu logged af brugeren.");
            out.close();

        } catch (ServletException | IOException ex) {
            Logger.getLogger(LogOut.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index";
    }
}
