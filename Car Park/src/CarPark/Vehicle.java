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
public abstract class Vehicle implements Comparable<Vehicle> {

    protected String IDplate;
    protected String brand;
    protected DateTime duration;

    public Vehicle(String IDplate, String brand) {
        this.IDplate = IDplate;
        this.brand = brand;
    }

    public void setIdplate(String IDplate) {
        this.IDplate = IDplate;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public DateTime getDuration() {
        return duration;
    }

    public void setDuration(DateTime duration) {
        this.duration = duration;
    }

    public String getIDplate() {
        return IDplate;
    }

    public String getBrand() {
        return brand;
    }

    public String toString() {
        return IDplate + "," + brand + ", " + duration;

    }

    public abstract String getType();

    @Override
    public int compareTo(Vehicle other) {
        int returnvalue = 0;

        int year1 = this.getDuration().getYear();
        int year2 = other.getDuration().getYear();
        if (year1 < year2) {
            returnvalue = 1;

        } else if (year1 > year2) {
            returnvalue = -1;

        } else if (year1 == year2) {
            returnvalue = 0;
            int month1 = this.getDuration().getMonth();
            int month2 = other.getDuration().getMonth();
            if (month1 < month2) {
                returnvalue = 1;
            } else if (month1 > month2) {
                returnvalue = -1;
            } else if (month1 == month2) {
                returnvalue = 0;
                int day1 = this.getDuration().getDay();
                int day2 = other.getDuration().getDay();
                if (day1 < day2) {
                    returnvalue = 1;
                } else if (day1 > day2) {
                    returnvalue = -1;
                } else if (day1 == day2) {
                    returnvalue = 0;
                    int hours1 = this.getDuration().getHours();
                    int hours2 = other.getDuration().getHours();
                    if (hours1 < hours2) {
                        returnvalue = 1;
                    } else if (hours1 > hours2) {
                        returnvalue = -1;
                    } else if (hours1 == hours2) {
                        returnvalue = 0;
                        int mins1 = this.getDuration().getMins();
                        int mins2 = other.getDuration().getMins();
                        if (mins1 < mins2) {
                            returnvalue = 1;
                        } else if (mins1 > mins2) {
                            returnvalue = -1;
                        } else if (mins1 == mins2) {
                            returnvalue = 0;

                        }
                    }
                }
                

            }

        }return returnvalue;
    }
}
