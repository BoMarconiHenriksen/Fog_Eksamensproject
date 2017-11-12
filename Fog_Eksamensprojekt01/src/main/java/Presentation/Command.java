package Presentation;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The purpose of Command is to...
 *
 * @author kasper
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();

        commands.put("getAllMaterials", new GetAllMaterials());
        commands.put("getAllStykLinje", new GetAllStykLinje());
        commands.put("ErrorMsg", new ErrorMsg());
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
