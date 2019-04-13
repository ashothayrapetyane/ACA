package com.aca.test;

public class TestMain1 {

    public static void main(String[] args) {

        IntegerWraper num1 = new IntegerWraper(10);
        IntegerWraper num2 = new IntegerWraper(25);
        System.out.println("Before  num1="+num1.numForSwap+" ; num2="+num2.numForSwap);
        Tets1.swap(num1,num2);
        System.out.println("After   num1="+num1.numForSwap+" ; num2="+num2.numForSwap);
        StringBuilder str = new StringBuilder("abcd");
        str.reverse();
        System.out.println(str);

    }
}
