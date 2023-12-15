package org.example;

import java.util.Scanner;
// gra na 2 użytkowników
public class TicTacToeGame {
    private char[][] board;
    private char currentPlayer;

    public TicTacToeGame() {
        board = new char[3][3];
        initializeBoard();
        currentPlayer = 'X';
    }

    public void initializeBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void playGame() {
        printBoard();

        while (true) {
            makeMove();
            printBoard();

            if (checkForWin()) {
                System.out.println("Gracz " + currentPlayer + " wygrywa!");
                break;
            }

            if (checkForDraw()) {
                System.out.println("Remis.");
                break;
            }
            switchPlayer();
        }
    }

    public void printBoard() {
        System.out.println("   0   1   2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println(" -----------");
            }
        }
        System.out.println();
    }

    public void makeMove() {
        Scanner scanner = new Scanner(System.in);
        int row, col;

        do {
            System.out.println("Gracz " + currentPlayer + ", wpisz wiersz od 0 do 2 ");
            row = scanner.nextInt();
            System.out.println("Gracz " + currentPlayer + ", wpisz kolumnę od 0 do 2 ");
            col = scanner.nextInt();
        } while (isMoveInvalid(row, col));

        board[row][col] = currentPlayer;
    }
    public void makeMove(int row, int col) {
        if (isMoveInvalid(row, col)) {
            throw new IllegalArgumentException("Zły ruch. Powtórz ruch");
        }

        board[row][col] = currentPlayer;
    }

    public boolean isMoveInvalid(int row, int col) {
        return row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != ' ';
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkForWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    public boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDiagonals() {
        return (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) ||
                (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer);
    }

    public boolean checkForDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

