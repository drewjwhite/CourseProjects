/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oca.project;

/**
 *
 * @author 92017830
 */
public class BonusUpdater {
    
    public static String assignBonus(IManager manager, ISubordinate subordinate, double bonus){
       int count = 0;
       String message = "";
       try {
           for (ISubordinate subordinate1 : manager.getSubordinateList()){
               if (subordinate1 == subordinate){
                   count = count++;
               }           
           }
           if (count == 0){
               throw new Exception();
           }
           else if (count == 1){
               if (manager.getTotalManagerBonusFund() < bonus){
                   message = "The manager cannot allocate more than $" 
                           + String.valueOf(manager.getTotalManagerBonusFund());
               }
               else {
                   ISalariedPerson salariedSubordinate = (ISalariedPerson)subordinate;
                   if (salariedSubordinate.getCurrentBonus() > 0){
                       message = subordinate.toString() + " has already got a bonus assigned";
                   }
                   else {
                       salariedSubordinate.setCurrentBonus(bonus);
                       message = "The bonus of $" + String.valueOf(bonus) + 
                               " has been assigned to " + subordinate.toString();
                   }
               }
           }
       }
       catch (Exception e){
           message = subordinate.toString() + " is not a subordinate of " + manager.toString() + ".";
                   
       }
       return message;
    }
    
}
