package Presentation;

import Business.Calculator;
import Utillities.XXRendSvg;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
public class XXTegningSimpel extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        Calculator calc = new Calculator();
        Double totalPris = calc.calculateCarportSimple(480, 300, 225);
        request.setAttribute("totalPris", totalPris);
        
        XXRendSvg svag = new XXRendSvg();
        String carportTegning = svag.simpelCarport(480, 300);
        request.setAttribute("carportTegning", carportTegning);

        return "stykListe";

    }
}
