/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 92017830
 */
public class Manager extends SalariedSubordinate implements IManager{

    private ArrayList<ISubordinate> subordinates;
    private double totalManagerBonusFund = 5000;
    
    public Manager(double baseSalary, IManager manager, ArrayList<ISubordinate> subordinateList){
        super(baseSalary, manager);
        this.subordinates = subordinateList;           
    }
    
    public Manager(double baseSalary, IManager manager){
        this(baseSalary, manager, new ArrayList<ISubordinate>());
    }
    
    /**
     * @return the subordinates
     */
    @Override
    public ArrayList<ISubordinate> getSubordinateList() {
        return subordinates;
    }

    /**
     * @param subordinates the subordinates to set
     */
    public void setSubordinates(ArrayList<ISubordinate> subordinates) {
        this.subordinates = subordinates;
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
         
    @Override
    public String assignBonus(ISubordinate subordinate, double bonus) {
        String message = BonusUpdater.assignBonus(this, subordinate, bonus);
        return message;
    }
    
    @Override
    public double calculatePay() throws Exception {
        double pay = SalaryPaymentCalculator.calculatePay(this);
        return pay;
    }
        
    @Override
    public void applyBonus(double bonus) {
        totalManagerBonusFund = totalManagerBonusFund - bonus;
    }
//
    
//    @Override
//    public Date getStartDate() {
//      Date startDate = super.getStartDate();
//      return startDate;    
//    }
//    
//    
//    
//    
//    
//    @Override
//    public ArrayList<ISubordinate> getSubordinateList() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
////
//    @Override
//    public double getTotalManagerBonusFund() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setTotalManagerBonusFund(double totalManagerBonusFund) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
////    @Override
////    public TimePeriod getTimePeriod() {
////        return super.getTimePeriod();
////    }
//
//    @Override
//    public double getBaseSalary() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public double getCurrentBonus() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setCurrentBonus(double bonus) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void setTimePeriod(TimePeriod timePeriod) {
//        super.setTimePeriod(timePeriod);
//    }
    
}
