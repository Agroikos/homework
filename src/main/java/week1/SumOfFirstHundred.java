package week1;

public class SumOfFirstHundred {

    public static void main(String[] args) {

        System.out.println("The sum of the first 100 positive integers is: " + calculateSumOfHundred());

    }

    static int calculateSumOfHundred () {

        //basically formula urmatoare
        //return 50*101; // n * (n+1) / 2

        //sau asa, mai pe lung
        int sum = 0;
        for (int i=0; i<=100; i++) sum+=i;

        return sum;
    }
}
