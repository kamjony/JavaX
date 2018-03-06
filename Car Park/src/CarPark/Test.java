/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPark;



/**
 *
 * @author KamrulHasan
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CarParkManager sys = new WestminsterCarPark(20);
        
        boolean exit = false;
        
        while (!exit){
            exit = sys.runMenu();
        }
        
    }
    
}
