package com.pluralsight;

import java.util.Scanner;

public class Main
{
    static final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
        // create an array of vehicles here

        Vehicle[] vehicles = {
                new Vehicle(11111111,"Audi r8", "black", "20000", 68000),
                new Vehicle(22222222,"Bmw M4", "blue", "1000",70000),
                new Vehicle(33333333,"Porsche 911", "grey", "3000",58000),
                new Vehicle(44444444,"Toyota supra", "yellow","51340", 42000),
                new Vehicle(55555555,"Mazda Miata", "red", "100230", 10200)

        };

        int choice = 0;
        while(choice != 6)
        {
            // print the home screen
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println();
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");
            System.out.println();
            System.out.println("Enter your command");
            choice = Integer.parseInt(userInput.nextLine());

            switch(choice)
            {
                case 1:
                    // call the list all vehicles (pass the array)
                    listAllVehicles(vehicles);
                    break;
                case 2:
                    // call the search by make/model
                    searchByMakeModel(vehicles);
                    break;
                case 3:
                    // call the search by price
                    searchByPrice(vehicles);
                    break;
                case 4:
                    // call the search by color
                    searchByColor(vehicles);
                    break;
                case 5:
                    // add a vehicle
                    vehicles = addVehicle(vehicles);
                    break;
                case 6:
                    System.out.println();
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid selection");
                    break;
            }

        }


    }

    public static void listAllVehicles(Vehicle[] vehicles)
    {
        // loop through vehicles and print all
        System.out.println();
        System.out.println("All Vehicles");
        System.out.println("----------------------------------------");

        for (int i = 0; i < vehicles.length; i++) {
            Vehicle v = vehicles[i];
            System.out.printf("%-10d %-15s %-10s %-10s %.2f\n",
                    v.getVehicleId(),v.getMakeModel(),v.getColor(),v.getOdometerReading(), v.getPrice());
        }
    }

    public static void searchByMakeModel(Vehicle[] vehicles)
    {
        // get user search criteria

        // loop through vehicles and print only vehicles that match the search
        System.out.println();
        System.out.println("Search Vehicles by Make/Model");
        System.out.println("----------------------------------------");
        System.out.print("Enter a Make/Model to search: ");
        String searchModel = userInput.nextLine().strip();


        for (int i = 0; i < vehicles.length; i++) {
            Vehicle v = vehicles[i];
            if(v.getMakeModel().equalsIgnoreCase(searchModel))
            {
                System.out.printf("%-10d %-15s %-10s %-10s %.2f\n",
                        v.getVehicleId(),v.getMakeModel(),v.getColor(),v.getOdometerReading(), v.getPrice());
            }
        }
    }

    public static void searchByPrice(Vehicle[] vehicles)
    {
        // get user search criteria

        // loop through vehicles and print only vehicles that match the search
        System.out.println();
        System.out.println("Search Vehicles by price");
        System.out.println("----------------------------------------");
        System.out.print("Enter a Price to search: ");
        double searchPrice = userInput.nextDouble();
        userInput.nextLine();

        for (int i = 0; i < vehicles.length; i++) {
            Vehicle v = vehicles[i];

            if(v.getPrice() == searchPrice ){
                System.out.printf("%-10d %-15s %-10s %-10s %.2f\n",
                        v.getVehicleId(),v.getMakeModel(),v.getColor(),v.getOdometerReading(), v.getPrice());
            }

        }
    }

    public static void searchByColor(Vehicle[] vehicles)
    {
        // get user search criteria

        // loop through vehicles and print only vehicles that match the search
        System.out.println();
        System.out.println("Search Vehicles by Color");
        System.out.println("----------------------------------------");
        System.out.print("Enter a color to search: ");
        String searchColor = userInput.nextLine().strip();


        for (int i = 0; i < vehicles.length; i++) {
            Vehicle v = vehicles[i];
            if(v.getColor().equalsIgnoreCase(searchColor))
            {
                System.out.printf("%-10d %-15s %-10s %-10s %.2f\n",
                        v.getVehicleId(),v.getMakeModel(),v.getColor(),v.getOdometerReading(), v.getPrice());
            }
        }
    }

    // bonus (optional)
    public static Vehicle[] addVehicle(Vehicle[] vehicles)
    {
        //changed the function
        // get user input id, make/model, color, odo, price

        // create a vehicle

        // add it to the inventory

        // hint: you will need to create a new array that is 1 bigger than the old one
        //       then add the new vehicle in the last spot

        System.out.println();
        System.out.println("Add Vehicle");
        System.out.println("----------------------------------------");
        System.out.print("Enter the vehicle ID: ");
        long id = userInput.nextLong();
        userInput.nextLine();
        System.out.print("Enter the Make/Model: ");
        String model = userInput.nextLine().strip();
        System.out.print("Enter the vehicle color: ");
        String color = userInput.nextLine().strip();
        System.out.print("Enter the odometer reading: ");
        String odometer = userInput.nextLine().strip();
        System.out.print("Enter the vehicle price: ");
        double price = userInput.nextDouble();
        userInput.nextLine();

        //create a new vehicle obj to add to the new array
        Vehicle v2 = new Vehicle(id, model,color, odometer, price);
        //new vehicle array
        //for loop to copy old array to new one.
        //set length to one greater than old array to have enough space
        Vehicle[] vehicles2 = new Vehicle[vehicles.length +1];
        for (int i = 0; i < vehicles.length; i++) {
            vehicles2[i] = vehicles[i];
        }
        // added the new object to the new spot
        vehicles2[vehicles.length] = v2;
        //returned the new array so the new information is stored to the original array
        return vehicles2;
    }

}
