package org.pluralsight;

public class Asset
{
    private String description;
    private String dateAcquired;
    private double originalCost;

    public Asset(String description, double originalCost, String dateAcquired)
    {
        this.description = description;
        this.originalCost = originalCost;
        this.dateAcquired = dateAcquired;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDateAcquired()
    {
        return dateAcquired;
    }

    public void setDateAcquired(String dateAcquired)
    {
        this.dateAcquired = dateAcquired;
    }

    public double getOriginalCost()
    {
        return originalCost;
    }

    public void setOriginalCost(double originalCost)
    {
        this.originalCost = originalCost;
    }

    public double getValue(){

        return originalCost;
    }
}
