package testdowhile;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] numbers = {50, 20, 10, 90, 40, 25, 35, 15, 75};

        System.out.println("Befor Sorting " + Arrays.toString(numbers));

        for (int i = 0; i < numbers.length; i++) {

            for (int j = 0; j < numbers.length - 1 - i; j++) {

                if (numbers[j] > numbers[j + 1]) {

                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }            }
        }
        System.out.println("After Sorting " + Arrays.toString(numbers));

    }

}
