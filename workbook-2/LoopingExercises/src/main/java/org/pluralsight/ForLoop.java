package org.pluralsight;

public class ForLoop
{
    public static void main(String[] args) throws InterruptedException
    {
        for(int i = 10; i > 0; i--){

            Thread.sleep(1000);
            System.out.println(i);
            if(i == 1){
                Thread.sleep(1000);
                System.out.println("Launch!");
            }
        }

    }
}
