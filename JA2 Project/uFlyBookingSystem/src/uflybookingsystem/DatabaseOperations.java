/*
 * This class contains all the common operations that involve retreiving data from the database, 
 * saving data to the database or updating existing database data 
 * for all three tables (Location, Flight and Booking)
 */
package uflybookingsystem;


import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import uflybookingsystem.BusinessObjects.*;


public class DatabaseOperations {
    
    //method that gets all the information from the Location table
    public static ArrayList<Location> GetAllLocations() {
        try (Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM location")) {
            ArrayList<Location> locations = new ArrayList<>();
            while (resultSet.next()) {
                Location location = new Location();
                location.setCity(resultSet.getString("City"));
                location.setAirportCode(resultSet.getString("AirportCode"));
                locations.add(location);
            }
            return locations;
        } catch (SQLException sqle) {
            System.out.println(sqle.toString());    
        }
        return null;
    }
    
    // this method returns all the data from the Flight table in the uFly database
    public static ArrayList<Flight> GetAllFlights(String departure, String destination){
         try (Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM flight "
                        + "where DepartureAirport = '" + departure + "' and "
                        + "DestinationAirport = '" + destination +"'")){
             ArrayList<Flight> flights = new ArrayList<>();
             while(resultSet.next()){
                 Flight flight = new Flight();
                 flight.setFlightNumber(resultSet.getString("FlightNumber"));
                 flight.setDepartureAirport(resultSet.getString("DepartureAirport"));
                 flight.setDestinationAirport(resultSet.getString("DestinationAirport"));
                 flight.setPrice(resultSet.getDouble("Price"));
                 flight.setDateTime(resultSet.getDate("DateTime"));
                 flight.setPlane(resultSet.getString("Plane"));
                 flight.setSeatsTaken(resultSet.getInt("SeatsTaken"));
                 flights.add(flight);                 
             }
             return flights;             
         }catch (SQLException sqle){
             System.out.println(sqle.toString());
         }catch (ParseException pe){
             System.out.println(pe.toString());
         }
         return null;
    }
    
    //this method obtains all the information from the Flight table based on the departure and destination airports as well as travel date
    public static ArrayList<Flight> GetAllFlightsForLocation(String departure, String destination, java.util.Date travelDate){
        
        try (Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM flight "
                        + "where DepartureAirport = '" + departure + "' and "
                        + "DestinationAirport = '" + destination + "' and DateTime "
                        + "= " + travelDate)){            
             ArrayList<Flight> flights = new ArrayList<>();
             while(resultSet.next()){
                 Flight flight = new Flight();
                 flight.setFlightNumber(resultSet.getString("FlightNumber"));
                 flight.setDepartureAirport(resultSet.getString("DepartureAirport"));
                 flight.setDestinationAirport(resultSet.getString("DestinationAirport"));
                 flight.setPrice(resultSet.getDouble("Price"));
                 flight.setDateTime(resultSet.getDate("DateTime"));
                 flight.setPlane(resultSet.getString("Plane"));
                 flight.setSeatsTaken(resultSet.getInt("SeatsTaken"));
                 flights.add(flight);                 
             }
             return flights;             
         }catch (SQLException sqle){
             System.out.println(sqle.toString());
         }catch (ParseException pe){
             System.out.println(pe.toString());
         }
         return null;
  
    }
    
    //this method adds booking passed as a parameter to the Booking table in the uFly database
    //note that Booking number is set as an incrementing field, so it doesn't need to be set
    public static void AddBooking(Booking booking){
        
        try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("Select * from booking")){
            //Inserting the new booking into the resltSet and database
            resultSet.moveToInsertRow();
            resultSet.updateInt("BookingNumber", booking.getBookingNumber());
            resultSet.updateString("FlightNumber", booking.getFlightNumber());
            resultSet.updateBigDecimal("Price", booking.getPrice());
            resultSet.updateString("CabinClass", booking.getCabinClass());
            resultSet.updateInt("Quantity", booking.getQuantity());
            resultSet.updateBoolean("Insurance", booking.getInsurance());
            resultSet.insertRow();
        }catch (SQLException sqle){
            System.out.println(sqle.toString());
        }
    }
    
    //this method obtains the flight based on the flightNumber parameter
    public static Flight getFlightByFLightNumber(String flightNumber){
        try (Connection connection = DbConnector.connectToDb();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM flight "
                + "where FlightNumber = '" + flightNumber +"'")){            
             
             Flight flight = new Flight();
             while(resultSet.next()){                 
                 flight.setFlightNumber(resultSet.getString("FlightNumber"));
                 flight.setDepartureAirport(resultSet.getString("DepartureAirport"));
                 flight.setDestinationAirport(resultSet.getString("DestinationAirport"));
                 flight.setPrice(resultSet.getDouble("Price"));
                 flight.setDateTime(resultSet.getDate("DateTime"));
                 flight.setPlane(resultSet.getString("Plane"));
                 flight.setSeatsTaken(resultSet.getInt("SeatsTaken"));
                             
             }
             return flight;             
         }catch (SQLException sqle){
             System.out.println(sqle.toString());
         }catch (ParseException pe){
             System.out.println(pe.toString());
         }
         return null;
   
    }
    
     //this method obtains the flight based on the flightNumber parameter
   public static Location getLocationByAirportCode(String airportCode){
	try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from Location "
                    + "WHERE AirportCode = '" + airportCode + "'")){
            
            while (resultSet.next()) {
            	Location location = new Location();
            	location.setCity(resultSet.getString("City"));
            	location.setAirportCode(resultSet.getString("AirportCode"));
            	return location;
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }  
        return null;
    }
    
    //this method adds location passed as a parameter to the Location table in the uFly database
    public static void AddLocation(Location location){
	try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("SELECT City, AirportCode from Location")){
            //Adding the location into the database
            resultSet.moveToInsertRow();
            resultSet.updateString("City", location.getCity());
            resultSet.updateString("AirportCode", location.getAirportCode());
            resultSet.insertRow();
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        } 
    }
     
    //this method adds a flight passed as a parameter to the Flight table in the uFly database
    public static void AddFlight(Flight flight){
        try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("Select * from flight")){
            //Inserting the new flight into the resltSet and database
            resultSet.moveToInsertRow();
            resultSet.updateString("FlightNumber", flight.getFlightNumber());
            resultSet.updateString("DepartureAirport", flight.getDepartureAirport());
            resultSet.updateString("DestinationAirport", flight.getDestinationAirport());
            resultSet.updateDouble("Price", flight.getPrice());
            resultSet.updateDate("DateTime", (java.sql.Date)flight.getDateTime());
            resultSet.updateString("Plane", flight.getPlane());
            resultSet.updateInt("SeatsTaken", flight.getSeatsTaken());
            resultSet.insertRow();
        }catch (SQLException sqle){
            System.out.println(sqle.toString());
        }
    }

    
    //this method updates the location to the one passed to it as a parameter where the airport codes are matching
    public static void UpdateLocation(Location location){
        try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("Select * from location where AirportCode = '" + location.getAirportCode() + "'")){
            resultSet.absolute(1); //move to first row of resultset
            resultSet.updateString("City", location.getCity()); //update city string
            resultSet.updateRow(); //update the record in database
        }catch (SQLException sqle){
            System.out.println(sqle.toString());
        }
        
    }
    
    //this method updates the flight to the one passed to it as a parameter where the flight numbers are matching
    public static void UpdateFlight(Flight flight){
        try (Connection connection = DbConnector.connectToDb();
            Statement statement = connection.createStatement(
            ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("Select * from flight where FlightNumber = '" + flight.getFlightNumber() + "'")){
            resultSet.absolute(1); //move to first row of resultset
            //update the fields to the new location values
            resultSet.updateString("DepartureAirport", flight.getDepartureAirport()); 
            resultSet.updateString("DestinationAirport", flight.getDestinationAirport());
            resultSet.updateDouble("Price", flight.getPrice());
            resultSet.updateDate("DateTime", (java.sql.Date)flight.getDateTime());
            resultSet.updateString("Plane", flight.getPlane());
            resultSet.updateInt("SeatsTaken", flight.getSeatsTaken());
            resultSet.updateRow(); //update the record in the database 
        }catch (SQLException sqle){
            System.out.println(sqle.toString());
        }
        
    }
}
