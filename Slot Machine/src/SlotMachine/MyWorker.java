/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author KamrulHasan
 */
public class MyWorker extends SwingWorker<Boolean, Symbol> {
    JLabel label;
    Reel reel;
    
    public MyWorker(JLabel label, Reel reel){
        this.label=label;
        this.reel=reel;
    }
    
    protected Boolean doInBackground() throws Exception{
        ArrayList<Symbol> symbol = reel.spinThread();
        for (int i=0; i<symbol.size(); i++){
            System.out.println("Running " + i);
            publish(symbol.get(i));
            Thread.sleep(1000);
            
            while(true) {
                for (i=0;  i<symbol.size(); i++){
                    System.out.println("Running " + i);
                    publish(symbol.get(i));
                    Thread.sleep(1000);
                    
                }
            }
                
        } return true;
    }
    
    protected void done() {
        
        boolean status;
        try{
            status=get();
            System.out.println("Completed with status " + status);
        } catch (InterruptedException e){
            //this is thrown if thread's interrupted
        } catch (Exception e){
            //this is thrown if we throw an exception from doItBackground
        }
    }
    
    protected void process(List<Symbol> chunks) {
        //Here we receive the values that we publish()
        //They may come grouped in chunks
        Symbol mostRecentValue = chunks.get(chunks.size()-1);
        label.setIcon(mostRecentValue.getImage());
    }
    
}
