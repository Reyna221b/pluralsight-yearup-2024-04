package org.pluralsight;



public class Vehicle extends Asset
{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, double originalCost, String dateAcquired, String makeModel, int year, int odometer)
    {
        super(description, originalCost, dateAcquired);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public int getOdometer()
    {
        return odometer;
    }

    public void setOdometer(int odometer)
    {
        this.odometer = odometer;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public String getMakeModel()
    {
        return makeModel;
    }

    public void setMakeModel(String makeModel)
    {
        this.makeModel = makeModel;
    }


    @Override
    public double getValue(){
        double value;

        int rate = 2024 - year ;
        if(rate <= 3){
            value = getOriginalCost() * Math.pow((1 - .03),rate);
        }
        else if(rate <= 6){
            value = getOriginalCost() * Math.pow((1 -.06),rate);
        }
        else if(rate <= 10){
            value = getOriginalCost() * Math.pow((1 -.08),rate);
        }
        else {
            value = 1000.00;
        }

        if(odometer > 100000) {
                String[]parts = makeModel.split(" ");
                String make = parts[0];
            if (make.equalsIgnoreCase("honda") ||
                    make.equalsIgnoreCase("toyota")) {
                value -= (value * 0.25);

            }
        }

        return value;
    }
}
