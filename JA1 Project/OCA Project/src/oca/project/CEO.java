/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 92017830
 */
public class CEO extends Person implements IManager, ISalariedPerson{
    
    private TimePeriod payPeriod;
    private double currentBonus = 0;
    private double baseSalary = 110000;
    private double totalManagerBonusFund = 5000;
    private Date startDate;
    private ArrayList<ISubordinate> SubordinateList;

    /**
     * @return the payPeriod
     */
//    public TimePeriod getPayPeriod() {
//        return payPeriod;
//    }

    /**
     * @param payPeriod the payPeriod to set
     */
    public void setPayPeriod(TimePeriod payPeriod) {
        this.payPeriod = payPeriod;
    }

    /**
     * @return the currentBonus
     */
    @Override
    public double getCurrentBonus() {
        return currentBonus;
    }

    /**
     * @param currentBonus the currentBonus to set
     */
    public void setCurrentBonus(double currentBonus) {
        this.currentBonus = currentBonus;
    }

    /**
     * @return the baseSalary
     */
    public double getBaseSalary() {
        return baseSalary;
    }

    /**
     * @param baseSalary the baseSalary to set
     */
    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    /**
     * @return the totalManagerBonusFund
     */
    @Override
    public double getTotalManagerBonusFund() {
        return totalManagerBonusFund;
    }

    /**
     * @param totalManagerBonusFund the totalManagerBonusFund to set
     */
    @Override
    public void setTotalManagerBonusFund(double totalManagerBonusFund) {
        this.totalManagerBonusFund = totalManagerBonusFund;
    }

    /**
     * @return the startDate
     */
    @Override
    public Date getStartDate() {
        return startDate;
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

    @Override
    public ArrayList<ISubordinate> getSubordinateList() {
        return SubordinateList;
    }

    /**
     * @param SubordinateList the SubordinateList to set
     */
    public void setSubordinateList(ArrayList<ISubordinate> SubordinateList) {
        this.SubordinateList = SubordinateList;
    }
    
    @Override
    public double calculatePay(){
        double pay = SalaryPaymentCalculator.calculatePay(this);
        return pay;
    }
    
    @Override
    public void applyBonus(double bonus) {
        totalManagerBonusFund = totalManagerBonusFund - bonus;
    }

    @Override
    public String assignBonus(ISubordinate subordinate, double bonus) {
        String message = BonusUpdater.assignBonus(this, subordinate, bonus);
        return message;
    }

//    @Override
//    public double getTotalManagerBonusFund() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setTotalManagerBonusFund(double totalManagerBonusFund) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public TimePeriod getTimePeriod() {
        return payPeriod;
    }

    @Override
    public void setTimePeriod(TimePeriod timePeriod) {
        this.payPeriod = timePeriod;
    }

    
    
    
    
    
}
