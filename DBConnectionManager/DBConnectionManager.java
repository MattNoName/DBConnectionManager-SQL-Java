
package dbconnectionmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Can connect and disconnect to a SQL database and provide a gettable Connection object once the connect method has been called without an SQL Exception.
 * @author matt roberts
 */
public class DBConnectionManager {
    
    /*
    The connection to the dbms.  It is null until connect() is called withoiut 
    an SQLException being thrown.
    */
    private Connection connection;
    
    /*
    The username of the user of the SQL database.  It is root by default.  
    Reassign to it in constructor to change this username.
     */
    private String username = "root";
    
    /*
     The password of the user of the SQL database. Reassign to it in constructor to change this password.
     */
    private String password = "choosePassword";

    /*
     The string name of the DBMS you are using. It is "mysql" by default. 
     Reassign to it in constructor if you are using a different DBMS.
     */
    private String dbms = "mysql";

    /**
     * The host name your DBMS is acting as a server on.  By default it is "localhost".  Reassign to it in constructor if you want a host that is not on your computer.
     */
    private String host = "localhost";
    
    /*
     The number of the port your DBMS accepts connections on, as a String.  
    By default it is "3306".  Reassign to it in constructor if you are using a 
    different port for your DBMS.
     */
    private String portNumber = "3306";

    /**
     * Connect using username "root" and password="choosePassword"
     */
    public DBConnectionManager() {
    
    }
    
    /**
     * Connect using username "root" and a password of your choosing
     * @param password the password you want to use for the connection
     */
    public DBConnectionManager(String password) {
         this.password=password;
    }
    
    /**
     * Connect with a username and a password of your choosing
     * @param username the username you want to use for the connection
     * @param password the password you want to use for the connection
     */
    public DBConnectionManager(String username, String password) {
         this.username=username;
         this.password=password;
    }
    
    /**
     * Connect choosing username, password, dbms, host, and portNumber.
     * @param username the username you want to use for the connection
     * @param password the password you want to use for the connection
     * @param dbms the dbms of the database you want to connect to
     * @param host the host where your SQL server is located
     * @param portNumber the port you want to make the connection on
     */
     public DBConnectionManager(String username, String password, String dbms, 
             String host, String portNumber) {
         this.username=username;
         this.password=password;
         this.dbms=dbms;
         this.host=host;
         this.portNumber=portNumber;
    }
    
    /**
     * Tries to connect to SQL database with JDBC.  Connection can be gotten with getConnection method.
     * @throws SQLException If something goes wrong trying to connect
     */
    public void connect() throws SQLException{
        connection = DriverManager.getConnection(
                getConnectionString(username, password));
        System.out.println("Connection made.");
    }
    
    /*
     The connection string used to connect to the db
     */
    private String getConnectionString(String username, String password){
        StringBuilder strBuilder=new StringBuilder();
        strBuilder.append("jdbc:");
        strBuilder.append(dbms);
        strBuilder.append("://");
        strBuilder.append(host);
        strBuilder.append(":");
        strBuilder.append(portNumber);
        strBuilder.append("/?");
        strBuilder.append("user=");
        strBuilder.append(username);
        strBuilder.append("&password=");
        strBuilder.append(password);
        strBuilder.append("&serverTimezone=");
        strBuilder.append("UTC");
        return strBuilder.toString();
    }
    
    /**
     * Tries to disconnect to SQL database with JDBC.
     * @throws SQLException If something goes wrong trying to disconnect
     */
    public void disconnect() throws SQLException{
        connection.close();
        System.out.println("Connection closed.");
    }
        
    
    /**
     * Gets the connection to the SQL database or null if it is null.
     * @return a Connection or null
     */
    public Connection getConnection() {
        return connection;
    }
    
    
    
}
