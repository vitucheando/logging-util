package pe.com.vitucheando.logging.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Created by vitucheando on 26/11/2018.
 */
public class LoadProperties {
    static private LoadProperties _instance = null;
    static public Properties props = new Properties();
    public static final int ENVIRONMENT_VARIABLE = 0;
    public static final int PROPERTY_FILE_NAME = 1;
    public static final int APPLICATION_DIRECTORY = 2;

    protected LoadProperties(String name) throws IOException{
        InputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(new File(name)) ;
            props.load(fileInputStream);
        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

        }
    }

    static public LoadProperties instance(String[] params){
        String envVariable = params[ENVIRONMENT_VARIABLE];
        String propertyFileName = params[PROPERTY_FILE_NAME];
        String appDirectory = params[APPLICATION_DIRECTORY];
        String name = (new StringBuilder()).append(envVariable).append(appDirectory).append(File.separator).append(propertyFileName).toString();
        try{
            if (_instance == null) {
                synchronized (LoadProperties.class) {
                    if (_instance == null) {
                        System.out.println("Nueva instancia de: " + name);
                        _instance = new LoadProperties(name);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        return _instance;
    }
}
