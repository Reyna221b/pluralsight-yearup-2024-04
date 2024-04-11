package com.pluralsight;

public class MathApp {
    public static void main(String[] args) {
        // find all 7 questions in your workbook on page 
        question1();
        question2();
        question3();
        question4();
        question5();
        question6();
        question7();

    }

    // write ONLY code for QUESTION 1 in this function
    public static void question1() {
        // Question 1:
        // declare variables here

        double bobSalary = 160023.34;
        double garySalary = 160011;
        double highestSalary;


        // code the logic to the problem here
        highestSalary = Math.max(bobSalary, garySalary);


        // use System.out.println() to display results
        System.out.println();
        System.out.println("Question 1: ");
        System.out.println("The hightest salary is " + highestSalary);
    }


    // write ONLY code for QUESTION 2 in this function
    public static void question2() {
        // Question 2:
        // declare variables here
        double carPrice = 63025;
        double truckPrice = 89342.98;
        double lowestPrice;

        // code the logic to the problem here

        lowestPrice = Math.min(carPrice, truckPrice);


        // use System.out.println() to display results
        System.out.println();
        System.out.println("Question 2: ");
        System.out.println("The lowest price between " + carPrice + " and " + truckPrice + " is " + lowestPrice);
    }


    // write ONLY code for QUESTION 3 in this function
    public static void question3() {
        // Question 3:
        // declare variables here
        double radius = 7.25;
        double areaOfCircle;


        // code the logic to the problem here
        areaOfCircle = Math.PI * (radius * radius);

        // use System.out.println() to display results
        System.out.println();
        System.out.println("Question 3: ");
        System.out.println("The area of the circle with a radius of " + radius + " is " + areaOfCircle);
    }


    // write ONLY code for QUESTION 4 in this function
    public static void question4() {
        // Question 4:
        // declare variables here
        double numOfSquareRoot = 5.0;
        double totalOfSquareRoot;


        // code the logic to the problem here

        totalOfSquareRoot = Math.sqrt(numOfSquareRoot);

        // use System.out.println() to display results

        System.out.println();
        System.out.println("Question 4: ");
        System.out.println("The square root of " + numOfSquareRoot + " is " + totalOfSquareRoot);
    }


    // write ONLY code for QUESTION 5 in this function
    public static void question5() {
        // Question 5:
        // declare variables here
        double pointA1 = 5;
        double pointB1 = 10;
        double pointA2 = 85;
        double pointB2 = 50;
        double widthOfA1A2;
        double heightOfB1B2;
        double pointC;

        // code the logic to the problem here
        widthOfA1A2 = pointA2 - pointA1;
        heightOfB1B2 = pointB2 - pointB1;
        pointC = Math.pow(widthOfA1A2, 2) + Math.pow(heightOfB1B2, 2);
        pointC = Math.sqrt(pointC);

        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
        System.out.println();
        System.out.println("Question 5: ");
        System.out.println("The distance between the two points is " + pointC);

    }


    // write ONLY code for QUESTION 6 in this function
    public static void question6() {
        // Question 6:
        // declare variables here\

        double variable = -3.8;
        double absoluteValueVar;

        // code the logic to the problem here
        absoluteValueVar = Math.abs(variable);


        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
        System.out.println();
        System.out.println("Question 6: ");
        System.out.println("The absolute value of " + variable + " is " + absoluteValueVar);
    }


    // write ONLY code for QUESTION 7 in this function
    public static void question7() {
        // Question 7:
        // declare variables here
        double randomNum;


        // code the logic to the problem here
        randomNum = Math.random();


        // use System.out.println() to display results
        // ex: System.out.println("The answer is " + answer);
        System.out.println();
        System.out.println("Question 7: ");
        System.out.println("Random number between 0-    1 is: " + randomNum);
    }
}