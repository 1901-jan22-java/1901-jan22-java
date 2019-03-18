package reimbursement.connection.factory;

import java.sql.Connection;
import java.sql.SQLException;
import reimbursement.connection.factory.OracleConnUtils;
 
public class ConnectionUtils {
 
    public static Connection getConnection() 
              throws ClassNotFoundException, SQLException {
 
  
        return OracleConnUtils.getOracleConnection();
         

    }
     
    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
 
    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}