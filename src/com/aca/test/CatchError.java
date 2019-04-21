package com.aca.test;

import java.util.Random;

public class CatchError {
    public static void main(String[] args) {

        try {
            Random ran = new Random(13);
            Random ran1 = new Random(13);
            String[] str = {"Hello ","my friend"};

                    String s = "my heLlo my hello my";
            double x = (double) 5 / 2;
            System.out.println(Integer.SIZE);
            System.out.println(Double.isNaN(Math.sqrt(-1)));
            System.out.println(ran.nextInt(3));
            System.out.println(ran1.nextInt(3));

            myMethod();
        } catch (StackOverflowError e) {
            for (int i = 0; i < 2; i++)
                System.out.println(i);
        }
    }
    static Random ran2 = new Random(13);
    public static void myMethod() {
        //System.out.println("myMethod");
        //myMethod();
        System.out.println(ran2.nextInt(3));
    }
}
