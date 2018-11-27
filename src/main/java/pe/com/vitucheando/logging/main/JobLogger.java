package pe.com.vitucheando.logging.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;

import pe.com.vitucheando.logging.command.Commands;
import pe.com.vitucheando.logging.init.InitParams;
import pe.com.vitucheando.logging.service.JobLoggerAppService;
import pe.com.vitucheando.logging.util.Constants;
import pe.com.vitucheando.logging.util.Utilities;
import pe.com.vitucheando.logging.util.ValidTypeLog;

import static pe.com.vitucheando.logging.init.InitParams.cmproperties;

/**
 * Created by vitucheando on 07/02/2017.
 */
public class JobLogger {

    static final String COMANDO = "loggingTo";

    private JobLoggerAppService service = null;

    public JobLogger(){
        InitParams init = new InitParams();
        init.init();
    }

    public void logger(String message) throws SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        Method method = null;
        String commandline = COMANDO + cmproperties.getProperty(Constants.LOG_TARGET);

        Commands command = Utilities.validateCommandLine(commandline);

        if (command == Commands.UNKNOWN) {
            System.out.println(Utilities.idApp + " - " + "Comando no permitido.");
            System.exit(0);
        }

        JobLogger appStubMain = new JobLogger();

        System.out.println(Utilities.idApp + " - " + "Running App...");
        for(String methodName : command.getMethods()){
            method = appStubMain.getClass().getMethod(methodName, new Class[] {String.class, Level.class});
            method.setAccessible(true);
            method.invoke(appStubMain, message, ValidTypeLog.valueOf(cmproperties.getProperty(Constants.LOG_LEVEL)).getLevel());
        }
        System.out.println(Utilities.idApp + " - " + "End App");
    }

    public void loggingToConsole(String message, Level level){
        this.service = new JobLoggerAppService();
        this.service.loggingToConsole(message, level);
    }

    public void loggingToFile(String message, Level level){
        this.service = new JobLoggerAppService();
        this.service.loggingToFile(message, level);
    }

    public void loggingToDatabase(String message, Level level){
        this.service = new JobLoggerAppService();
        this.service.loggingToDataBase(message, level);
    }

}
