package guesgame;

import java.util.Scanner;

public class GuesGame {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int randomNumber = (int) (Math.random() * 10);
        //System.out.println(randomNumber);
        int chance = 1;
        while (chance <= 3) {
            System.out.println("Enter ur guese number ");
            int userInput = s.nextInt();
            
            if (randomNumber == userInput) {
                System.out.println("Good Luck");
                break;
            } else {
                System.out.println("Batter luck next Time");
            }
            chance++;
        }        
        System.out.println(randomNumber);

    }

}
