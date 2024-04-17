package org.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
       CellPhone phoneUser = register();

       CellPhone phoneUser2 = register();

       display(phoneUser);

       display(phoneUser2);

        //phoneUser 3 user input since it has parameters register function does not work.
        /*int serialNum ;
        String phoneModel;
        String phoneCarrier;
        String phoneNum;
        String ownerName;

       System.out.print("\nWhat is the serial number? ");
        serialNum = userInput.nextInt();
        userInput.nextLine();//clears memory stream
        System.out.print("What model is the phone? ");
        phoneModel = userInput.nextLine();
        System.out.print("Who is your carrier? ");
        phoneCarrier = userInput.nextLine();
        System.out.print("What is the phone number? ");
        phoneNum = userInput.nextLine();
        System.out.print("Who is the owner of this phone? ");
        ownerName = userInput.nextLine();*/

       CellPhone phoneUser3 = new CellPhone(1234565,"IPhone 14","T-Mobile",
               "925-333-3333","Alex");

       display(phoneUser3);

       phoneUser.dial(phoneUser3.getPhoneNumber());
       phoneUser2.dial(phoneUser.getPhoneNumber());
       phoneUser3.dial(phoneUser2);

    }

    public static CellPhone register() {
        CellPhone phoneUser = new CellPhone();
        int serialNum;
        String phoneModel;
        String phoneCarrier;
        String phoneNum;
        String ownerName;

        System.out.println();
        System.out.print("What is the serial number? ");
        serialNum = userInput.nextInt();
        userInput.nextLine();//clears memory stream
        System.out.print("What model is the phone? ");
        phoneModel = userInput.nextLine();
        System.out.print("Who is your carrier? ");
        phoneCarrier = userInput.nextLine();
        System.out.print("What is the phone number? ");
        phoneNum = userInput.nextLine();
        System.out.print("Who is the owner of this phone? ");
        ownerName = userInput.nextLine();



        phoneUser.setSerialNumber(serialNum);
        phoneUser.setModel(phoneModel);
        phoneUser.setCarrier(phoneCarrier);
        phoneUser.setPhoneNumber(phoneNum);
        phoneUser.setOwner(ownerName);

        return phoneUser;
    }


    public static void display(CellPhone user)
    {


        System.out.println("-----------------------------");
        System.out.printf("%s's Phone Info :\nSerial Number: %d\nPhone Model: %s\nPhone Carrier: %s\n" +
                "Phone Number: %s",
                user.getOwner(),user.getSerialNumber(),user.getModel(),
                user.getCarrier(),
                user.getPhoneNumber());
        System.out.println("\n");
    }
}