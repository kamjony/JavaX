/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CarPark;

public class DateTime {

    private int day;
    private int month;
    private int year;
    private int hours;
    private int mins;

    public DateTime(int day, int month, int year, int hours, int mins) {
        if ((year > 1939) && (year < 2099) && (month > 0) && (month < 13) && (day > 0) && (day < 32) && (hours > 0) && (hours < 24) && (mins > 0) && (mins < 60)) {
            this.day = day;
            this.month = month;
            this.year = year;
            this.hours = hours;
            this.mins = mins;

        } else {
            System.out.println("Not correct date or time");
        }
    }

    public void setDay(int day) {
        if ((day > 0) && (day < 32)) {
            this.day = day;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setMonth(int month) {
        if ((month > 0) && (month < 13)) {
            this.month = month;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setYear(int year) {
        if ((year > 1939) && (year < 2099)) {
            this.year = year;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setHours(int hours) {
        if ((hours > 0) && (hours < 24)) {
            this.hours = hours;
        } else {
            System.out.println("Not correct range");
        }
    }

    public void setMins(int mins) {
        if ((mins > 0) && (mins < 60)) {
            this.mins = mins;
        } else {
            System.out.println("Not correct range");
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public int getHours() {
        return hours;
    }

    public int getMins() {
        return mins;
    }

    public void setDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setTime(int hours, int mins) {
        this.hours = hours;
        this.mins = mins;
    }

    public String getDate() {
        return day + "/" + month + "/" + year;

    }

    public String getTime() {
        return hours + ":" + mins;

    }

    public String getDateTime() {
        return day + "/" + month + "/" + year + " " + "\n" + hours + ":" + mins;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year + " " + "\n" + hours + ":" + mins;

    }

}
