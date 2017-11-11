package com.soul.DP;

import java.util.ArrayList;
import java.util.List;

public class JoserfulCircle {

    private static final int DEAD_NUM = 97;

    public static void main(String[] args) {

//
        int[] arr = new int[30];
        for (int i = 0; i < 30; i++) {
            arr[i] = i+1;
        }

        joserful(arr,15,9);

        joserful2();
    }

    private static void joserful2() {
        boolean[] persons = new boolean[30];
        for(int i = 0; i < persons.length; i++) {
            persons[i] = true;
        }

        int counter = 0;
        int claimNumber = 0;
        int index = 0;
        while(counter < 15) {
            if(persons[index]) {
                claimNumber++;
                if(claimNumber == DEAD_NUM) {
                    counter++;
                    claimNumber= 0;
                    persons[index]= false;
                }
            }
            index++;
            if(index >= persons.length) {
                index= 0;
            }
        }
        for(boolean p : persons) {
            if(p) {
                System.out.print("基");
            }
            else {
                System.out.print("非");
            }
        }
    }

    private static void joserful(int[] arr,int survivalNum,int stepNum) {


        List<Integer> list = new ArrayList<>(30);

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        int victim = 0;
        int theNext = 0;
        while (list.size() > survivalNum){

            if ((victim+stepNum) > list.size()){
//                theNext = victim + stepNum -list.size() -1;
                theNext = (victim + stepNum) % list.size() -1;
            }else {
                theNext = victim + stepNum -1;
            }

            System.out.println(list.get(theNext));
            list.remove(theNext);
            victim = theNext;

        }
    }
}
