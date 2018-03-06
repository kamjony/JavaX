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
public interface CarParkManager {

    public abstract void addVehicle(Vehicle vehicle);

    public abstract void printVehicleList();

    public abstract boolean runMenu();

}
