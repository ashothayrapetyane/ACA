package com.aca.test;

public class Tets1 {

    static public void swap(IntegerWraper num1, IntegerWraper num2){
        int temp ;
        temp=num1.numForSwap;
        num1.numForSwap=num2.numForSwap;
        num2.numForSwap=temp;

    }


}

class IntegerWraper{
    int numForSwap;
    IntegerWraper(int num){
        this.numForSwap=num;
    }

}
