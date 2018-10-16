package oca.project;

import java.util.ArrayList;

/**
 *
 * Interface that all the managers should implements
 */
public interface IManager extends ISalariedPerson{
    
    ArrayList<ISubordinate> getSubordinateList();
    
    double getTotalManagerBonusFund();

    void setTotalManagerBonusFund(double totalManagerBonusFund);
  
    void applyBonus(double bonus);
    
    String assignBonus(ISubordinate subordinate, double bonus);
}
