package org.pluralsight;

import java.util.Scanner;

public class UserInterface
{
    private Scanner scanner = new Scanner(System.in);

    public int getHomeScreenChoice()
    {
        System.out.println();
        System.out.println("Home Screen!");
        System.out.println("-".repeat(30));
        System.out.println("1 - Show Available Books");
        System.out.println("2 - Show Checked Out Books");
        System.out.println("3 - Exit");
        System.out.println();
        System.out.print("Enter your choice: ");
        return Integer.parseInt(scanner.nextLine().strip());
    }
}
