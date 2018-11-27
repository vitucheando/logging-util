package logger;

import org.junit.Test;
import pe.com.vitucheando.logging.main.JobLogger;


/**
 * Created by vitucheando on 26/11/2018.
 */
public class Test1 {

    @Test
    public void test01() throws Exception {
        try {
            JobLogger jobLogger = new JobLogger();
            jobLogger.logger("Probando la inserción en la consola");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
