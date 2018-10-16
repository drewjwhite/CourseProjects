/*
 * JP2 Project
 * Drew White
 * 92017830
 */
package uflybookingsystem;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import uflybookingsystem.BusinessObjects.Flight;

/**
 *
 * @author 92017830
 */
public class FlightImporter extends BaseImporter {
    
    String fileData;
    

    public FlightImporter(String fileName) {
        super(fileName);
    }
    
    private String pattern = "dd/MM/yyyy HH:mm";
    SimpleDateFormat formatter = new SimpleDateFormat(pattern);

    @Override
    public void run() {
        ImportResult results = new ImportResult();
        try (FileReader inputFile = new FileReader(fileName)){
            int ch = 0;
            while ((ch = inputFile.read()) != -1){
                fileData = fileData + (char)ch;
            }
            String[] lines = fileData.replace("\r\n", "\n").replace("\r", "\n").split("\n");
            String firstLine = lines[0];
            String[] columns = firstLine.split(",");
            if (columns.length == 7 && lineCheck(columns)){
                lines[0] = "";
            }
//            System.out.println(lines[0]);
//            System.out.println(lines[1]);
//            System.out.println(lines[2]);
            int lineNum = 1;
            for (String line : lines){
                try {
                    if (line.isEmpty()){
                        results.getErrorMessages().add("Error: Line " + lineNum + " is empty.");
                        continue;
                    }
                    results.setTotalRows(lineNum);
                    int items = 0;
                    for (String str : line.split(",")){
                        items++;
                    }
                    if (items != columns.length){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Tried to add wrong number of elements to the array!");
                        continue;
                    } else {
                        columns = line.split(",");
                    }
                    if (columns[0].isEmpty()){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Flight Number entry is empty.");
                        continue;
                    }
                    if (columns[1].isEmpty()){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Departure Airport entry is empty.");
                        continue;
                    }
                    if (columns[2].isEmpty()){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Destination Airport entry is empty.");
                        continue;
                    }
                    if (!checkFlightNumber(columns[0])){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Flight Number is invalid.");
                        continue;
                    }
                    if (!checkCityCode(columns[1])) {
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Departure Airport Code entry is invalid.");
                        continue;
                    }
                    if (!checkCityCode(columns[2])) {
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Destination Airport Code entry is invalid.");
                        continue;
                    }
                    if (!doubleCheck(columns[3])){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Price entry is invalid.");
                        continue;
                    }
                    if (!intCheck(columns[6])){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Seats Taken entry is invalid.");
                        continue;
                    }
                    if (!dateCheck(columns[4])){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Flight date and time is invalid.");
                        continue;
                    }
                    Plane flightPlane = Plane.valueOf(columns[5]);
                    //System.out.println(Plane.valueOf(columns[5]));
                    int planeCount = 0;
                    for (Plane plane : Plane.values()){
                        if (flightPlane.equals(plane)){
                            planeCount++;
                        }
                    }
                    if (planeCount != 1){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Specified plane type is invalid.");
                        continue;
                    }
                    if (flightPlane.getPassengerCapacity() < Integer.parseInt(columns[6])){
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum 
                                + ": Seats taken exceeds plane limit.");
                        continue;
                    }
                    Flight flightToUpdate = DatabaseOperations.getFlightByFLightNumber(columns[0]);
                    if (flightToUpdate == null){
                        Flight flightToAdd = new Flight();
                        flightToAdd.setFlightNumber(columns[0]);
                        flightToAdd.setDepartureAirport(columns[1]);
                        flightToAdd.setDestinationAirport(columns[2]);
                        flightToAdd.setPrice(Double.parseDouble(columns[3]));
                        flightToAdd.setDateTime(Date.valueOf(columns[4]));
                        flightToAdd.setPlane(columns[5]);
                        flightToAdd.setSeatsTaken(Integer.parseInt(columns[6]));
                        DatabaseOperations.AddFlight(flightToAdd);
                    } else {
                        flightToUpdate.setFlightNumber(columns[0]);
                        flightToUpdate.setDepartureAirport(columns[1]);
                        flightToUpdate.setDestinationAirport(columns[2]);
                        flightToUpdate.setPrice(Double.parseDouble(columns[3]));
                        flightToUpdate.setDateTime(Date.valueOf(columns[4]));
                        flightToUpdate.setPlane(columns[5]);
                        flightToUpdate.setSeatsTaken(Integer.parseInt(columns[6]));
                        DatabaseOperations.UpdateFlight(flightToUpdate);
                    }
                    results.setImportedRows(results.getImportedRows() + 1);
                }catch (NumberFormatException | ParseException e){
                    results.getErrorMessages().add("Error in line " + lineNum 
                            + ": Unknown error - " + e.toString());
                }finally {
                    lineNum++;
                    super.setResults(results);
                }
            }
            
        } catch (IOException ioe){
            results.getErrorMessages().add("Error: Unable to read file. " + ioe.toString());
        } catch (Exception e){
            results.getErrorMessages().add("Error e - " + e.toString());
            System.out.println("Error message = " + e.getCause());
        }
    }
    
    public boolean lineCheck(String[] columns){
        try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM flight")){
            ResultSetMetaData metadata = resultSet.getMetaData();
            boolean result;
            int count = 1;
            for (int i = 0; i < columns.length ; i++){
                String name = metadata.getColumnName(i+1);
                String columnName = columns[i];
                columnName = columnName.replaceAll("\\s", "");
                if (columnName.equals(name)){
                    count++;
                }
                System.out.println(count);
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
    
    public boolean doubleCheck(String value){
        try {
            Double.parseDouble(value);
            return true;            
        } catch (NullPointerException  | NumberFormatException me){
            return false;
        }
    }
    
    public boolean intCheck(String value){
        try {
            Integer.parseInt(value);
            return true;
            } catch (NumberFormatException nfe){
                System.out.println("Parsing failed " + nfe.toString());
            }
        return false;
    }
    
    public static boolean dateCheck(String date){
       try {
        String pattern = "dd/MM/yyyy HH:mm";    
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        java.util.Date newDate = formatter.parse(date);
        String flightTime = formatter.format(newDate);        
                       
        if (flightTime.matches("^\\d{2}\\/\\d{2}\\/\\d{4}\\s\\d{2}:\\d{2}$")){
            //System.out.println("flight time matches");
            return true;
        } else {
            return false;
        }
    } catch (ParseException pe){
           System.out.println("Error: Unable to parse value");
    }
       return false;
    }  
    
    public boolean checkFlightNumber(String s){
        return s.matches("[A-Z]{2}[0-9]{3}");
    }
    
    public boolean checkCityCode(String s){
        return s.matches("[A-Z]{3}");
    }
}
