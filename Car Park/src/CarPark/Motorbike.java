/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPark;


public class Motorbike extends Vehicle{
    
    protected int engSize;
    
    public Motorbike(String IDplate, String brand, int engSize, DateTime duration) {
        super(IDplate, brand);
        this.engSize = engSize;
        this.duration = duration;
    }

    
    
    public int getEngSize(){
        return engSize;
    }
    public DateTime getDuration(){
        return duration;
    }
    public void setDuration(DateTime duration){
        this.duration=duration;
    }
    
    public void setEngSize(int engSize){
        this.engSize = engSize;
    }
   public String getMotorbikeDetails(){
        return super.toString() + engSize;
        
    }
        
    
    @Override
     public String toString(){
        return super.toString() + engSize;
     }
     
    
     public String getType(){
         return "Motorbike";
     }
    
    
}
