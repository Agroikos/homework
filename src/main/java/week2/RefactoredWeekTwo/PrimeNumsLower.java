package week2.RefactoredWeekTwo;

import java.util.Scanner;

public class PrimeNumsLower {

    public static void main(String[] args) {

        System.out.println("Print all primes smaller than number");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Input target number: ");
        int number = scanner.nextInt();

        printPrimes(number);

    }

    static void printPrimes (int number) {


        System.out.println("All primes smaller than " + number + ":");

        int k=0;
        for (int i=2; i<=number; i++) {
            if (checkPrime(i)) {
                System.out.print(i + " ");
                k++;
                if ((k%10 == 0) && k!=0) System.out.println();
            }
        }
    }

    public static boolean checkPrime(int p) {
        boolean isPrime = true;

        if (p==0 || p==1) return false;

        int index = 2;

        while (index <= p/2) {
            if (p % index == 0) {
                isPrime = false;
                break;
            }
            index++;
        }

        return isPrime;
    }

}
