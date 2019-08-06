package hackerrank.week4;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = scanner.next();
            pair_right[i] = scanner.next();
        }

        Set<String> myPair = new HashSet<>();

        for (int i = 0; i < t; i++) {
            String combo = pair_left[i] + " " + pair_right[i];

            if (!myPair.contains(combo)) myPair.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(myPair.size());
        }

        scanner.close();
    }

}
