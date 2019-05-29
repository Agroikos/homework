package a_25_05;

import java.util.Scanner;

public class InfiniteLoopSwitchCalculator {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);


        while (true) {

            System.out.println("Insert first number: ");
            int n1 = scanner.nextInt();
            System.out.println("Insert second number: ");
            int n2 = scanner.nextInt();

            System.out.println("What is the desired operation (type 0 to quit): ");
            String operation = scanner.next();

            //if (operation.equals("0")) break;

            switch (operation) {
                case "0": return;
                case "+":
                    System.out.println("Addition:" + n1 + "+" + n2 + "=" + (n1 + n2));
                    break;
                case "-":
                    System.out.println("Subtraction:" + n1 + "-" + n2 + "=" + (n1 - n2));
                    break;
                case "*":
                    System.out.println("Multiplication:" + n1 + "*" + n2 + "=" + (n1 * n2));
                    break;
                case "/":
                    System.out.println("Division:" + n1 + "/" + n2 + "=" + (n1 / n2) + ", remainder = " + (n1 % n2));
                    break;
                default:
                    System.out.println("Operation not recognized.");
            }

            System.out.println();

        }
    }

}
