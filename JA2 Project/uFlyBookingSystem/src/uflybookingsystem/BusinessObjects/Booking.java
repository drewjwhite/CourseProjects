/*
 * JP2 Project
 * Drew White
 * 92017830
 */
package uflybookingsystem.BusinessObjects;

import java.math.BigDecimal;

/**
 * Class for bookings table in the uFly database
 * @author 92017830
 */
public class Booking {
    private int bookingNumber;
    private String flightNumber;
    private BigDecimal price;
    private String cabinClass;
    private int quantity;
    private boolean insurance;

    /**
     * @return the bookingNumber
     */
    public int getBookingNumber() {
        return bookingNumber;
    }

    /**
     * @param bookingNumber the bookingNumber to set
     */
    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    /**
     * @return the flightNumber
     */
    public String getFlightNumber() {
        return flightNumber;
    }

    /**
     * @param flightNumber the flightNumber to set
     */
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    /**
     * @return the price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return the cabinClass
     */
    public String getCabinClass() {
        return cabinClass;
    }

    /**
     * @param cabinClass the cabinClass to set
     */
    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the insurance
     */
    public boolean getInsurance() {
        return insurance;
    }

    /**
     * @param insurance the insurance to set
     */
    public void setInsurance(boolean insurance) {
        this.insurance = insurance;
    }
    
}
