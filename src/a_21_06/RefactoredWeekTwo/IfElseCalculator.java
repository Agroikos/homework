package a_21_06.RefactoredWeekTwo;

import java.util.Scanner;


public class IfElseCalculator {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Insert first number: ");
        int a = scanner.nextInt();
        System.out.println("Insert second number: ");
        int b = scanner.nextInt();

        System.out.println("What is the desired operation: ");
        String operation = scanner.next();

        calculator(a,b,operation);

    }

    public static void calculator (int a, int b, String op) {

        if (op.equals("+")) System.out.println("Addition:" + a + "+" + b + "=" + (a+b));
        else if (op.equals("-")) System.out.println("Subtraction:" + a + "-" + b + "=" + (a-b));
        else if (op.equals("*")) System.out.println("Multiplication:" + a + "*" + b + "=" + (a*b));
        else if (op.equals("/")) System.out.println("Division:" + a + "/" + b + "=" + (a/b) + ", remainder = " + (a%b));
        else System.out.println("Operation not recognized.");

    }

    public static int calculatorWReturn (int a, int b, String op) {

        if (op.equals("+")) {
            System.out.println("Addition:" + a + "+" + b + "=" + (a+b));
            return a+b;
        }
        else if (op.equals("-")) {
            System.out.println("Subtraction:" + a + "-" + b + "=" + (a-b));
            return a-b;
        }

        else if (op.equals("*")) {
            System.out.println("Multiplication:" + a + "*" + b + "=" + (a*b));
            return a*b;
        }
        else if (op.equals("/")) {
            System.out.println("Division:" + a + "/" + b + "=" + (a/b) + ", remainder = " + (a%b));
            return a/b;
        }
        else {
            System.out.println("Operation not recognized.");
            return 0;
        }

    }

}
