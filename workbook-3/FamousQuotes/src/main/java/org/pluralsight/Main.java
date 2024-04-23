package org.pluralsight;

import java.util.Scanner;

public class Main
{
    static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {
        String [] quotes = {"May the Force be with you - Obi Wan",
                "Do or do not. There is no try. - Yoda",
                "I find your lack of faith disturbing. - Darth Vader",
                "The Force will be with you, always. - Obi-Wan Kenobi",
                "I am your father. - Darth Vader",
                "Fear is the path to the dark side. Fear leads to anger, anger leads to hate, hate leads to suffering.- Yoda",
                "The Force is strong with this one. - Darth Vader",
                "It's a trap! - Admiral Ackbar",
                "I've got a bad feeling about this.- Various characters",
                "Your focus determines your reality.- Qui-Gon Jinn."
        };


        try{

            System.out.print("Please select a number between 1-10: ");
            int input = Integer.parseInt(userInput.nextLine());

            System.out.println("Quote " + input + ": " + quotes[input-1]);
            System.out.println();
        }
        catch (Exception e){
            System.out.println("Your number was out of Range!\n");
        }

        boolean userChoice = true;


        while (userChoice){

            System.out.println("would you like to do:");
            System.out.print("-".repeat(25)+ "\n1 - Select a quote\n2 - Random quote\n3 - Exit\n");
            System.out.print("Enter your choice: ");

            try{
                int choice = Integer.parseInt(userInput.nextLine());
                if(choice == 1) {
                    System.out.print("\nPlease select a number between 1-10: ");
                    int input = Integer.parseInt(userInput.nextLine());
                    System.out.println("Quote " + input + ": " + quotes[input - 1]);
                    System.out.println();
                }
                else if (choice == 2)
                {
                    int random = (int) (Math.random() * 10 + 1);
                    System.out.println("\nQuote: " + quotes[random - 1]);
                    System.out.println();
                }
                else if (choice == 3){
                    System.out.println("\nGoodbye!");
                    userChoice = false;
                }

            }
            catch (Exception e){
                System.out.println("\n------Invalid Selection------\n");
            }
        }


    }
}