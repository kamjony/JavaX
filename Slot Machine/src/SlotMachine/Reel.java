/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author KamrulHasan
 */
public class Reel {
    public ArrayList<Symbol> symbol;
    
    public Reel(){
        Symbol redseven = null;
        Symbol bell = null;
        Symbol cherry = null;
        Symbol lemon = null;
        Symbol plum = null;
        Symbol watermelon = null;
        
        // instanciate the array list
        symbol = new ArrayList<Symbol>();
        
        try{
        redseven = new Symbol(1, new ImageIcon(getClass().getResource("redseven.png")));
        }catch(NullPointerException e){
            System.out.println("The image redseven is not found");
        }
        try{
        bell = new Symbol(2, new ImageIcon(getClass().getResource("bell.png")));
        }catch(NullPointerException e){
            System.out.println("The image 2 is not found");
        }
        try{
        cherry = new Symbol(3, new ImageIcon(getClass().getResource("cherry.png")));
        }catch(NullPointerException e){
            System.out.println("The image 3 is not found");
        }
        try{
        lemon = new Symbol(4, new ImageIcon(getClass().getResource("lemon.png")));
        }catch(NullPointerException e){
            System.out.println("The image 4 is not found");
        }
        try{
        plum = new Symbol(5, new ImageIcon(getClass().getResource("plum.png")));
        }catch(NullPointerException e){
            System.out.println("The image 5 is not found");
        }
        try{
        watermelon = new Symbol(6, new ImageIcon(getClass().getResource("watermelon.png")));
        }catch(NullPointerException e){
            System.out.println("The image 6 is not found");
        }
        
        // add the dice face to the array
        symbol.add(redseven);
        symbol.add(bell);
        symbol.add(cherry);
        symbol.add(lemon);
        symbol.add(plum);
        symbol.add(watermelon);
    }
    
    public Symbol Spin(){
        Random rand = new Random();
        int randomNum; 
        randomNum = rand.nextInt(symbol.size());
        
        return symbol.get(randomNum);
    }
    
    public ArrayList<Symbol> spinThread(){
        Collections.shuffle(symbol);
        return symbol;
        
    }
    
    
}
        
        
    
    

    
    
