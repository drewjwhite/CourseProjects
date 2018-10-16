/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 92017830
 */
public class SalaryPaymentCalculator {
    static final Integer WEEKS = 52;
    static final Integer MONTHS = 12;
    
    
    static DecimalFormat payFormat = new DecimalFormat("#.##");
    
    public static int calcYearDiff(Date firstDate, Date secondDate) {
      // create 2 calendars
      Calendar cal1 = Calendar.getInstance();
      Calendar cal2 = Calendar.getInstance();
      cal1.setTime(firstDate);
      cal2.setTime(secondDate);
      int diff = cal1.get(Calendar.YEAR) - cal2.get(Calendar.YEAR);      
      return diff;
    }
    
    public static double calculateCurrentSalaryWithIncrease(double baseSalary, Date dateStarted){
        double currentSalary = baseSalary;
        Date currentDate = new Date();
        int diff = calcYearDiff(dateStarted, currentDate);
        
        if (diff %2 == 0){
            diff = diff/2;
        }
        else if((diff-1)% 2 == 0){
            diff = (diff-1)/2;
        }
        for (int i = 0; i < diff; i++){
            currentSalary = currentSalary * 1.02;
        }        
        
        return currentSalary;
    }
    
    public static double calculateFinalYearlyPay(ISalariedPerson staffMember){
        double baseSalary = staffMember.getBaseSalary();
        double currentBonus = staffMember.getCurrentBonus();
        Date startDate = staffMember.getStartDate();
        double finalYearlyPay;
                
        finalYearlyPay = calculateCurrentSalaryWithIncrease(baseSalary, startDate) + currentBonus;
        finalYearlyPay = Double.parseDouble(payFormat.format(finalYearlyPay));
        return finalYearlyPay;
    }
    
    public static double calculatePay(ISalariedPerson staffMember){
        double pay =0.0d;
        if (staffMember.getTimePeriod()== TimePeriod.FORTNIGHTLY) {
            pay = calculateFinalYearlyPay(staffMember) / (WEEKS/2);
        }
        else if (staffMember.getTimePeriod() == TimePeriod.MONTHLY) {
            pay = calculateFinalYearlyPay(staffMember) / MONTHS;
        }
        pay = Double.parseDouble(payFormat.format(pay));
        return pay;
    }
}
