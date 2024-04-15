package org.pluralsight;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {

        Scanner userInput = new Scanner(System.in);
        String nameInput;
        String firstName;
        String middleName;
        String lastName;

        System.out.print("Please enter your full name: ");
        nameInput = userInput.nextLine().strip();
        String[] fullName = nameInput.split(" ");


        if (fullName.length > 2){
            firstName = fullName[0];
            middleName = fullName[1];
            lastName= fullName[2];

            System.out.printf("First name: %s\nMiddle name: %s\nLast name: %s",firstName, middleName, lastName);

        }
        else {
            firstName = fullName[0];
            lastName= fullName[1];

            System.out.printf("First name: %s\nLast name: %s\n", firstName, lastName);

        }
    }
}