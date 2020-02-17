package array;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Counter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ArrayList<Integer> numbers = new ArrayList<>();

        int numbersLimit;

        System.out.print("Enter the size of number list: ");
        numbersLimit = in.nextInt();

        Random generator = new Random();

        System.out.println("The number list is:");

        for (int x = 1; x <= numbersLimit; x++) {
            int number = generator.nextInt(100);
            System.out.print(number);

            if (x < numbersLimit) System.out.print(" - ");

            numbers.add(number);
        }

        System.out.println();
        System.out.println("The number list size is: " + numbers.size());

        int biggest = numbers.get(0);
        int smallest = numbers.get(0);

        for (int x = 0; x < numbersLimit; x++) {
            int number = numbers.get(x);
            if (number > biggest) biggest = number;
            if (number < smallest) smallest = number;
        }

        System.out.println("The biggest number is: " + biggest);
        System.out.println("The smallest number is: " + smallest);
    }
}
