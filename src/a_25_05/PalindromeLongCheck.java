package a_25_05;

import java.util.Scanner;

public class PalindromeLongCheck {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input the number to test: ");
        long number = scanner.nextLong();

        if (checkPalindromeWArray(number)) System.out.println("WithArray: The number is a palindrome");
        else System.out.println("WithArray: The number is NOT a palindrome");

        if (checkPalindromeNoArray(number)) System.out.println("NoArray: The number is a palindrome");
        else System.out.println("NoArray: The number is NOT a palindrome");

    }

    static boolean checkPalindromeWArray(long number) {

        boolean isPalindrome = true; //start from the assumption that it's a palindrome
        Long longDigit; //I have to get the lsat digit as long, then convert it to integer
        int[] digits = new int[20];
        int i = 0; // index


        while (number > 0) {
            longDigit = number % 10;
            digits[i++] = longDigit.intValue(); //I had to use this conversion, simply casting to int gave me weird results
            number = number / 10;
        }

        for (int j = 0; j < i / 2; j++)
            if (digits[j] != digits[i - j - 1]) {
                isPalindrome = false;
                break;
            }

        return isPalindrome;
    }

    static boolean checkPalindrome(long number) {
        long numberCopy = number;
        long reverse;

        while (number != 0) {
            reverse = number % 10;
            number = number / 10;
        }
        return numberCopy == reverse;
    }


    static boolean checkPalindromeNoArray(long number) {

        long invertedNum = 0;
        long localNumber = number;

        while (localNumber != 0) {
            invertedNum = invertedNum * 10 + localNumber % 10;
            localNumber /= 10;
        }

        return invertedNum == number;

    }

}
