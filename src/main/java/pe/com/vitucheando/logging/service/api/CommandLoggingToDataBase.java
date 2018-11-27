package pe.com.vitucheando.logging.service.api;

import pe.com.vitucheando.logging.dao.DataBaseDao;
import pe.com.vitucheando.logging.dao.impl.DataBaseDaoImpl;
import pe.com.vitucheando.logging.util.Utilities;

import java.util.logging.Level;

/**
 * Created by vitucheando on 26/11/2018.
 */
public class CommandLoggingToDataBase {

    private DataBaseDao dataBaseDao;

    public CommandLoggingToDataBase(){
        dataBaseDao = new DataBaseDaoImpl();
    }

    public void loggingToDataBase(String message, Level level) throws Exception{
        dataBaseDao.loggingToDataBase(message, level);
    }
}
