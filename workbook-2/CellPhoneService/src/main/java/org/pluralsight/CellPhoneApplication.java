package org.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
       CellPhone phoneUser = register();
        display(phoneUser);

       CellPhone phoneUser2 = register();

       display(phoneUser2);

       phoneUser.dial(phoneUser2.getPhoneNumber());
       phoneUser2.dial(phoneUser.getPhoneNumber());


    }

    public static CellPhone register() {
        CellPhone phoneUser = new CellPhone();
        int serialNum;
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

        System.out.printf("%s's Phone Info :\nSerial Number: %d\nPhone Model: %s\nPhone Carrier: %s\n" +
                "Phone Number: %s\n",
                user.getOwner(),user.getSerialNumber(),user.getModel(),
                user.getCarrier(),
                user.getPhoneNumber());
    }

    /*public static void display(CellPhone phone)
    {
        System.out.println("Phone # only: " + phone.getPhoneNumber());
    }*/
}