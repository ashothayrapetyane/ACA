package com.aca.games.guessnumgame;

import java.util.*;

public class Engine {
    private static int counter = 0;
    private int randomInt;

    Engine() {

        this.randomInt = (new Random()).nextInt(10);
    }

    private StringEnum isGuessed(int guessNum) {
        counter++;
        return (this.randomInt == guessNum) ? StringEnum.EQUAL : (randomInt < guessNum) ? StringEnum.MORE : StringEnum.LESS;

    }

    public void play() {

        System.out.print("Guess the number: ");
        outer:
        do {

            int guess = (new Scanner(System.in)).nextInt();
            switch (this.isGuessed(guess)) {
                case MORE:
                    System.out.println("Bigger then the number you must to guess, try again!");
                    break;
                case LESS:
                    System.out.println("Less then the number you must to guess, try again!");
                    break;
                case EQUAL:
                    System.out.println("You are guess in " + Engine.counter + " steps. The number is " + guess + ".");
                    System.out.println("Congrats!!!");
                    break outer;

            }

        } while (true);

    }
}
