package com.soul.DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.CountDownLatch;

public class NormalSort {

    public static void main(String[] args) {
//        int[] arr = {4, 1, 13, 5, 6, 3, 9, 23, 53};
//        bubbleSort(arr,arr.length);
//        switchSort(arr,arr.length);
//        insertSort(arr,arr.length);
//        printArr(arr);

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 0;
        }
        System.out.println(arr.length);
    }

    private static void insertSort(int[] arr, int length) {

        for (int i = 1; i < length; i++) {

            int j = i;
            while (j >0 && arr[j] < arr[j-1]){
                swap(arr,j,j-1);
                j--;
            }
        }
    }

    private static void switchSort(int[] arr, int length) {

        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            swap(arr,min,i);
        }
    }

    private static void printArr(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+"\t");
        }
    }

    private static void bubbleSort(int[] arr, int length) {

        for (int i = 0; i < length; i++) {

            boolean flag = true;

            for (int j = 0; j < length - i -1; j++) {
                if (arr[j] > arr[j+1]){
                    swap(arr,j,j+1);
                    flag = false;
                }
            }
        }
    }

    private static void swap(int[] arr, int j, int i) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
