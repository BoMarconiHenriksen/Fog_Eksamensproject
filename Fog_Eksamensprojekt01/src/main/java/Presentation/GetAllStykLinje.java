/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Business.LogicFacade;
import Domain.LineItem;
import Domain.StykLinje;
import Utillities.RendUtilStykListe;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author BenedikteEva
 */
public class GetAllStykLinje extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

      

        return "basiscarportmedskurpage";
    }

}
