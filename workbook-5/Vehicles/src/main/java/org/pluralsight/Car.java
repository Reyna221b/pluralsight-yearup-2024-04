package org.pluralsight;

public class Car extends Vehicles
{
    private String model;

    public Car (String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity, boolean isElectric)
    {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity, isElectric);
    }
}
