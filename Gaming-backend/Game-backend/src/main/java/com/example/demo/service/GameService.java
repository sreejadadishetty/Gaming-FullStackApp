package com.example.demo.service;

public class GameService {
    private String[][] board;
    private String currentPlayer;

    public GameService() {
        board = new String[3][3]; 
        currentPlayer = "X"; 
        resetBoard();
    }

    public String[][] getBoard() {
        return board;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "";
            }
        }
    }

    public boolean makeMove(int row, int col) {
        if (board[row][col].equals("")) {
            board[row][col] = currentPlayer;
            togglePlayer();
            return true;
        }
        return false;
    }

    private void togglePlayer() {
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";
    }

    public String checkWinner(String[][] board) {
        // Check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("")) {
                return board[i][0];
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return board[0][i];
            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
            return board[0][0];
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("")) {
            return board[0][2];
        }
        return "";
    }

   

    
}
