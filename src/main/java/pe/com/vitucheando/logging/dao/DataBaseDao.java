package pe.com.vitucheando.logging.dao;


import java.util.logging.Level;

/**
 * Created by vitucheando on 08/02/2017.
 */
public interface DataBaseDao {
    void loggingToDataBase(String message, Level level) throws Exception;
}
