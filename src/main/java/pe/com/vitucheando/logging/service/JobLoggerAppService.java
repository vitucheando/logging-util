package pe.com.vitucheando.logging.service;

import pe.com.vitucheando.logging.service.api.CommandLoggingToConsole;
import pe.com.vitucheando.logging.service.api.CommandLoggingToFile;
import pe.com.vitucheando.logging.service.api.CommandLoggingToDataBase;

import pe.com.vitucheando.logging.util.Utilities;

import java.util.logging.Level;

/**
 * Created by vitucheando on 08/02/2017.
 */
public class JobLoggerAppService {
    
    public void loggingToFile(String message, Level level) {
        try {
            CommandLoggingToFile commandLogginToFile = new CommandLoggingToFile();
            commandLogginToFile.logginToFile(message, level);
        }catch (Exception e) {
            System.out.println(Utilities.idApp + " - Error: " + Utilities.handlerStackTrace(e));
            e.printStackTrace();
        }
    }

    public void loggingToConsole(String message, Level level) {
        try {
            CommandLoggingToConsole commandLoggingToConsole = new CommandLoggingToConsole();
            commandLoggingToConsole.loggingToConsole(message, level);
        }catch (Exception e) {
            System.out.println(Utilities.idApp + " - Error: " + e);
            e.printStackTrace();
        }
    }

    public void loggingToDataBase(String message, Level level) {
        try {
            CommandLoggingToDataBase commandLoggingToDataBase = new CommandLoggingToDataBase();
            commandLoggingToDataBase.loggingToDataBase(message, level);
        }catch (Exception e) {
            System.out.println(Utilities.idApp + " - Error: " + e);
            e.printStackTrace();
        }
    }

}
