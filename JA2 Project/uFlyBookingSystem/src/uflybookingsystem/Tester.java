/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uflybookingsystem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
//import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author 92017830
 */
public class Tester {
    
    static String fileData = " Flight Number,Departure Airport,Destination Airport,Price,DateTime,Plane,Seats Taken";
    
    
    public static void main(String[] args){
        System.out.println(fileData);
        fileData = fileData.replaceAll("\\s","");
        System.out.println(fileData);
        System.out.println(columnCheck());;
        //System.out.println(dateCheck("01/05/2017 12:05:00"));

    }
    
    public static boolean columnCheck(){
        String[] lines = fileData.replace("\r\n", "\n").replace("\r", "\n").split("\n");
        String firstLine = lines[0];
        String[] columns = firstLine.split(",");
        return lineCheck(columns);        
    }
    public static boolean lineCheck(String[] columns){
        try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flight")){
            ResultSetMetaData metadata = resultSet.getMetaData();
            boolean result;
            int count = 0;
            for (int i = 0; i < columns.length ; i++){
                String name = metadata.getColumnName(i+1); 
                System.out.println(columns[i]);
                System.out.println("Name " + name);
                if (columns[i].equals(name)){
                    count++;
                } 
            }
            if (columns.length == count){
                result = true;
            } else {
                result = false;
            }
            return result; 
        } catch (SQLException sqle){
            //bresults.getErrorMessages().add("Error: Failed to connect to the database.");
        }
        return false;
    }
    
    public static boolean dateCheck(String date){
       try {
        String pattern = "dd/MM/yyyy HH:mm";    
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date nd = formatter.parse(date);
        String drew = formatter.format(nd);
        
        String hh = "03/08/2017 12:05";
        Date kk = formatter.parse(hh);
        String drew2 = formatter.format(kk);
        
        
        //String newDate = formatter.format(date);
        if (drew.matches("^\\d{2}\\/\\d{2}\\/\\d{4}\\s\\d{2}:\\d{2}$")){
            return true;
        } else {
            return false;
        }
    } catch (ParseException pe){
           System.out.println("hjkhjhk");
    }
       return false;
    }
}
