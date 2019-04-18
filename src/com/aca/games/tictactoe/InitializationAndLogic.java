package com.aca.games.tictactoe;

public class InitializationAndLogic extends InputCheck {
    protected int draw = 0;
    protected String[] rowCounter;
    protected String[] colCounter;
    protected String[] diagLeft;
    protected String[] diagRight;
    protected int boardSize, winCells;
    protected String winX = "";
    protected String winO = "";

    protected void init() {
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
        diagLeft = new String[1 + (boardSize - 3) * 2];
        diagRight = new String[1 + (boardSize - 3) * 2];
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

    protected boolean gameOver(int row, int col, GameMark player) {
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


}
