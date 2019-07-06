package week2.RefactoredWeekTwo;

import java.util.Scanner;

public class MaxDigit {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input number: ");
        long num = scanner.nextLong();

        System.out.println("the maximum digit from " + num + " is: " + getMaxDigit(num));
    }

    /**
     * returns the maximum digit from an integer
     */
    public static int getMaxDigit (long num) {

        int maxDigit=0, lastDigit=0;

        while (num != 0) {

            //get last digit
            lastDigit = (int) num % 10;

            //compare to maxDigit
            if (lastDigit > maxDigit) maxDigit = lastDigit;

            num = num / 10;
        }

        return maxDigit;
    }
}
