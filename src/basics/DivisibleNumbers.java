package basics;

import java.util.Scanner;

public class DivisibleNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Type the first number: ");
        int first = in.nextInt();
        System.out.print("Type the last number: ");
        int last = in.nextInt();

        System.out.print("Type the divisible number: ");
        int div = in.nextInt();

        for (int x = first; x <= last; x++) {
            if (x % div == 0) {
                System.out.println(x);
            }
        }
    }
}
