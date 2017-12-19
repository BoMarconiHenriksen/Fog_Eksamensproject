package Presentation;

import Business.Exception.NewException;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Håndterer alle de commands som benytes på alle jsp siderne i et HashMap.
 * De bruges til at tage imod og behandle input på samme måde som en servlet ellers vil gøre.
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    /**
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
     *
     * "basisCarport": Bruges på customer_order_carport.jsp, når brugeren skal
     * tjekke en pris på en carport, og trykker se pris. Brugeren bliver henvist
     * til samme jsp side igen, men med pris og tegning af den carport som
     * brugeren vil tjekke. Den bruges også når kunden skal gemme eller bestile en carport.
     * I det tilfælde bliver de oplysninger som kunden har intastet behanldet lige som når man skal se en pris,
     * men samtidigt sættes nogle af oplysningerne også ned i databasen. og afhængig af om kunden vælger at gemme eller bestile,
     * så bliver vedkommende navigeret enten til customerpage.jsp igen eller til customer_shopping_cart.jsp.
     * 
     * "OrdertheOrder": Bruges på customer_shopping_cart.jsp, hvor kunden skal bekræfte om ordren skal bestiles. Når kunden trykker "Bestil ordren of afvent svar snarest",
     * så ændres ordre statusen på kunden sordre til "Ny ordre".
     *
     * "OrdreList": Bruges på på employeepage.jsp, til at navigere medarbejderen til employee_ordre_list.jsp og få fremvist alle kundernes ordre.
     * 
     * "OrdreList_Customer: Bruges på customerpage.jsp til at navigere kunden til customer_ordre_list.jsp og få fremvist en liste af alle kundens ordre.
     * 
     * "InvoiceDetail": Bruges på employee_order_list til at navigere medarbejderen over på employee_invoice_detail.jsp og fremvise pris, tegning og stykliste på den valgte ordre samt -
     * tage imod en ny status og implementere den på ordren nede i databasen
     * Den bruges også til at navigere medarbejderen tilbage til employee_ordre_list.jsp og fremvise listen af alle kundernes ordre igen samt -
     * at slette en ordre på employee_ordre_list.jsp.
     * 
     * "InvoiceDetail_Customer": Bruges på customer__order_list.jsp til navigere kunden over på customer_invoice_detail.jsp og fremvise pris, tegning og evt. stykliste hvis ordren er bestilt.
     * Den bruges også på customer_ordre_list.jsp til at slette en ordre og fremvise listen igen ud fra hvad der ligger i databasen.
     * Og endeligt bruges den også på customer_invoice_detail.jsp til at ændre statusen på en gemt ordre til "Ny Ordre", hvis den fremviste ordre er gemt -
     * eller mangler kundens bekræftigelse.
     * 
     * "InvoiceSetStatus": Bruges på emplyee_invoice_detail.jsp til at ændre statusen på en ordre nede i databasen og fremvise ordren igen på samme jsp side med den ændrede status.
     * 
     * "Customer_UserOptions": Bruges på customerpage.jsp til at navigere kunden hen til customer_useroptions.jsp og fremvise alle kunden s oplysninger samt tage imod og -
     * ændre kundens password hvis kunden vælger et nyt password på siden.
     * 
     * "Employee_OrderCarport": Bruges på employee_ordercarportpage.jsp til at tage imod en carport bestiling for en bestemt kunde og lægge ordren i databasen samt -
     *  navigere medarbejderen hen til employee_orderconfirmationpage.jsp
     * 
     * "Employee_SetupCarportFunctions": Bruges på employeepage.jsp til at navigere medarbejderen hen til employee_order_carport.jsp og fremvise en liste af de kunder som er oprettet, -
     * så medarbejderen kan vælge en kunde at bestile en ordre til.
     * 
     * "Admin_UserAdministration": Bruges på employee_usercontrolpage.jsp til at update den valgte brugeres nye oplysninger i databasen og fremvise dem på samme side igen.
     * 
     * "UserList": Bruges på employeepage.jsp til at navigere medarbejderen til employee_user_list.jsp og fremvise en detaljeret liste af alle brugere.
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
        commands.put("OrdreList", new OrdreList());
        commands.put("OrdreList_Customer", new OrdreList_Customer());
     //   commands.put("OrdreList_Customer_DeleteOrder", new OrdreList_Customer());
        commands.put("InvoiceDetail", new InvoiceDetail());
     //   commands.put("InvoiceDetail_Admin_DeleteOrder", new InvoiceDetail());
     //   commands.put("InvoiceDetail_Admin_UserEdit", new InvoiceDetail());
        commands.put("InvoiceDetail_Customer", new InvoiceDetail_Customer());
     //   commands.put("InvoiceDetail_Customer_DeleteOrder", new InvoiceDetail_Customer());
        commands.put("InvoiceSetStatus", new InvoiceSetStatus());
     //   commands.put("InvSetOrderStatusbyCustomer", new InvoiceDetail_Customer());
        commands.put("Customer_UserOptions", new Customer_UserOptions());
     //   commands.put("Customer_UserOptionsPasswordChange", new Customer_UserOptions());
        commands.put("Employee_OrderCarport", new Employee_OrderCarport());
     //   commands.put("Employee_OrderCarportPlaceOrder", new Employee_OrderCarport());
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
