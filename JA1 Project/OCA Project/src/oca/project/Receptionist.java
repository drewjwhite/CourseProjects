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
public class Receptionist extends SalariedSubordinate{
    
    public Receptionist(IManager manager){
        super(35000, manager);
        this.setPosition("Receptionist");
    }
    
}
