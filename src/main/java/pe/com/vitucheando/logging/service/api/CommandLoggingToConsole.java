package pe.com.vitucheando.logging.service.api;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by vitucheando on 26/11/2018.
 */
public class CommandLoggingToConsole {
    private static Logger logger;

    public void loggingToConsole(String message, Level level){
        System.out.println("Inicio Logging To Console: ");
        logger = Logger.getLogger("MyLog");
        ConsoleHandler ch = new ConsoleHandler();
        logger.addHandler(ch);
        logger.log(level, message);
    }
}
