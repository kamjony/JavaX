/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author KamrulHasan
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SlotMachine myFrame = new SlotMachine();
        myFrame.setSize(800,800);
        myFrame.setTitle("Slot Machine");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
        
    }
    
}
