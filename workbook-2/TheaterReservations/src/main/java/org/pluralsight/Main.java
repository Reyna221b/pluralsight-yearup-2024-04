package org.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        String name;
        String date;
        int tickets;

        name = getName();//returns the name exactly as it needs to be displayed
        date = getDate();//returns a string
        tickets = getTickets();
        reservationDisplay(tickets,name,date);
    }

    public static String getName() {
        String userName;

        System.out.print("Please enter your name: ");
        userName = userInput.nextLine().strip();
        String[] nameParts = userName.split(" ");
        String firstName = nameParts[0].strip();
        String lastname = nameParts[1].strip();

        return lastname + ", " + firstName;
    }

    public static String getDate() {
        String ticketDateInput;
        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        ticketDateInput = userInput.nextLine();
        DateTimeFormatter ticketDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ticketDate = LocalDate.parse(ticketDateInput,ticketDateFormat);

        return ticketDate.toString();
    }
    
    public static int getTickets(){
        int numOfTickets;
        System.out.print("How many tickets would you like? ");
        numOfTickets = userInput.nextInt();

        return numOfTickets;
    }

    public static void reservationDisplay (int ticketNum, String nameDisplay, String dateDisplay){
        if (ticketNum < 2){
            System.out.printf("%d ticket reserved for %s under %s",ticketNum,dateDisplay,nameDisplay);
        }
        else{
            System.out.printf("%d tickets reserved for %s under %s",ticketNum,dateDisplay,nameDisplay);
        }
    }

}