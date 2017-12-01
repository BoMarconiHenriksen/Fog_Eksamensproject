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

      
        commands.put("ErrorMsg", new ErrorMsg());
        commands.put("basisCarport", new basisCarport());
        commands.put("basisCarportmedSkur", new basisCarportMedSkur());
        commands.put("OrdertheOrder", new Checkout());
        commands.put("XXtegningSimpel", new XXTegningSimpel());
        commands.put("OrdreList", new OrdreList());
        commands.put("OrdreList_Customer", new OrdreList_Customer());
        commands.put("InvoiceDetail", new InvoiceDetail());
        commands.put("InvoiceDetail_Customer", new InvoiceDetail_Customer());
        commands.put("InvoiceDetail_Customer_DeleteOrder", new InvoiceDetail_Customer());
        commands.put("InvoiceSetStatus", new InvoiceSetStatus());
    

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
