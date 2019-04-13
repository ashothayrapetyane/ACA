package com.aca.guessnumGame;

import java.util.*;


public class GuessGame {

    public static void main(String[] args) {
        Engine game = new Engine();
        outer:
        do {

            int guess = (new Scanner(System.in)).nextInt();
            switch (game.isGuessed(guess)) {
                case MORE:
                    System.out.println("Bigger then the number you must to guess, try again!");
                    break;
                case LESS:
                    System.out.println("Less then the number you must to guess, try again!");
                    break;
                case EQUAL:
                    System.out.println("You are guess in " +Engine.count+ " steps. The number is "+guess+".");
                    System.out.println("Congrats!!!");
                    break outer;

            }

        } while (true);

    }
}
