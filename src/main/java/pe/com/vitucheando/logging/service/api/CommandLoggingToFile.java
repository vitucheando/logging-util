package pe.com.vitucheando.logging.service.api;

import pe.com.vitucheando.logging.util.Utilities;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static pe.com.vitucheando.logging.init.InitParams.cmproperties;

/**
 * Created by vitucheando on 26/11/2018.
 */
public class CommandLoggingToFile {
    private final static Logger LOGGER = Logger.getLogger("MyLog");
    public void logginToFile(String message, Level level) throws Exception {
        System.out.println(Utilities.idApp + " - " + "Inicio Logging To File: " + message);
        String logFileName = cmproperties.getProperty("logging.path.file");
        System.out.println(Utilities.idApp + " - " + "File: " + logFileName);
        File logFile = new File(logFileName);
        if (!logFile.exists()) {
            System.out.println(Utilities.idApp + " - " + "El archivo no existe será creado");
            logFile.createNewFile();
        }
        FileHandler fh = new FileHandler(logFileName);
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        System.out.println(Utilities.idApp + " - " + "Se formatea para que se escriba como texto plano");
        fh.setFormatter(simpleFormatter);
        LOGGER.addHandler(fh);
        LOGGER.log(level, message);
    }
}
