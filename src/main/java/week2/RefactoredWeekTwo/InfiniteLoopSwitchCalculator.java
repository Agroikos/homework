package week2.RefactoredWeekTwo;

import java.util.Scanner;

public class InfiniteLoopSwitchCalculator {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Insert first number: ");
            int a = scanner.nextInt();
            System.out.println("Insert second number: ");
            int b = scanner.nextInt();

            System.out.println("What is the desired operation (type 0 to quit): ");
            String operation = scanner.next();

            if (operation.equals("0")) break;

            calculator(a,b,operation);

            System.out.println();

        }

    }


    public static void calculator (int a, int b, String op) {
        switch (op) {
            case "+":
                System.out.println("Addition:" + a + "+" + b + "=" + (a + b));
                break;
            case "-":
                System.out.println("Subtraction:" + a + "-" + b + "=" + (a - b));
                break;
            case "*":
                System.out.println("Multiplication:" + a + "*" + b + "=" + (a * b));
                break;
            case "/":
                System.out.println("Division:" + a + "/" + b + "=" + (a / b) + ", remainder = " + (a % b));
                break;
            default:
                System.out.println("Operation not recognized.");
        }

    }
}
