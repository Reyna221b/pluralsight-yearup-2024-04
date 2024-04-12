package org.pluralsight;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        //declare variables
        String userName;
        float hoursWorked;
        float payRate;
        double grossPay;
        float overtimeHours;
        double overtimePay;

        //gather input
        System.out.print("Please enter your name: ");
        userName = userInput.nextLine();

        System.out.print("Please enter the hours you have worked: ");
        hoursWorked = userInput.nextFloat();

        System.out.print("Please enter your current pay rate: ");
        payRate = userInput.nextFloat();

        //calculate & output
        if (hoursWorked > 40)
        {

            overtimeHours = hoursWorked - 40;
            overtimePay = overtimeHours * (payRate * 1.5);
            grossPay = hoursWorked * payRate;

            grossPay = grossPay + overtimePay;

            System.out.println("\n*************************************************");
            System.out.printf("Employee Name: %s \nHours Worked: %.1f \nOvertime Hours: %.1f \nGross Pay:$ %.2f \n",
                    userName, hoursWorked, overtimeHours, grossPay);
            System.out.println("*************************************************");

        }
        else
        {

            grossPay = hoursWorked * payRate;

            System.out.println("\n*************************************************");
            System.out.printf("Employee Name: %s \nHours Worked: %.1f \nGross Pay:$ %.2f \n",
                    userName, hoursWorked, grossPay);
            System.out.println("*************************************************");

        }

    }
}