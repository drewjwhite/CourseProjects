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
public class SalariedSubordinate extends Person implements ISalariedPerson, ISubordinate{
    
    private Date startDate;
    private TimePeriod timePeriod;
    private IManager manager;
    private double baseSalary;
    private double currentBonus = 0.0d;
    
    public SalariedSubordinate(double baseSalary, IManager manager){
        this.baseSalary = baseSalary;
        this.manager = manager;
    }
    
    @Override
    public double calculatePay() throws Exception {
        double pay = 0.0d;
        try {
            SalaryPaymentCalculator calcPay = new SalaryPaymentCalculator();
            pay = calcPay.calculatePay(this);
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return pay;
    }

    @Override
    public Date getStartDate() {
        return startDate;
    }
   
    
    @Override
    public TimePeriod getTimePeriod() {
        return timePeriod;
    }

    
    
    
    @Override
    public double getBaseSalary() {
        return baseSalary;
    }
    
    
    @Override
    public double getCurrentBonus() {
        return currentBonus;
    }

    @Override
    public void setCurrentBonus(double bonus) {
        this.currentBonus = currentBonus + bonus;
    }

    @Override
    public void setTimePeriod(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    @Override
    public IManager getManager() {
        return manager;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        SimpleDateFormat dmyFormat = new SimpleDateFormat("dd/MM/yyyy");
        String start = startDate;
        try {            
            this.startDate = dmyFormat.parse(start);
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
