/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testdowhile;

import java.util.Scanner;

/**
 *
 * @author WADA
 */
public class TestPrimeNumber {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a numer ");

        int input = scanner.nextInt();
        int count = 0;

        for (int i = 1; i <= input; i++) { // input = 6

            if (input % i == 0) {
                count += 1;    // count =0+1 = 1 +1=2+1=3+1=4 
            }
        }
        
        if(count == 2 ){
            System.out.println(input+" is Prime ");
        }
        else{
         System.out.println(input+" is not Prime ");
        }

    }

}
