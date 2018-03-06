/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPark;

/**
 *
 * @author w1535035
 */
public class Van extends Vehicle{
    protected double VolmOfCargo;
    
    public Van(String IDplate, String brand, double VolmOfCargo, DateTime duration) {
        super(IDplate, brand);
        this.VolmOfCargo = VolmOfCargo;
        this.duration = duration;
    }
    
    public double getVolmOfCargo(){
        return VolmOfCargo;
    }
    
    public void setVolmOfCargo(double VolmOfCargo){
        this.VolmOfCargo = VolmOfCargo;
    }
    public DateTime getDuration(){
        return duration;
    }
    public void setDuration(DateTime duration){
        this.duration=duration;
    }
   
    @Override
     public String toString(){
        return super.toString() + VolmOfCargo;
     }
     
     
     public String getType(){
         return "Van";
     }
}
