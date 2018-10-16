/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.Date;

/**
 *
 * @author Inna
 */
public interface IContractor extends ISubordinate{
    
    //this method should be used by all contractors
    //to calculate the pay earned over a period of time
    public double calculatePay(Date periodStartDate, double numberOfHours) throws Exception ;
    
     public double getHourlyRate();
}
