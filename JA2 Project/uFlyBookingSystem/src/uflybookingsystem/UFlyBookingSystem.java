/*
 * Main class that starts up the application's Main form 
 */
package uflybookingsystem;

//import java.awt.Color;

public class UFlyBookingSystem {


    public static void main(String[] args) {
        MainForm mainForm = new MainForm();
        mainForm.setVisible(true);
        mainForm.setSize(900, 600);
        mainForm.setLocation(250, 250);
    }    
}
