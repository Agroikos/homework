package week2.refactoredWeekTwo;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input number: ");
        int n = scanner.nextInt();

        System.out.println("The factoral is: " + factorial(n));

    }

    public static int factorial (int n) {
        int factorial = 1;

        for (int i=1; i<=n; i++) factorial *= i;

        return factorial;
    }
}
