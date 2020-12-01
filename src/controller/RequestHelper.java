package controller;

//import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class RequestHelper {
    //public static final Logger logger = Logger.getLogger(RequestHelper.class);

    private static RequestHelper instance = null;

    HashMap<String, Command> commands = new HashMap<String, Command>();

    private RequestHelper() {
        commands.put("newPatient", new AddNewPatient());
        commands.put("authorization", new Authorization());
        commands.put("dischargePatient", new DischargePatient());
        commands.put("setDiagnosis", new SetDiagnos());
        commands.put("giveDrugs", new GiveTablets());
        commands.put("makeOperation", new DoOperation());
        commands.put("makeProcedure", new MakeProcedure());
        commands.put("goToSetDiagnosis", new GoToSetDiagnos());
        commands.put("goToDischarge", new GoToDischargePatient());
        commands.put("goToMainPage", new GoToMainPage());
        commands.put("changeLanguage", new SetLanguage());
        commands.put("exit", new Exit());
    }

    public Command getCommand(HttpServletRequest request) {
        String action = request.getParameter("command");
        Command command = commands.get(action);
    //    logger.debug(command);
        return command;
    }

    public static RequestHelper getInstance() {
        if (instance == null) {
            instance = new RequestHelper();
          //  logger.debug(instance);
        }
        return instance;
    }
}
