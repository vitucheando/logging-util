package pe.com.vitucheando.logging.init;

import java.io.InputStream;
import java.util.logging.LogManager;
import pe.com.vitucheando.logging.util.Constants;
import pe.com.vitucheando.logging.util.LoadProperties;
import pe.com.vitucheando.logging.util.Utilities;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by vitucheando on 26/11/2018.
 */
public class InitParams {

    public static Properties cmproperties;

    public void init()  {
        try{
            getLogProps();
        } catch (IOException e) {
            System.out.println("No se pudo cargar el properties");
        }
    }

    public void getLogProps() throws IOException {
        LoadProperties singleton = LoadProperties.instance(new String[]{
                Constants.PATH_DEFAULT_PROPERTIES,
                Constants.INIT_PROPERTIES,
                Constants.APP_CONFIG_PATH
        });
        cmproperties = singleton.props;
    }
}
