package com.soul.DP;

public class PrimeAndPalindromic {

    public static void main(String[] args) {
        showAllUnder(9999);
    }

    private static void showAllUnder(int i) {
        if (i <=0 )
            return;
        for (int j = 11; j <= i; j++) {
            if (isPrime(j) && isPalindrmoic(j))
                System.out.println(j);
        }
    }

    private static boolean isPrime(int j) {
        for (int i = 2; i < Math.sqrt(j); i++) {
            if ( (j % i)==0){
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrmoic(int j) {

        int temp = j;
        int sum = 0;
        while (temp > 0){
            sum= sum * 10 + temp % 10;
            temp/= 10;
        }
        return sum==j ;
    }
}
