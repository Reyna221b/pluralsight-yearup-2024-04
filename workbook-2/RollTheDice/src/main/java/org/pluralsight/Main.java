package org.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        Dice dice = new Dice();
        int roll1, roll2;
        int twoCounter = 0;
        int fourCounter = 0 ;
        int sixCounter = 0;
        int sevenCounter = 0;

        for(int i = 1; i <= 20; i++){

            roll1 = dice.roll();
            roll2 = dice.roll();
            int sum = roll1 + roll2;
            System.out.printf("roll %d: %d - %d  Sum: %d\n", i, roll1, roll2, sum );

            switch(sum){
                case(2):
                    twoCounter++;
                    continue;
                case(4):
                    fourCounter++;
                    continue;
                case(6):
                    sixCounter++;
                    continue;
                case(7):
                    sevenCounter++;
                    continue;
            }

        }
        System.out.printf("2 counter: %d\n4 counter: %d\n6 counter: %d\n7 counter: %d",
                twoCounter, fourCounter, sixCounter, sevenCounter);
    }

}