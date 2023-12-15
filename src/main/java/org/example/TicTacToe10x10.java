package org.example;

import java.util.Scanner;

public class TicTacToe10x10 {
    private char[][] board;
    private char currentPlayer;
    private Scanner scanner;

    public TicTacToe10x10() {
        board = new char[10][10];
        initializeBoard();
        currentPlayer = 'X';
        scanner = new Scanner(System.in);
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
                System.out.println(currentPlayer + " Wygrana!");
                break;
            }

            if (checkForDraw()) {
                System.out.println("Remis!");
                break;
            }

            switchPlayer();
        }
    }

    public void printBoard() {
        System.out.println("   0   1   2   3   4   5   6   7   8   9");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 9) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 9) {
                System.out.println("------------------------------------------");
            }
        }
        System.out.println();
    }

    public void makeMove() {
        int row, col;

        do {
            System.out.println("Gracz " + currentPlayer + ", wybierz wiersz od 0 do 9 ");
            row = scanner.nextInt();
            System.out.println("Gracz " + currentPlayer + ", wybierz kolumnę od 0 do 9 ");
            col = scanner.nextInt();
        } while (isMoveInvalid(row, col));

        board[row][col] = currentPlayer;
    }

    public boolean isMoveInvalid(int row, int col) {
        return row < 0 || row >= 10 || col < 0 || col >= 10 || board[row][col] != ' ';
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public boolean checkForWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    public boolean checkRows() {
        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == currentPlayer) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public boolean checkColumns() {
        for (int i = 0; i < 10; i++) {
            int count = 0;
            for (int j = 0; j < 10; j++) {
                if (board[j][i] == currentPlayer) {
                    count++;
                    if (count == 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
            }
        }
        return false;
    }

    public boolean checkDiagonals() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (checkDiagonal(i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkDiagonal(int row, int col) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (board[row + i][col + i] == currentPlayer) {
                count++;
                if (count == 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    public boolean checkForDraw() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
