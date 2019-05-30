
package sql_project;

import java.sql.SQLException;

/**
 * Demonstrates connecting and disconnecting to SQL database with DBConnectionManager.  SQL Server must be running and connection properties must be valid.
 * @author matt roberts
 */
public class SQL_Project {
    
    //Fill in the password you are using
    private static final String PASSWORD="pleaseChooseAPassword";

    /**
     * No command line arguments are given
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create the dbcm
        DBConnectionManager dbcm=new DBConnectionManager(PASSWORD);
        //try to connect
        try {
            dbcm.connect();
        } catch (SQLException e) {
            System.out.println(e);
        }
        //try to disconnect
        try {
            dbcm.disconnect();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
