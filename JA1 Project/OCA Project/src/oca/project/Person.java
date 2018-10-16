/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 92017830
 */
public class Person {

    private String firstName;
    private String lastName;
    private Date doB = new Date();
    private String position;
    private Boolean isContractor = false;
    
    //SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
    
    @Override
    public String toString() {
        return getFirstName() + " " + getLastName(); //Concatenates name for display
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the doB
     */
    public Date getDoB() {
//        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd-MM-yyyy");
//        String dateoB = dmyFormat.format(doB);
        return doB;
    }

    /**
     * @param doB the doB to set
     */
    public void setDoB(String doB) {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy");
        String start = doB;
        try {            
            this.doB = dmyFormat.parse(start);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /**
     * @return the position
     */
    public String getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * @return the isContractor
     */
    public Boolean getIsContractor() {
        return isContractor;
    }

    /**
     * @param isContractor the isContractor to set
     */
    public void setIsContractor(Boolean isContractor) {
        this.isContractor = isContractor;
    }
    
    
     
}
