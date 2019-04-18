package com.aca.games.tictactoe;

import java.util.Scanner;

public class InputCheck  {

    protected GameMark[][] board;

    protected int getInt(String s) {
        while (true) {
            try {
                return (new Scanner(System.in)).nextInt(); //Integer.valueOf(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number for " + s);
            }
        }
    }

    protected boolean check(int row, int col, int boardSize) {
        if (row >= boardSize || row < 0 || col >= boardSize || col < 0) {
            System.out.println("The row or column is out of bond(bound is " + boardSize + ")");
            return false;
        }
        if (board[row][col] != GameMark._) {
            System.out.println("The cell you marked was already filled !");
            return false;
        }
        return true;
    }
}
