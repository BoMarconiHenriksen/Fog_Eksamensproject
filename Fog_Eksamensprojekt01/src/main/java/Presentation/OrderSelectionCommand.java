/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ticondrus
 */
public class OrderSelectionCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {


        String command = request.getParameter("command");
        String orderSelectionSimpleCarport = request.getParameter("orderSelectionSimpleCarport");
        String orderSelectionSimpleCarportmedSkur = request.getParameter("orderSelectionSimpleCarportmedSkur");

        if (orderSelectionSimpleCarport != null)
        return "bestilbasiscarportpage";
        
        if (orderSelectionSimpleCarportmedSkur != null)
            return "basiscarportmedskurpage";
        else
            return "index";
    }
}
