package org.pluralsight;

public class SemiTruck extends Vehicles
{
    private String licenseType;

    public SemiTruck(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity, boolean isElectric)
    {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity, isElectric);
        this.licenseType = licenseType;
    }

    public String getLicenseType()
    {
        return licenseType;
    }

    public void setLicenseType(String licenseType)
    {
        this.licenseType = licenseType;
    }
}
