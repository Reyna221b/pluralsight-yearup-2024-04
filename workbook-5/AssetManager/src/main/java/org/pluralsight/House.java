package org.pluralsight;

public class House extends Asset
{

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, double originalCost, String dateAcquired, String address, int condition, int lotSize, int squareFoot)
    {
        super(description, originalCost, dateAcquired);
        this.address = address;
        this.condition = condition;
        this.lotSize = lotSize;
        this.squareFoot = squareFoot;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public int getLotSize()
    {
        return lotSize;
    }

    public void setLotSize(int lotSize)
    {
        this.lotSize = lotSize;
    }

    public int getSquareFoot()
    {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot)
    {
        this.squareFoot = squareFoot;
    }

    public int getCondition()
    {
        return condition;
    }

    public void setCondition(int condition)
    {
        this.condition = condition;
    }

    @Override
    public double getValue()
    {
        double excellent = 180.00;
        double good = 130.00;
        double fair = 90.00;
        double poor = 80.00;
        double cents = .25;
        double value= 0.0;

        switch (condition){
            case 1:
                value = (excellent * squareFoot) + (cents * lotSize);
                break;
            case 2:
                value = (good * squareFoot) + (cents * lotSize);
                break;
            case 3:
                value = (fair * squareFoot) + (cents * lotSize);
                break;
            case 4:
                value = (poor * squareFoot) + (cents * lotSize);
                break;

        }
        return value;
    }
}
