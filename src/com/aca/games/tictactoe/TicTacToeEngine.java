package com.aca.games.tictactoe;

import java.util.Scanner;

import static java.lang.Math.abs;

public class TicTacToeEngine {

    //private static Scanner scan = new Scanner(System.in);
    private static int row, col;
    private static int boardSize, winCells;
    private static GameMark[][] board;
    private static GameMark turn = GameMark.X;
    private static int[] rowCounter;
    private static int[] colCounter;
    private static int diagLeft;
    private static int diagRight;


    public static void play() {

        init();
        printBoard();
        do {
            do {
                System.out.println("Player '" + turn + "' enter row: ");
                row = getInt("row of player '"+turn.toString()+"'") - 1;
                System.out.println("Player '" + turn + "' enter column: ");
                col = getInt("col of player'"+turn.toString()+"'") - 1;
            } while (!check(row, col));
            board[row][col] = turn;
            printBoard();
            turn = turn == GameMark.X ? GameMark.O : GameMark.X;
        } while (!gameOver(row, col, turn));
        turn = turn == GameMark.X ? GameMark.O : GameMark.X;
        System.out.println("GAME OVER \nCongrats!!! \nThe player '" + turn + "' win the game!");
    }

    private static boolean check(int row, int col) {
        if (row >= boardSize || row < 0 || col >= boardSize || col < 0) {
            System.out.println("The row or column is out of bond(bound is " + boardSize + ")");
            printBoard();
            System.out.println();
            return false;
        }
        if (board[row][col] != GameMark._) {
            System.out.println("The cell you marked was already filled !");
            printBoard();
            System.out.println();
            return false;
        }
        return true;
    }

    private static int getInt(String s) {
        while (true) {
            try {
                return (new Scanner(System.in)).nextInt(); //Integer.valueOf(scan.nextLine());
            } catch (Exception e) {
                System.out.println("Enter a valid number for "+s);
            }
        }
    }

    private static void init() {
        do {
            System.out.print("Please enter the board size from 3 to 10(for example 3): ");
            boardSize = getInt("board size from 3 to 10(for example 3): ");
        } while (boardSize < 3 || boardSize > 10);
        do {
            System.out.print("Please enter the win cells capacity(from 3 to " + boardSize + "): ");
            winCells = getInt("win cells capacity(from 3 to " + boardSize + "): ");
        } while (winCells < 3 || winCells > boardSize);
        board = new GameMark[boardSize][boardSize];
        rowCounter = new int[boardSize];
        colCounter = new int[boardSize];
        for (int i = 0; i < boardSize; i++)
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = GameMark._;
            }
    }

    private static boolean gameOver(int row, int col, GameMark player) {

        int move = player == GameMark.X ? 1 : -1;
        rowCounter[row] += move;
        colCounter[col] += move;
        if (row == col) diagLeft += move;
        if (row == boardSize - col - 1) diagRight += move;
        /*if (abs(rowCounter[row]) == winCells || abs(colCounter[col]) == winCells || abs(diagRight) == winCells || abs(diagLeft) == winCells)
            return true;*/
        return (abs(rowCounter[row]) == winCells || abs(colCounter[col]) == winCells || abs(diagRight) == winCells || abs(diagLeft) == winCells);
    }

    private static void printBoard() {
        System.out.println();
        for (int i = 0; i < boardSize; i++) {
            System.out.print("| ");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
