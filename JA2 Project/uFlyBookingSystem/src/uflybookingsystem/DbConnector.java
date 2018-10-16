/*
 * JP2 Project
 * Drew White
 * 92017830
 */
package uflybookingsystem;

import java.sql.*;

/**
 *
 * @author 92017830
 */
public class DbConnector {
    
    public static Connection connectToDb() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/";
        String database = "ufly";
        String userName = "root";
        String password = "password";
                
        Connection connection = DriverManager.getConnection(url+database + "?autoReconnect=true&useSSL=false", userName, password);
        System.out.println("Database connection successful");
        return connection;
    }     
}
