package com.soul.DP;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;

public class FullPermutation {

    public static void perm(int[] list) {
        perm(list,0);
    }

    private static void perm(int[] list, int k) {
        if (k == list.length) {
            for (int i = 0; i < list.length; i++) {
                System.out.print(list[i]);
            }
            System.out.println();
        }else{
            for (int i = k; i < list.length; i++) {
                swap(list, k, i);
                perm(list, k + 1);
                swap(list, k, i);
            }
        }
    }

    private static void swap(int[] list, int pos1, int pos2) {
        int temp = list[pos1];
        list[pos1] = list[pos2];
        list[pos2] = temp;
    }

    public static void main(String[] args) {
//        int[] x = {1, 2, 3, 4, 5,6,7,8,9};
//        long start = System.currentTimeMillis();
////        perm(x);
//        mySlovtion(x);
//        long end = System.currentTimeMillis();
//        System.out.println("花费了："+(end-start)+" 时间");
        System.out.println(a);
    }

    private static Integer a ;

    static Integer getA(){

        return 23;
    }

    private static void mySlovtion(int[] x){
        int min = getMin(x);
        int max = getMax(x);
        for (int i = min; i < max; i++) {
            if (isVaild(i,x)){
                System.out.println(i);
            }
        }
    }

    private static boolean isVaild(int i, int[] x) {

        int[] target = resolveArr(i,x.length);
        for (int j = 0; j < x.length; j++) {
            for (int k = j + 1; k < x.length; k++) {
                if(target[j] == target[k])
                    return false;
            }
        }

        int count = 0;
        for (int j = 0; j < x.length; j++) {
            for (int k = 0; k < x.length; k++) {
                if (target[j] != x[k])
                    count++;
                else if (target[j] == x[k]){
                    count = 0;
                }
            }

            if (count >= x.length)
                return false;
        }

        return true;
    }

    private static int[] resolveArr(int src, int length) {

        int[] target =new int[length];

        int temp = src;
        int count = 0;
        while (temp>0 && count<length){
            target[count] = temp%10;
            temp /= 10;
            count ++;
        }

        return target;
    }

    private static int getMax(int[] x) {

        int sum = 0;
        for (int i = (x.length-1); i >= 0; i--) {
            sum = sum * 10 + x[i];
        }
        return sum;
    }


    private static int getSum(int[] x) {
        int sum = 0;
        for (int i = 0; i < x.length; i++) {
            sum = sum * 10 +x[i];
        }
        return sum;
    }

    private static int getMin(int[] x) {
        Arrays.sort(x);
        int sum = getSum(x);
        return sum;
    }
}