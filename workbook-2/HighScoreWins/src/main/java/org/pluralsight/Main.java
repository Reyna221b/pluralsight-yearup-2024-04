package org.pluralsight;

import java.util.Scanner;


public class Main
{
    public static void main(String[] args)
    {

        Scanner userInput = new Scanner(System.in);
        String gameInput;
        String homeTeam;
        String visitorTeam;
        int homeScore;
        int visitorScore;
        String winner;

        System.out.print("Please enter a game score: ");
        gameInput = userInput.nextLine();

        //array to split sections [|:]splits multiple parts
        String[] gameParts = gameInput.split("[|:]");

        homeTeam = gameParts[0];
        visitorTeam = gameParts[1];
        homeScore = Integer.parseInt(gameParts[2]);
        visitorScore = Integer.parseInt(gameParts[3]);

        if(homeScore > visitorScore){
            winner = homeTeam;
        }
        else {
            winner = visitorTeam;
        }

        System.out.printf("Winner is: %s!!", winner );


    }
}