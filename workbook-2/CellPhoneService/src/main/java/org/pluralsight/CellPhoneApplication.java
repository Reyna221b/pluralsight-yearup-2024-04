package org.pluralsight;

import java.util.Scanner;

public class CellPhoneApplication
{
    private static Scanner userInput = new Scanner(System.in);

    public static void main(String[] args)
    {
       CellPhone phoneUser = register();
       infoDisplay(phoneUser);
    }

    public static CellPhone register() {
        CellPhone phoneUser = new CellPhone();
        int serialNum;
        String phoneModel;
        String phoneCarrier;
        String phoneNum;
        String ownerName;

        System.out.print("What is the serial number? ");
        serialNum = userInput.nextInt();
        userInput.nextLine();//clears memory stream
        System.out.print("\nWhat model is the phone? ");
        phoneModel = userInput.nextLine();
        System.out.print("\nWho is your carrier? ");
        phoneCarrier = userInput.nextLine();
        System.out.print("\nWhat is the phone number? ");
        phoneNum = userInput.nextLine();
        System.out.print("\nWho is the owner of this phone? ");
        ownerName = userInput.nextLine();

        phoneUser.setSerialNumber(serialNum);
        phoneUser.setModel(phoneModel);
        phoneUser.setCarrier(phoneCarrier);
        phoneUser.setPhoneNumber(phoneNum);
        phoneUser.setOwner(ownerName);

        return phoneUser;
    }

    public static void infoDisplay(CellPhone user)
    {
        System.out.println();
        System.out.printf("Phone Info:\nSerial Number: %d\nPhone Model: %s\nPhone Carrier: %s\n" +
                "Phone Number: %s\nPhone owner: %s",
                user.getSerialNumber(),user.getModel(),user.getCarrier(),
                user.getPhoneNumber(),user.getOwner());
    }
}