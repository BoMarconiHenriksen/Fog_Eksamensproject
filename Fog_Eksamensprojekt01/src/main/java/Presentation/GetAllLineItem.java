package Presentation;

import Business.Calculator;
import Business.LogicFacade;
import Domain.LineItem;
import Domain.Materiale;
import Domain.StykLinje;
import Utillities.XXRendSvg;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
abstract class GetAllLineItem extends Command {
    //Skal muligvis slettes!!!
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        Calculator calc = new Calculator();
        List<StykLinje> stykLinjeListe = LogicFacade.getStykLinje();

        request.setAttribute("stykLinjeListe", stykLinjeListe);

        List<Materiale> mats = LogicFacade.getMaterial();
        String mat1 = mats.get(1).getMaterialenavn();

        double length = Integer.parseInt(request.getParameter("length"));
        int width = Integer.parseInt(request.getParameter("width"));
        int height = Integer.parseInt(request.getParameter("height"));
        
        double carportTotal = calc.calculateCarportSimple(length, width, height);
        
        request.setAttribute("mats", mats);
        request.setAttribute("mat1", mat1);
        request.setAttribute("carportTotal", carportTotal);
        
        XXRendSvg svag = new XXRendSvg();
        String carportTegning = svag.simpelCarport(480, 300);
        request.setAttribute("carportTegning", carportTegning);

        return "stykListe";

    }

}
