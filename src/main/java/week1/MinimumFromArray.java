package week1;

import java.util.Scanner;

public class MinimumFromArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //read array length
        System.out.print("Input array length: ");
        int arrayLength = scanner.nextInt();

        int[] myArray = new int[arrayLength];

        //read array from keyboard
        for (int i=0; i<arrayLength; i++) {
            System.out.println("input element " + i + " :");
            myArray[i] = scanner.nextInt();
        }

        System.out.println("The minimum element in the array (with for) is: " + getMinFor(myArray, arrayLength));
        System.out.println("The minimum element in the array (with forEach) is: " + getMinForEach(myArray));

    }

    static int getMinFor (int[] myArray, int len) {

        int min = myArray[0];

        for (int i=1; i<len; i++)
            if (myArray[i] < min) min = myArray[i];

        return min;
    }

    static int getMinForEach (int[] myArray) {

        int min = myArray[0];

        for (int i : myArray)
            if (i < min) min = i;

        return min;
    }
}
