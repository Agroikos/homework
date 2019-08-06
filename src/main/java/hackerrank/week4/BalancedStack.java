package hackerrank.week4;

import java.util.EmptyStackException;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BalancedStack {
    static int iteration = 0;
    public static void main(String[] args) {

        boolean[] isBalancedResults = new boolean[100];
        int number = 0;


        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String expression = scanner.nextLine().trim();
            if (expression.equals("")) break;
            isBalancedResults[number++] = isBalanced(expression);
        }

        for (int i = 0; i < number; i++) {
            System.out.println(isBalancedResults[i]);
        }

        scanner.close();

    }

    private static boolean isBalanced(String expression) {
        Stack<Character> myStack = new Stack<>();
        iteration++;

        //System.out.println("testing new");
        for (int i = 0; i < expression.length(); i++) {

            //System.out.println("testing: " + expression.charAt(i));

            try {
                switch (expression.charAt(i)) {
                    //opening brackets go on the stack
                    case '(':
                        myStack.push('(');
                        break;
                    case '[':
                        myStack.push('[');
                        break;
                    case '{':
                        myStack.push('{');
                        break;

                    //closing brackets get compared to what is popped off the stack
                    case ')':
                        if (!myStack.pop().equals('(')) return false;
                        break;
                    case ']':
                        if (!myStack.pop().equals('[')) return false;
                        break;
                    case '}':
                        if (!myStack.pop().equals('{')) return false;
                        break;
                }
            } catch (EmptyStackException e) {
                return false;
            }
            /*System.out.print("testing : show stack iteration : " + iteration + " ");
            myStack.stream().forEach(t -> System.out.print(t + " "));
            System.out.println();*/
        }
        if (myStack.empty()) return true;
        else return false;
    }
}
