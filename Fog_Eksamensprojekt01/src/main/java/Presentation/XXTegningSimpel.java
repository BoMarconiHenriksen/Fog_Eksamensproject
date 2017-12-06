package Presentation;

import Domain.Exception.NewException;
import Business.Calculator;
import Utillities.XXRendSvg;
import Utillities.XXRendUtilStykListe;
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
       StringBuilder sb =new StringBuilder();
      
        String styk = XXRendUtilStykListe.createLineItemList(sb,480, 300,450,150);
        request.setAttribute("styk", styk);
        
        XXRendSvg svag = new XXRendSvg();
        String carportTegning = svag.simpelCarport(480, 300, 210,150);
        request.setAttribute("carportTegning", carportTegning);

        return "XXstykListe";

    }
}
