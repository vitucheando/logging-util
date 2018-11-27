package pe.com.vitucheando.logging.dao.impl;

import pe.com.vitucheando.logging.dao.DataBaseDao;
import pe.com.vitucheando.logging.util.Constants;
import pe.com.vitucheando.logging.util.Utilities;

import java.sql.*;
import java.util.logging.Level;
import static pe.com.vitucheando.logging.init.InitParams.cmproperties;


/**
 * Created by vitucheando on 26/11/2018.
 */
public class DataBaseDaoImpl implements DataBaseDao{

    private String hostname, port, user, sid, pwd;
    private Connection connection;
    private Statement stmt;

    public DataBaseDaoImpl(){
        System.out.println("Iniciando constructor");
        hostname = cmproperties.getProperty(Constants.DB_HOSTNAME);
        port = cmproperties.getProperty(Constants.DB_PORT);
        user = cmproperties.getProperty(Constants.DB_USER);
        pwd = cmproperties.getProperty(Constants.DB_PASSWORD);
        sid = cmproperties.getProperty(Constants.DB_SID);
    }

    @Override
    public void loggingToDataBase(String message, Level level) throws Exception{
        String retorno="";
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.println(Utilities.idApp + " - " + "Cargo el driver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@" + hostname + ":" + port + ":" + sid, user, pwd);
        System.out.println(Utilities.idApp + " - " + "Conexion a BD  " + sid + " establecida");
        String sql = "INSERT INTO ORDERS.NP_LOG(LOG_DATE, LOG_LOG) VALUES (SYSDATE, '[" + level.toString() + "] - " +  message  + "')";
        System.out.println(Utilities.idApp + " - " + "EL INSERT: " + sql);
        try{
            stmt = connection.createStatement();
            stmt.executeUpdate(sql);
        } catch (Exception e){
            throw e;
        } finally {
            try { stmt.close(); } catch (Exception e) { /* ignored */ }
            try { connection.close(); } catch (Exception e) { /* ignored */ }
        }
    }

}
