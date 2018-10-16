/*
 * JP2 Project
 * Drew White
 * 92017830
 */
package uflybookingsystem.BusinessObjects;

/**
 * Class for location table in uFly database
 * @author 92017830
 */
public class Location {
    private String city;
    private String airportCode;
    
    @Override
    public String toString(){
        return city + " " + airportCode;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the airportCode
     */
    public String getAirportCode() {
        return airportCode;
    }

    /**
     * @param airportCode the airportCode to set
     */
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
    
}
