package com.pluralsight;

public class   ExerciseDemo
{
    public static void main(String[] args)
    {
        question1();
        question2();
    }

    public static void question1()
    {
        // calculate the amount of change given after buying chocolate
        //Chocolate cost 2.99 per bar
        // $20 dollars
        // gonna buy 4 bars of chocolate
        // how much change will I get back


        // declare variables
        double chocoBar = 2.99;
        double balance = 20;
        int chocoQuantity = 4;
        double totalCost;
        double change;



        //write the logic
        totalCost = chocoBar * chocoQuantity;
        change = balance - totalCost;

        //display output
        System.out.println();
        System.out.println("Chocolate bar: $ " + chocoBar);
        System.out.println("Quantity: " + chocoQuantity);
        System.out.println("Balance " + balance);
        System.out.println("Amount Paid: $ " + totalCost);
        System.out.println();
        System.out.println("Change " + change);


    }

    public static void question2()
    {
        // calculate the perimeter of a circle
        //for a circle w/ a radius of 12

        //declare variables
        double radius = 12;
        double perimeter;

        //calculate
        perimeter = 2 * Math.PI * radius;

        //output
        System.out.println("The perimeter of a circle with a radius of " + radius + " is " + perimeter);

    }

}

