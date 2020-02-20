package basics;

import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Type a number: ");
        int number = in.nextInt();

        int count = 0;
        for (int x = 1; x <= number; x++) {
            count = 0;

            for (int y = 1; y <= x; y++) {
                if (x % y == 0) {
                    count++;
                }
            }

            if (count == 2) {
                System.out.println(x);
            }
        }
    }
}