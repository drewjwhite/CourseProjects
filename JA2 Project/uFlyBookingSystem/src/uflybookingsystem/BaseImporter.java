/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uflybookingsystem;

/**
 *
 * @author 92017830
 */
abstract class BaseImporter implements Runnable{
    
    String fileName;
    private ImportResult results;
    
    public BaseImporter(String fileName){
        this.fileName = fileName;
    }
    
    @Override
    public abstract void run();
    
    public ImportResult getResults(){
        return results;
    }
    
    public void setResults(ImportResult result){
        results = result;
    }
    
}
