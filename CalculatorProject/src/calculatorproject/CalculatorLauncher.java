/*
 *This is the launcher class for the calculator project created by:
 *Drew White 92017830
 *3/4/17
 */
package calculatorproject;

/**
 *
 * @author 92017830
 */
public class CalculatorLauncher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CalculatorFrame calc = new CalculatorFrame();
        calc.setVisible(true);
        calc.setLocation(200, 200);
        calc.setSize(325, 450);
        
    }
    
}
