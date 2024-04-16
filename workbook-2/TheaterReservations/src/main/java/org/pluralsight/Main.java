package org.pluralsight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main
{
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        String userName;
        String ticketDateInput;
        int numOfTickets;
        DateTimeFormatter ticketDateFormat;
        LocalDate ticketDate;

        System.out.print("Please enter your name: ");
        userName = userInput.nextLine().strip();
        String[] nameParts = userName.split(" ");

        System.out.print("What date will you be coming (MM/dd/yyyy): ");
        ticketDateInput = userInput.nextLine();
        ticketDateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        ticketDate = LocalDate.parse(ticketDateInput,ticketDateFormat);

        System.out.print("How many tickets would you like? ");
        numOfTickets = userInput.nextInt();

        if(numOfTickets < 2){


            System.out.printf("\n%d ticket reserved for %s. %s",numOfTickets );


        }




        System.out.printf("\nFull name: %s %s. %s",numOfTickets );
    }
}