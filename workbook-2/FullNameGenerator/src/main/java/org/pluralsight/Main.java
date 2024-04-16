package org.pluralsight;

import java.util.Scanner;

public class Main
{
    public static Scanner userInput = new Scanner(System.in);
    public static void main(String[] args)
    {


        String firstName;
        String middleName;
        String lastName;
        String suffix;

        System.out.println("Please enter your name: \n");
        System.out.print("First name: ");
        firstName = userInput.nextLine().trim();

        System.out.print("Middle name: ");
        middleName = userInput.nextLine().strip();

        System.out.print("Last name: ");
        lastName = userInput.nextLine().trim();

        System.out.print("Suffix: ");
        suffix = userInput.nextLine().trim();

        formattedName(firstName,middleName,lastName,suffix);

    }

    public static void formattedName(String first, String middle, String last, String suf)
    {

        if (!middle.isEmpty()) {
            if(!suf.isEmpty()) {
                System.out.printf("\nFull name: %s %s. %s, %s", first, middle, last, suf);
                return;
            }
            System.out.printf("\nFull name: %s %s. %s", first, middle, last);
            return;
        } else if (!suf.isEmpty()) {
            System.out.printf("\nFull name: %s %s, %s", first, last, suf);
            return;
        }

        System.out.printf("Full name: %s %s", first, last);
    }
}