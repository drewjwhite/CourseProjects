/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.Date;

/**
 *
 * @author 92017830
 */
public class PayrollReportItem {
    
    Person person;
    double salary;
    Date startOfPayPeriod;
    TimePeriod payPeriod;
    
    public PayrollReportItem(Person person, double salary, Date startOfPayPeriod, TimePeriod payPeriod){
        this.person = person;
        this.salary = salary;
        this.startOfPayPeriod = startOfPayPeriod;
        this.payPeriod = payPeriod;
    }
    
    @Override
    public String toString(){
        String payrollMessage;
        payrollMessage = person.getFirstName() + " " + person.getLastName() + 
                " was paid $" + String.valueOf(salary)+ " on the " + 
                startOfPayPeriod.toString() + ". Payment Period: " + 
                payPeriod.toString();
        return payrollMessage;
    }
    
}
