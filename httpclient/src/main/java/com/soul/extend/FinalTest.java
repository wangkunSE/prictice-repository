package com.soul.extend;

public class FinalTest {

    public static void main(String[] args) {
        Dinosaur dinosaur = new Dinosaur();
        dinosaur.i = 8;
        System.out.println(dinosaur.i);
    }
}

final class Dinosaur{
    int i ;
    int j;
    FinalTest finalTest = new FinalTest();

    void f() {

    }
}


