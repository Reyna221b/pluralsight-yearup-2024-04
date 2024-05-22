package org.pluralsight;

public class Cash extends Asset
{
    public Cash(String description, double originalCost, String dateAcquired)
    {
        super(description, originalCost, dateAcquired);
    }

    @Override
    public double getValue()
    {
        return 0;
    }
}
