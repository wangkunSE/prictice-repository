package com.soul.extend;

public class Inital {
    public static void main(String[] args) {
        Son s = new Son();
    }

}

class Parent{

    int parent = 10;
    {
        System.out.println("parent中的初始化块 : "+parent);
        prt(parent);
    }
    static{
        System.out.println("parent中static初始化块: ");
    }
    public static void prt(int i){
        System.out.println("当前parent的值为："+i);
    }

    public Parent(){
        System.out.println("parent构造方法: "+parent);
        prt(parent);
    }
}

class Son extends Parent{
    int son = 9;

    {
        System.out.println("son中的初始化块 : "+ son);
        prt(son);
    }


    static{
        System.out.println("son中的static初始化块");

    }

    public Son(){
        System.out.println("son构造方法 : "+ son);
        prt(son);
    }

}