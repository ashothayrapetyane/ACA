package com.aca.guessnumGame;

import java.util.*;

public class Engine {
    static int count=0;
    private int randomInt;
    Engine(){
        this.randomInt=(new Random()).nextInt(100);
    }

    public StringEnum isGuessed(int guessNum){
        count++;
        return (randomInt==guessNum)? StringEnum.EQUAL:(randomInt>guessNum)? StringEnum.MORE: StringEnum.LESS;

    }
}
