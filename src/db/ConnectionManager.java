package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

/**
 *
 * @author lenovo
 */
public class ConnectionManager {
    static final Logger LOGGER = Logger.getLogger(ConnectionManager.class);
    
    private static final String URL = "jdbc:mysql://localhost:3306/carcare";    
    private static final String USERNAME = "root";   
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        Connection con = null;
        try{
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);            
        }catch (SQLException ex) {
            LOGGER.fatal("Failed to create the database connection. "+ ex.getMessage()); 
        }
        return con;
    }
}
