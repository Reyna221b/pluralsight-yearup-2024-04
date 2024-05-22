package org.pluralsight;

public abstract class FixedAsset implements Valuable
{
    private String name;
    private double marketValue;

    public FixedAsset(double marketValue, String name)
    {
        this.marketValue = marketValue;
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getMarketValue()
    {
        return marketValue;
    }

    public void setMarketValue(double marketValue)
    {
        this.marketValue = marketValue;
    }

    public abstract double getValue();

}
