/*
 * JP2 Project
 * Drew White
 * 92017830
 */
package uflybookingsystem;

/**
 *
 * @author 92017830
 */
public enum Plane {
    AIRBUSA350(270), AIRBUSA280(500), BOEING737(215), BOEING747(460);
    
    private int passengerCapacity;
    
    private Plane(int passengerCapacity){
        this.passengerCapacity = passengerCapacity;
    }
    
    public int getPassengerCapacity(){
        return passengerCapacity;
    }
}
