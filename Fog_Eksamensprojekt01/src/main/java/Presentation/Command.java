package Presentation;

import Business.Exception.NewException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    /**
     * initCommands: Håntere alle de commands som benytes på alle jsp siderne i
     * et HashMap. De bruges til at tage imod og behandle imput på samme måde
     * som en servlet ellers vil gøre.
     *
     * "login": Benytes på index.jsp til at tage imod brugerens login imput, og
     * logge brugeren ind på den bruger som brugeren har intastet, hvis email og
     * password er korrekt.
     *
     * "logout": Benyttes på customerpage.jsp og employeepage-.jsp, til at
     * afslutte brugerens session, og logge brugeren af hjemmesiden.
     *
     * "register": Benyttes på register.jsp til at tage imod brugerens nye
     * oplysninger, og registrer dem i databasen, hvis de nødvendige oplysninger
     * er udfylt, og indeholder de repektive kategoriers minimumkrav.
     *
     * "ErrorMsg": Henviser brugeren til errorview.jsp, hvis en fejl opstår mens
     * brugeren navigere på siden.
     *
     * "basisCarport": Bruges på customer_order_carport.jsp, når brugeren skal
     * tjekke en pris på en carport, og trykker se pris. Brugeren bliver henvist
     * til samme jsp side igen, men med pris og tegning af den carport som
     * brugeren vil tjekke.
     *
     *
     */
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
        commands.put("InvoiceDetail_Admin_DeleteOrder", new InvoiceDetail());
        commands.put("InvoiceDetail_Admin_UserEdit", new InvoiceDetail());
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
        commands.put("Admin_UserAdministration", new Admin_UserAdministration());
        commands.put("UserList", new UserList());
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
