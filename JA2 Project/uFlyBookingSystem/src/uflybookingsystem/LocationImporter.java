/*
 * JP2 Project
 * Drew White
 * 92017830
 */
package uflybookingsystem;

import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import uflybookingsystem.BusinessObjects.*;

/**
 *
 * @author 92017830
 */
public class LocationImporter extends BaseImporter {

    String fileData;
    
    

    public LocationImporter(String fileName) {
        super(fileName);
    }

    @Override
    public void run() {
        
        ImportResult results = new ImportResult();
        try (FileReader inputFile = new FileReader(fileName)) {
            int ch = 0;
            while ((ch = inputFile.read()) != -1) {
                fileData = fileData + (char) ch;
            }
            //System.out.println("\r\n" + fileData);
            String[] lines = fileData.replace("\r\n", "\n").replace("\r", "\n").split("\n");
            String firstLine = lines[0];
//            System.out.println("firstline " + firstLine);
//            System.out.println("Lines 0: " + lines[0]);
//            System.out.println(lines[1]);
//            System.out.println(lines[2]);
                        
            String[] columns = firstLine.split(",");
//            System.out.println("columns 0: " + columns[0]);
            if (columns.length == 2 && (columns[0].equals("nullCity") & columns[1].equals("Airport Code"))) {
                lines[0] = "";
//                System.out.println("Lines 0: " + lines[0]);
//                System.out.println(lines[1]);
//                System.out.println(lines[2]);
            }
            int lineNum = 1;
            for (String line : lines) {
                try {
                    if (line.isEmpty()) {
                        results.getErrorMessages().add("Error: Line " + lineNum + " is empty.");
                        continue;
                    }
                    results.setTotalRows(lineNum);
                    int items = 0;
                    for (String str : line.split(",")) {
                        items++;
                    }
                    if (items != columns.length) {
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum + ": Tried to add too many elements to the array!");
                        continue;
                    } else {
                        columns = line.split(",");
                    }
                    if (columns[0].isEmpty()) {
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum + ": City entry is empty.");
                        continue;
                    }
                    if (columns[1].isEmpty()) {
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum + ": City Code entry is empty.");
                        continue;
                    }
                                      
                    if (!isThreeLetters(columns[1])) {
//                        System.out.println(columns[0]);
//                        System.out.println(columns[1]);
                        results.setFailedRows(results.getFailedRows() + 1);
                        results.getErrorMessages().add("Error in line " + lineNum + ": Airport Code entry is invalid.");
                        continue;
                    }
                    
                    Location locationToUpdate = DatabaseOperations.getLocationByAirportCode(columns[1]);
                    String city = columns[0];
                    String cityCode = columns[1];
                    if (locationToUpdate != null) {
                        locationToUpdate.setCity(city);
                        locationToUpdate.setAirportCode(cityCode);
                        DatabaseOperations.UpdateLocation(locationToUpdate);
                    } else {
                        Location locationToAdd = new Location();
                        locationToAdd.setCity(city);
                        locationToAdd.setAirportCode(cityCode);
                        DatabaseOperations.AddLocation(locationToAdd);
                        //bookingForm.locationsList.add(locationToAdd);
                    }
                    results.setImportedRows(results.getImportedRows() + 1);
//                    System.out.println(columns[0]);
//                    System.out.println(columns[1]);
//                    System.out.println(results.getErrorMessages());

                } catch (Exception e) {
                    results.getErrorMessages().add("Error in Line " + lineNum + ": Unknown error.");
                } finally {
//                    System.out.println("Line " + lineNum + " imported successfully.");
//                    System.out.println(results.getImportedRows());
//                    System.out.println(results.getTotalRows());
                    lineNum++;
                    super.setResults(results);
                }
            }
        } catch (IOException ioe) {
            results.getErrorMessages().add("Error: Unable to read File. " + ioe.toString());
        } catch (Exception e) {
            results.getErrorMessages().add("Error: " + e.toString());
        }
        System.out.println("outside of try block, total rows " + results.getTotalRows());
    }
    
    public boolean isThreeLetters(String s){
        return s.matches("[A-Z]{3}");
     }
}
