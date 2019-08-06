package hackerrank.week4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListImplementation {
    public static void main(String[] args) {
        List<Integer> myList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] arrRowItems = scanner.nextLine().split(" ");

        for(String t : arrRowItems) {myList.add(Integer.parseInt(t));}


        int q = Integer.parseInt(scanner.nextLine()); //number of queries

        for (int i = 0; i < q; i++) {

            String command = scanner.nextLine();

            arrRowItems = scanner.nextLine().split(" ");

            if (command.equals("Insert")) {
                int x = Integer.parseInt(arrRowItems[0]);
                int y = Integer.parseInt(arrRowItems[1]);
                myList.add(x,y);
            }
            else if (command.equals("Delete")) {
                int x = Integer.parseInt(arrRowItems[0]);
                myList.remove(x);
            }

        }

        myList.stream().forEach(t -> System.out.print(t + " "));
    }
}
