package com.soul.DP;

public class AdjustHeap {

    public static void main(String[] args) {
        int[] arr = {4, 1, 13, 5, 6, 3, 9, 23, 53};
        initToMaxHeap(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print("\t" + arr[i]);
        }
    }

    private static void initToMaxHeap(int[] arr, int length) {
        for (int i = length / 2 - 1; i >= 0; i --) {
            adjustFromBottomToTop(arr, i, length);
        }
    }

    private static void adjustFromBottomToTop(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int j = 2 * i + 1; j < length; j = 2 * j + 1) {
            if (j + 1 < length && arr[j] < arr[j + 1]) {
                j++;
            }
            if (temp < arr[j]) {
                arr[i] = arr[j];
                i = j;
            } else {
                break;
            }
        }
        arr[i] = temp;
    }
}
