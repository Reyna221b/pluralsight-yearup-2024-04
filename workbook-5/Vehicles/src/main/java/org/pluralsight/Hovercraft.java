package org.pluralsight;

public class Hovercraft extends Vehicles
{
    private boolean requiresLifeJacket;
    private boolean requiresHelmet;

    public Hovercraft(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity, boolean isElectric)
    {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity, isElectric);
        this.requiresHelmet = requiresHelmet;
        this.requiresLifeJacket = requiresLifeJacket;
    }

}
