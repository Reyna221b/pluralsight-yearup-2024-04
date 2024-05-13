package org.pluralsight;

public  class Moped extends Vehicles
{

   private boolean requiresHelmet;
   private String licenseType;

    public Moped(String color, int numberOfPassengers, int cargoCapacity, int fuelCapacity, boolean isElectric)
    {
        super(color, numberOfPassengers, cargoCapacity, fuelCapacity, isElectric);
        this.requiresHelmet = requiresHelmet;
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

    public boolean isRequiresHelmet()
    {
        return requiresHelmet;
    }

    public void setRequiresHelmet(boolean requiresHelmet)
    {
        this.requiresHelmet = requiresHelmet;
    }
}
