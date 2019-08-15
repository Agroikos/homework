//1. Write a method that can generate the first 100 numbers from Fibonacci series using Java 8 streams
// which returns the sequence as an array of int.

package week5.streams;

import java.math.BigInteger;
import java.util.stream.Stream;

public class FibonacciSeries {

    public static void main(String[] args) {

        //the int version goes off the rails at element #46 in the series
        //the numbers get too big for int
        int[] fibo = fibonacci(47);
        for (int i = 0; i <= 46; i++) {
            System.out.println("i: " + i + " : " + fibo[i] + " ");
        }
        System.out.println();


        //BigInteger version -- can go to 100
        System.out.println("BigInteger version:");
        BigInteger[] fiboBig = fibonacciBigInt(101);
        for (int i = 0; i <= 100; i++) {
            System.out.println("i: " + i + " : " + fiboBig[i] + " ");
        }

    }

    //nu m-am prins cum sa il fac, e luat de pe net
    public static int[] fibonacci(int n) {
        return Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(n)
                .map(i -> i[0])
                .mapToInt(Integer::intValue)
                .toArray();
    }

    //de ce nu merge git push??????
    //singura mea contributie: l-am facut BigInteger ca sa poata sa duca valori pana la 100+
    public static BigInteger[] fibonacciBigInt(int n) {

        return Stream.iterate(new BigInteger[]{BigInteger.valueOf(0), BigInteger.valueOf(1)},
                i -> new BigInteger[] {i[1], i[0].add(i[1]) } )
                .limit(n)
                .map(i -> i[0])
                .toArray(BigInteger[]::new);
    }
}
