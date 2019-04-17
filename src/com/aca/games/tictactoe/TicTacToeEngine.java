package com.aca.games.tictactoe;

import java.util.Scanner;

public class TicTacToeEngine {

    private static int counterX, counterO;
    private static int row, col;
    private static int boardSize, winCells;
    private static GameMark[][] board;
    private static GameMark turn = GameMark.X;
    private static String[] rowCounter;
    private static String[] colCounter;
    private static String[] diagLeft;
    private static String[] diagRight;
    private static int draw = 0;
    private static String winX = "";
    private static String winO = "";


    public static void play() {

        init();
        printBoard();
        do {
            do {
                System.out.println("Player '" + turn + "' enter row: ");
                row = getInt("row of player '" + turn.toString() + "'") - 1;
                System.out.println("Player '" + turn + "' enter column: ");
                col = getInt("col of player'" + turn.toString() + "'") - 1;
            } while (!check(row, col));
            board[row][col] = turn;
            printBoard();
            if (turn == GameMark.X) {
                turn = GameMark.O;
                counterX++;
            } else {
                turn = GameMark.X;
                counterO++;
            }
        } while (!gameOver(row, col, turn));
        turn = turn == GameMark.X ? GameMark.O : GameMark.X;
        if (draw == boardSize * boardSize) System.out.println("GAME OVER \nIT'S A DRAW.");
        else
            System.out.println("GAME OVER \nCongrats!!! \nThe player '" + turn + "' win the game!");
        System.out.println("Player X made " + counterX + " moves.\nPlayer O made " + counterO + " moves.");
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
                System.out.println("Enter a valid number for " + s);
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
        int temp = 0;
        while (temp < winCells) {
            winO += "O";
            winX += "X";
            temp++;
        }
        board = new GameMark[boardSize][boardSize];
        diagRight = diagLeft = new String[1 + (boardSize - 3) * 2];
        rowCounter = new String[boardSize];
        colCounter = new String[boardSize];
        temp = 0;
        while (temp < (1 + (boardSize - 3) * 2)) {
            diagRight[temp] = diagLeft[temp] = "___________";
            temp++;
        }
        for (int i = 0; i < boardSize; i++) {
            rowCounter[i] = colCounter[i] = "";
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = GameMark._;
                rowCounter[i] = colCounter[i] += GameMark._.toString();
            }
        }
    }

    private static boolean gameOver(int row, int col, GameMark player) {
        int diagL = boardSize - 3 + row - col;
        int diagR = 2 * boardSize - row - col - 4;
        draw++;
        if (draw == boardSize * boardSize) return true;
        //System.out.println(move + "  " + player.toString() + "  " + GameMark.X.toString());
        //System.out.println("row = " + row + " : col = " + col + " boardSize = " + boardSize);
        //System.out.println("before rowCounter [" + row + "] = " + rowCounter[row]);
        rowCounter[row] = rowCounter[row].substring(0, col) + player + rowCounter[row].substring(col + 1);
        //System.out.println("after rowCounter [" + row + "] = " + rowCounter[row]);
        colCounter[col] = colCounter[col].substring(0, row) + player + colCounter[col].substring(row + 1);
        if (diagL >= 0 && diagL < diagLeft.length) {
            diagLeft[diagL] = diagLeft[diagL].substring(0, col) + player + diagLeft[diagL].substring(col + 1);
            //System.out.println("diagLeft[ " + diagL + " ]" + " = " + diagLeft[diagL]);
            if (diagLeft[diagL].contains(winX) || diagLeft[diagL].contains(winO))
                return true;
        }
        if (diagR >= 0 && diagR < diagRight.length) {
            //System.out.println("Before diagRight[ " + diagR + " ]" + " = " + diagRight[diagR]);
            diagRight[diagR] = diagRight[diagR].substring(0, row) + player + diagRight[diagR].substring(row + 1);
            //System.out.println("After diagRight[ " + diagR + " ]" + " = " + diagRight[diagR]);
            if (diagRight[diagR].contains(winX) || diagRight[diagR].contains(winO))
                return true;
        }
        return (rowCounter[row].contains(winX) || rowCounter[row].contains(winO) || colCounter[col].contains(winX) || colCounter[col].contains(winO));
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
