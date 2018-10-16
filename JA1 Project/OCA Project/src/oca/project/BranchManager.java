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
public class BranchManager extends Manager{
    
    public BranchManager(IManager manager){
        super(75000, manager);
        this.setPosition("Branch Manager");
    }
    
    
    
}
