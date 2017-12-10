package Presentation;


import Domain.Exception.NewException;
import java.io.IOException;
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

        commands.put("login", new Login());
        commands.put("logout", new LogOut());
        commands.put("register", new Register());
        commands.put("ErrorMsg", new ErrorMsg());
        commands.put("basisCarport", new basisCarport());
        commands.put("OrdertheOrder", new Checkout());
//        commands.put("XXtegningSimpel", new XXTegningSimpel());
        commands.put("OrdreList", new OrdreList());
        commands.put("OrdreList_Customer", new OrdreList_Customer());
        commands.put("OrdreList_Customer_DeleteOrder", new OrdreList_Customer());
        commands.put("InvoiceDetail", new InvoiceDetail());
        commands.put("InvoiceDetail_Customer", new InvoiceDetail_Customer());
        commands.put("InvoiceDetail_Customer_DeleteOrder", new InvoiceDetail_Customer());
        commands.put("InvoiceSetStatus", new InvoiceSetStatus());
        commands.put("InvSetOrderStatusbyCustomer", new InvoiceDetail_Customer());
        commands.put("Customer_UserOptions", new Customer_UserOptions());
        commands.put("Customer_UserOptionsPasswordChange", new Customer_UserOptions());
        commands.put("Employee_UserOptions", new Employee_UserOptions());
        commands.put("Employee_UserOptionsPasswordChange", new Employee_UserOptions());
        commands.put("Employee_OrderCarport", new Employee_OrderCarport());
        commands.put("Employee_OrderCarportPlaceOrder", new Employee_OrderCarport());
        commands.put("Employee_SetupOrderCarportFunctions", new Employee_SetupOrderCarportFunctions());

    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        request.setAttribute("commands", commands);
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new ErrorMsg());
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response) throws NewException, IOException;

}
