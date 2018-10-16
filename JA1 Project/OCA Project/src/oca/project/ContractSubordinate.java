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
public class ContractSubordinate extends Person implements IContractor{
    
    IManager manager;
    double hourlyRate;
    
    public ContractSubordinate(double hourlyRate, IManager manager){
        this.hourlyRate = hourlyRate;
        this.manager = manager;
    }
    

    @Override
    public double calculatePay(Date periodStartDate, double numberOfHours) throws Exception {
        double pay = 0;
        try {
            double overtimeRate = hourlyRate * 1.1;
        
            if (numberOfHours > 160) {
                pay = 160 * hourlyRate;
                pay = pay + (overtimeRate * (numberOfHours - 160));
            } else if (numberOfHours <= 160) {
                pay = numberOfHours * hourlyRate;
            }
        } catch (Exception e) {
            System.out.print(e.toString());
        } 
        return pay;        
    }

    @Override
    public double getHourlyRate() {
        return hourlyRate;
    }

    @Override
    public IManager getManager() {
        return manager;
    }
    
}
