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
public class Car extends Vehicle{
    protected String colour;
    protected int numOfDoors;
    
    
    public Car(String IDplate, String brand, String colour, int numOfDoors, DateTime duration) {
        super(IDplate, brand);
        this.colour = colour;
        this.numOfDoors = numOfDoors;
        this.duration = duration;
    }

    
    public String getColour(){
        return colour;
    }
    public int getNumOfDoors(){
        return numOfDoors;
    }
    public DateTime getDuration(){
        return duration;
    }
    public void setDuration(DateTime duration){
        this.duration=duration;
    }
    public void setColour(String colour){
        this.colour = colour;
    }
    public void setNumofDoors(int numOfDoors){
        this.numOfDoors = numOfDoors;
    }
    public String getCarDetails(){
        return super.toString() + colour+","+numOfDoors;
        
    }
    @Override
     public String toString(){
        return super.toString() + colour + "," + numOfDoors;
     }
     
     
     public String getType(){
         return "Car";
     }
 
}
