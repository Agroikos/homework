package hackerrank.week4;

import java.util.*;

public class DequeueExample {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
        }

        int max = 0;

        for (int i = 0; i<=n-m; i++) {
            Deque<Integer> copyDeque = new ArrayDeque<>(deque);

            Set<Integer> unique = new HashSet<>();

            System.out.println("test");
            for (int j = 0; j < m; j++) {
                //copyDeque.stream().forEach(t -> System.out.print(t + " "));
                unique.add(copyDeque.pop());
            }
            unique.stream().forEach(t-> System.out.print(t + " "));


            System.out.println();

            if (max < unique.size()) max = unique.size();

            deque.pop();
        }


        System.out.println(max);
    }


}
