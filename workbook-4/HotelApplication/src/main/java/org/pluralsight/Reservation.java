package org.pluralsight;

public class Reservation
{
    private String roomType;
    private int numberOfNights;
    private boolean isWeekend;

    public Reservation(String roomType, boolean isWeekend, int numberOfNights)
    {
        this.roomType = roomType;
        this.isWeekend = isWeekend;
        this.numberOfNights = numberOfNights;
    }

    public boolean isWeekend()
    {
        return isWeekend;
    }

    public void setIsWeekend(boolean weekend)
    {
        isWeekend = weekend;
    }

    public int getNumberOfNights()
    {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights)
    {
        this.numberOfNights = numberOfNights;
    }

    public String getRoomType()
    {
        return roomType;
    }

    public void setRoomType(String roomType)
    {
        this.roomType = roomType;
    }

    public double getPrice()
    {
        double price = 0;
        double upcharge = .10;
        double kingPrice = 139.00;
        double queenPrice = 124.00;

        if(getRoomType().equalsIgnoreCase("king")){
            if(isWeekend()){
                price =  kingPrice * upcharge;
            }
            price = kingPrice;
        } else if (getRoomType().equalsIgnoreCase("queen")) {
            if(isWeekend()){
                price = queenPrice * upcharge;
            }
            price = queenPrice;

        }
        return price;
    }

    public double getReservationTotal(){
        return getNumberOfNights() * getPrice();
    }
}
