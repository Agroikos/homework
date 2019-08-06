package hackerrank.week4;

import java.util.Scanner;

public class Hourglass {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j< 6; j++) {
                arr[i][j] = scan.nextByte();
            }
        }

        int max = getHourglassSum(arr, 2,2);

        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 5; j++) {
                if (max < getHourglassSum(arr, i, j)) max = getHourglassSum(arr, i, j);
            }
        }

        System.out.println(max);

        scan.close();

    }
    public static int getHourglassSum(int[][] a, int x, int y) {
        return a[x-1][y-1] + a[x-1][y] + a[x-1][y+1]+
                a[x][y] +
                a[x+1][y-1] + a[x+1][y] + a[x+1][y+1];
    }
}
