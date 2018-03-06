/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SlotMachine;

import javax.swing.ImageIcon;

/**
 *
 * @author KamrulHasan
 */
public interface ISymbol {
    
    public void setImage(ImageIcon Image);

    public ImageIcon getImage();

    public void setValue(int value);

    
    public int getValue();
    
}
