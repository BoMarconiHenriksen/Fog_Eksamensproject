package Presentation;

import Business.Exception.NewException;
import Business.ConfigurationException.Configuration;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Denne class er Frontcontrolleren.
 * Den håntere alle request fra userinterfacet og response fra det underliggende system ved hjælp af alle de commands -
 * der ligger i Presentation mappen.
 *
 */
@WebServlet(name = "FrontController", urlPatterns = {"/FrontController"})
public class FrontController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws Business.Exception.NewException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NewException {

        Configuration.myLogger.addHandler(new ConsoleHandler());
        if (Configuration.PRODUCTION==true) {
            FileHandler fileHandler = new FileHandler(Configuration.LOGFILEPATH);
            fileHandler.setFormatter(new SimpleFormatter());
            Configuration.myLogger.addHandler(fileHandler);
        }
        try (PrintWriter out = response.getWriter()) {

            try {
                Command action = Command.from(request);
                String view = action.execute(request, response);
                request.setAttribute("view", view);
                request.getRequestDispatcher(view + ".jsp").forward(request, response);

            } catch (NewException ex) {
                Configuration.myLogger.log(Level.SEVERE, ex.getMessage(), ex);
                request.setAttribute("error", ex.getMessage()); //Bruges til at skrive en meddelse ud ved fejl login
                request.getRequestDispatcher("errorview.jsp").forward(request, response);

            }
        }

    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (NewException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (NewException ex) {
            Logger.getLogger(FrontController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
