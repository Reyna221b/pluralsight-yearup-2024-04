package org.pluralsight;

public class Hotel
{
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedRooms;


    public Hotel(String name, int numberOfSuites, int numberOfRooms)
    {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
    }

    public Hotel(String name, int bookedRooms, int bookedSuites, int numberOfRooms, int numberOfSuites)
    {
        this.name = name;
        this.bookedRooms = bookedRooms;
        this.bookedSuites = bookedSuites;
        this.numberOfRooms = numberOfRooms;
        this.numberOfSuites = numberOfSuites;
    }

    public boolean bookRoom (int numberOfRooms, boolean isSuite)
    {
        if(isSuite) {
            if (getAvailableSuites() >= numberOfRooms) {
                bookedSuites += numberOfRooms;
                return true;
            } else {
                return false;
            }
        }
        else
        {
            if (getAvailableRooms() >= numberOfRooms) {
                bookedRooms += numberOfRooms;
                return true;
            } else {
                return false;
            }

        }

    }

    public int getAvailableSuites(){
        return numberOfSuites - bookedSuites;
    }
    public int getAvailableRooms(){
        return numberOfRooms - bookedRooms;
    }
}
