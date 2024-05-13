package org.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        Moped slowRide = new Moped("Pink",1,0,0,true);


        Car coolCar = new Car("Red", 4, 4, 60, false);


        SemiTruck semi = new SemiTruck("Blue", 2, 20000, 400, false);


        Hovercraft broomStick = new Hovercraft("Yellow", 6, 1000, 200, true);
        broomStick.setColor("Brown");
        broomStick.setNumberOfPassengers(1);
    }
}