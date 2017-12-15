/*
 * BenedikteEva
 */
package Presentation;

import Domain.Exception.NewException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ejer
 */
public class ErrorMsg extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {
       String Msg= "Noget gik galt. Venligst log ind igen";
        throw new NewException(Msg);
    }
    
}
