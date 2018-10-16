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
public class SeniorProgramDeveloper extends Manager{
    
    public SeniorProgramDeveloper(IManager manager){
        super(75000, manager);
        this.setPosition("Senior Program Developer");
    }
    
}
