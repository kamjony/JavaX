/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import javax.swing.*;

/**
 *
 * @author KamrulHasan
 */
public class Symbol implements ISymbol{
    private int value;
    private ImageIcon image;
    
    
    //constructor
    public Symbol() {
        value=0;
        image=null;
    }
    
    public Symbol(int value, ImageIcon image){
        this.value=value;
        this.image=image;
    }
    
    public void setValue(int value){
        this.value=value;
    }
    
    public void setImage(ImageIcon image){
        this.image=image;
    }
    
    public int getValue(){
        return value;
    }
    
    public ImageIcon getImage(){
        return image;
    }

    
    public int compareTo(Symbol s){
        int returnvalue=1;
        if(this.getValue()==s.getValue()){
            returnvalue=0;
        }
        return returnvalue;
    }

    int comapareTo(Symbol faceImage2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    

    
    
    
    
}
