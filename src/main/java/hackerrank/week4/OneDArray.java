package hackerrank.week4;

import java.util.ArrayList;
import java.util.Scanner;

public class OneDArray {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Query[] myArray = new Query[n];

        for (int i = 0; i < n; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");

            int q = Integer.parseInt(arrRowItems[0]);
            myArray[i] = new Query(q);
            myArray[i].setLeap(Integer.parseInt(arrRowItems[1]));

            arrRowItems = scanner.nextLine().split(" ");

            for(String t : arrRowItems) {myArray[i].array.add(Integer.parseInt(t));}
        }

        for (int i = 0; i < n; i++) {
            if (isSolvable(myArray[i].getLeap(),myArray[i].getArray(),0)) System.out.println("YES");
            else System.out.println("NO");
        }

        scanner.close();
    }


    private static boolean isSolvable(int m,   ArrayList<Integer> arr, int i) {
        if (i < 0 || arr.get(i) == 1) return false;
        if ((i == arr.size() - 1) || i + m > arr.size() - 1) return true;

        arr.set(i,1);
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }
}

class Query {
    int n;
    int leap;
    ArrayList<Integer> array;

    Query (int n) {
        this.n = n;
        array = new ArrayList<>();
    }


    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getLeap() {
        return leap;
    }

    public void setLeap(int leap) {
        this.leap = leap;
    }

    public ArrayList<Integer> getArray() {
        return array;
    }

    public void setArray(ArrayList<Integer> array) {
        this.array = array;
    }
}