package org.pluralsight;

public class Main
{
    public static void main(String[] args)
    {
        Dice dice = new Dice();
        int roll1, roll2;
        int counter2 = 0;
        int counter4 = 0 ;
        int counter6 = 0;
        int counter7 = 0;

        for(int i = 1; i <= 100; i++){

            roll1 = dice.roll();
            roll2 = dice.roll();
            int sum = roll1 + roll2;
            System.out.printf("roll %d: %d - %d  Sum: %d\n", i, roll1, roll2, sum );

            switch(sum){

                case(2):
                    counter2++;
                    continue;
                case(4):
                    counter4++;
                    continue;
                case(6):
                    counter6++;
                    continue;
                case(7):
                    counter7++;
                    continue;
            }

        }
        System.out.printf("2 counter: %d\n4 counter: %d\n6 counter: %d\n7 counter: %d",
                counter2,counter4,counter6,counter7);
    }

}