package com.aca.games.tictactoe;

public class TicTacToeEngine extends InitializationAndLogic {

    private int counterX, counterO;
    private int row, col;
    private GameMark turn = GameMark.X;

    public void play() {
        init();
        do {
            do {
                printBoard();
                System.out.println("Player '" + turn + "' enter row: ");
                row = getInt("row of player '" + turn.toString() + "'") - 1;
                System.out.println("Player '" + turn + "' enter column: ");
                col = getInt("col of player'" + turn.toString() + "'") - 1;
            } while (!check(row, col, boardSize));
            board[row][col] = turn;
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

    private void printBoard() {
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
