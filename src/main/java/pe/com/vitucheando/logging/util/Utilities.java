package pe.com.vitucheando.logging.util;

import pe.com.vitucheando.logging.command.Commands;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

/**
 * Created by vitucheando on 26/11/2018.
 */
public class Utilities {
    public static UUID idApp = UUID.randomUUID();

    public static String handlerStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }

    public static Date convertToDateTime(String fecha) {
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return df.parse(fecha);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Date convertToDate(String fecha){
        try{
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            return df.parse(fecha);
        } catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public static String buildCommandline(String[] args) {
        StringBuilder commandline = new StringBuilder();

        String[] arrayOfString = args;
        int j = args.length;
        for (int i = 0; i < j; i++) {
            String text = arrayOfString[i];
            commandline.append(text).append(" ");
        }
        return commandline.toString().trim();
    }

    public static Commands validateCommandLine(String commandline) {
        for (Commands cmd : Commands.values()) {
            if (cmd.validateCommandLine(commandline)) {
                return cmd;
            }
        }
        return Commands.UNKNOWN;
    }

    public static String convertDateToStringByPattern(String fecha, String pattern){
        DateFormat formatoFecha = new SimpleDateFormat(pattern);
        if ("yyyyMMddHHmmss".equalsIgnoreCase(pattern)) {
            return formatoFecha.format(convertToDateTime(fecha)).toString();
        } else {
            return formatoFecha.format(new Date()).toString();
        }
    }

    public static boolean validateParamsLog(Properties cmproperties){
        if(!cmproperties.getProperty("logging.level").isEmpty() || !("".equalsIgnoreCase(cmproperties.getProperty("logging.level")))){
            if(!cmproperties.getProperty("logging.to").isEmpty() && !("".equalsIgnoreCase(cmproperties.getProperty("logging.to")))){
                if("FILE".equalsIgnoreCase(cmproperties.getProperty("logging.to"))) {
                    if (!cmproperties.getProperty("logging.path.file").isEmpty() && !("".equalsIgnoreCase(cmproperties.getProperty("logging.path.file")))) {
                        return true;
                    }
                } else if("DATABASE".equalsIgnoreCase(cmproperties.getProperty("logging.to"))) {
                    if (!cmproperties.getProperty("logging.db.hostname").isEmpty() && !("".equalsIgnoreCase(cmproperties.getProperty("logging.db.hostname")))) {
                        if (!cmproperties.getProperty("logging.db.port").isEmpty() && !("".equalsIgnoreCase(cmproperties.getProperty("logging.db.port")))) {
                            if (!cmproperties.getProperty("logging.db.user").isEmpty() && !("".equalsIgnoreCase(cmproperties.getProperty("logging.db.user")))) {
                                if (!cmproperties.getProperty("logging.db.password").isEmpty() && !("".equalsIgnoreCase(cmproperties.getProperty("logging.db.password")))) {
                                    if (!cmproperties.getProperty("logging.db.password").isEmpty() && !("".equalsIgnoreCase(cmproperties.getProperty("logging.db.password")))) {
                                        return true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
