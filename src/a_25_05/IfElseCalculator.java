package a_25_05;

import java.util.Scanner;

public class IfElseCalculator {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Insert first number: ");
        int n1 = scanner.nextInt();
        System.out.println("Insert second number: ");
        int n2 = scanner.nextInt();

        System.out.println("What is the desired operation: ");
        String operation = scanner.next();

        if (operation.equals("+")) System.out.println("Addition:" + n1 + "+" + n2 + "=" + (n1+n2));
        else if (operation.equals("-")) System.out.println("Subtraction:" + n1 + "-" + n2 + "=" + (n1-n2));
        else if (operation.equals("*")) System.out.println("Multiplication:" + n1 + "*" + n2 + "=" + (n1*n2));
        else if (operation.equals("/")) System.out.println("Division:" + n1 + "/" + n2 + "=" + (n1/n2) + ", remainder = " + (n1%n2));
        else System.out.println("Operation not recognized.");
    }

}