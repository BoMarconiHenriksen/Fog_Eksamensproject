package Presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ticondrus
 */
public class OrderSelectionCommand extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws NewException {

        String orderSelectionSimpleCarport = request.getParameter("orderSelectionSimpleCarport");
        String orderSelectionSimpleCarportmedSkur = request.getParameter("orderSelectionSimpleCarportmedSkur");

        if (orderSelectionSimpleCarport != null) {
            return "bestilbasiscarportpage";
        }

        if (orderSelectionSimpleCarportmedSkur != null) {

            return "basiscarportmedskurpage";
        } else {
            return "index";
        }
    }
}
