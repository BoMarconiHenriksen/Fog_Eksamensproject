package Presentation;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *
 * @author BenedikteEva
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();

        commands.put("getAllLineItem", new GetAllLineItem() {});
        commands.put("ErrorMsg", new ErrorMsg());
        commands.put("basisCarport", new basisCarport());
        commands.put("checkOutCarport", new basisCarport());
        commands.put("basisCarportmedSkur", new basisCarportMedSkur());
        commands.put("checkoutFunktion", new Checkout());
        commands.put("tegningSimpel", new XXTegningSimpel());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        request.setAttribute("commands", commands);
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new ErrorMsg());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response) throws NewException;

}
