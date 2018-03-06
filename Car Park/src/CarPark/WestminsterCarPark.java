/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPark;

import com.sun.istack.internal.logging.Logger;
import java.util.*;
import java.util.logging.Level;

/**
 *
 * @author KamrulHasan
 */
public class WestminsterCarPark implements CarParkManager {

    private ArrayList<Vehicle> parkList;
    private int numParking;

    public WestminsterCarPark(int listLength) {
        this.numParking = listLength;
        parkList = new ArrayList<Vehicle>();
    }

    public int numOfAvailableLots() {                //num of available parking spots
        return this.numParking - this.parkList.size();
    }

    public int numOfOccupiedLots() {
        return this.parkList.size();
    }

    public void addVehicle(Vehicle vehicle) {           //adding a vehicle method
        if (parkList.size() < numParking) {
            parkList.add(vehicle);

        } else {
            System.out.println("No More Space in the list");            //when arraylist is full, this is displayed
        }
    }

    public void deleteVehicle(String iDplate) {             //deleting a vehicle
        for (int i = 0; i < parkList.size(); i++) {
            if (parkList.get(i).getIDplate().equals(iDplate)) {
                System.out.println("Vehicle type left: " + parkList.get(i).getType());
                parkList.remove(i);
            } else {                                                                        // when the Entered Id doesnot match with the list
                System.out.println("The car is not listed in our car park.");
            }
        }
    }

    public void searchVehicle(int day, int month, int year) {           //Searching for a all vehicles at a specific date
        for (int i = 0; i < parkList.size(); i++) {
            if (parkList.get(i).getDuration().getDay() == day && parkList.get(i).getDuration().getYear() == year && parkList.get(i).getDuration().getMonth() == month) {
                System.out.println( "Vehicle List: " + parkList.get(i).getIDplate());

            } else if (parkList.get(i).getDuration().getDay() != day || parkList.get(i).getDuration().getMonth() != month ||parkList.get(i).getDuration().getYear() != year){
                System.out.println("No vehicles were parked in that day");          //when the entered date returns no result
            }
        }
    }

    public void printVehicleList() {                        //print all vehicles added to the arraylist
        for (int i = 0; i < parkList.size(); i++) {
            if (parkList.get(i).getType().equals("Car")) {
                System.out.println("Vehicle Type = Car, ID plate = "
                        + parkList.get(i).getIDplate() + " Entry Time = "
                        + parkList.get(i).getDuration());
            } else if (parkList.get(i).getType().equals("Van")) {
                System.out.println("Vehicle Type = Van, ID plate = "
                        + parkList.get(i).getIDplate() + " Entry Time = "
                        + parkList.get(i).getDuration());
            } else if (parkList.get(i).getType().equals("Motorbike")) {
                System.out.println("Vehicle Type = Motorbike, ID plate = "
                        + parkList.get(i).getIDplate() + " Entry Time = "
                        + parkList.get(i).getDuration());
            }
        }

    }
    public void minMax(){                                   //the longest and the most recent vehicle parked
        System.out.println("The most recent vehicle: " + parkList.get(0).getIDplate() + 
                ", Vehicle Type = " + parkList.get(0).getType() + 
                ", Entry Date: " + parkList.get(0).getDuration() );
        int min = parkList.size()-1;
        System.out.println("The Vehicle that stayed longest: " + parkList.get(min).getIDplate() + 
                ", Vehicle Type = " + parkList.get(min).getType() + ", Entry Date: " + parkList.get(min).getDuration());
        
    }

    public void percentageVehicle() {               //calculating the percentage of vehicle
        double tmbike = 0;
        double tvan = 0;
        double tcar = 0;

        for (int i = 0; i < parkList.size(); i++) {
            if (parkList.get(i).getType().equals("Car")) {
                tcar = tcar + 1;
            } else if (parkList.get(i).getType().equals("Van")) {
                tvan = tvan + 1;
            } else if (parkList.get(i).getType().equals("Motorbike")) {
                tmbike = tmbike + 1;
            }

        }
        double total = tcar + tvan + tmbike;
        double percentageCar = (tcar / total) * 100;
        double percentageVan = (tvan / total) * 100;
        double percentageMBike = (tmbike / total) * 100;

        System.out.println("Percentage of Car: " + percentageCar);
        System.out.println("Percentage of Van: " + percentageVan);
        System.out.println("Percentage of MotorBike: " + percentageMBike);

    }


    public boolean runMenu() {                  //runs menu
        boolean exit = false;

        System.out.println("WELCOME TO WESTMINSTER CAR PARK!");
        System.out.println("1) To Park A Vehicle");
        System.out.println("2) To Leave The Parking Lot");
        System.out.println("3) To print All Vehicle List");
        System.out.println("4) Statistics of Vehicle in the Car Park");
        System.out.println("5) Find Vehicles at a Specified Date");
        System.out.println("6) Exit ");

        Scanner s = new Scanner(System.in);
        int choice = s.nextInt();

        switch (choice) {
            case 1:
                System.out.println("1) Car");
                System.out.println("2) Van");
                System.out.println("3) Motorbike");

                int choice2 = s.nextInt();
                s.nextLine();

                System.out.println("Enter Vehicle ID Plate:");
                String IDplate = s.next();
                System.out.println("Enter Vehicle Brand:");
                String Brand = s.next();
                System.out.println("Enter Date: ");
                System.out.println("Enter Day ");
                int day = s.nextInt();
                System.out.println("Enter Month");
                int month = s.nextInt();
                System.out.println("Enter Year");
                int year = s.nextInt();
                System.out.println("Enter Time");
                System.out.println("Enter Hours ");
                int hours = s.nextInt();
                System.out.println("Enter Minutes");
                int mins = s.nextInt();
                DateTime dt = new DateTime(day, month, year, hours, mins);

                switch (choice2) {
                    case 1:
                        //CAR

                        System.out.println("Enter Car Colour: ");
                        String Colour = s.next();
                        System.out.println("Enter Number of Doors: ");
                        int numDoors = s.nextInt();
                        Car c = new Car(IDplate, Brand, Colour, numDoors, dt);
                        this.addVehicle(c);

                        System.out.println("Number of Available Lots: " + this.numOfAvailableLots());

                        break;

                    case 2:
                        //VAN

                        System.out.println("Enter Volume Of Cargo: ");
                        double VolmOfCargo = s.nextDouble();
                        Van v = new Van(IDplate, Brand, VolmOfCargo, dt);
                        this.addVehicle(v);
                        this.addVehicle(v);
                        System.out.println("Number of Available Lots: " + this.numOfAvailableLots());
                        break;

                    case 3:
                        //MOTORBIKE

                        System.out.println("Enter EngSize: ");
                        int engSize = s.nextInt();
                        Motorbike m = new Motorbike(IDplate, Brand, engSize, dt);
                        this.addVehicle(m);
                        System.out.println("Number of Available Lots: " + this.numOfAvailableLots());
                        break;

                }
                break;

            case 2:
                System.out.println("Enter IDplate to delete Vehicle: ");
                String Idplate = s.next();
                this.deleteVehicle(Idplate);

                break;

            case 3:
                Collections.sort(parkList);
                this.printVehicleList();

                break;
            case 4:
                this.percentageVehicle();
                this.minMax();

                break;
            case 5:
                System.out.println("Enter day: ");
                day = s.nextInt();
                System.out.println("Enter Month: ");
                month = s.nextInt();
                System.out.println("Enter Year: ");
                year = s.nextInt();
                this.searchVehicle(day, month, year);
                break;
            case 6:
                exit = true;
                break;

        }
        return exit;
    }

}
