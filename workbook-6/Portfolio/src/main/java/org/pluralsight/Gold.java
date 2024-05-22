package org.pluralsight;

public class Gold extends FixedAsset
{
    private double weight;

    public Gold(double marketValue, String name, double weight)
    {
        super(marketValue, name);
        this.weight = weight;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    @Override
    public double getValue()
    {
        return weight * getMarketValue();
    }
}
