package org.example;

import java.util.Scanner;

public class TicTacToeGameFullVersion {
    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Wybierz tryb gry:");
        System.out.println("1.Klasyczna gra 3x3");
        System.out.println("2.Alternatywna gra 10x10");

        int choice = scanner.nextInt();

        if (choice == 1) {
            gameClassic(3);
        } else if (choice == 2) {
            gameAlternative(10);
        } else {
            System.out.println("Nieprawidłowy wybór. Zamykanie programu.");
        }
    }

    public void gameClassic(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }

        printBoard(board);

        char currentPlayer = 'X';

        while (true) {
            System.out.println("Gracz " + currentPlayer + ", podaj numer wiersza od 0 do 2");
            int row = makeMove();
            System.out.println("Gracz " + currentPlayer + ", podaj numer kolumny od 0 do 2");
            int col = makeMove();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                printBoard(board);

                if (checkForWin(board, currentPlayer)) {
                    System.out.println("Gracz " + currentPlayer + " wygrywa!");
                    break;
                } else if (checkForDraw(board)) {
                    System.out.println("Remis!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Zajęte pole. Wybierz inne.");
            }
        }
    }

    public void gameAlternative(int size) {
        char[][] board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = ' ';
            }
        }

        printBoard(board);

        char currentPlayer = 'X';

        while (true) {
            System.out.println("Gracz " + currentPlayer + ", podaj numer wiersza od 0 do 9.");
            int row = makeMove();
            System.out.println("Gracz " + currentPlayer + ", podaj numer kolumny od 0 do 9.");
            int col = makeMove();

            if (board[row][col] == ' ') {
                board[row][col] = currentPlayer;
                printBoard(board);

                if (checkForWin(board, currentPlayer)) {
                    System.out.println("Gracz " + currentPlayer + " wygrywa!");
                    break;
                } else if (checkForDraw(board)) {
                    System.out.println("Remis!");
                    break;
                }

                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Pole zajętę. Wybierz inne.");
            }
        }
    }

    public void printBoard(char[][] board) {
        System.out.print("  ");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < board.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int makeMove() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int move = scanner.nextInt();
                if (move >= 0 && move < 10) {
                    return move;
                } else {
                    System.out.println("Podaj liczbę z zakresu 0-9.");
                }
            } catch (Exception e) {
                System.out.println("Podaj poprawną liczbę.");
                scanner.nextLine(); // Skonsumuj zbędne wejście
            }
        }
    }

    public boolean checkForWin(char[][] board, char currentPlayer) {
        // Sprawdzanie wygranej w wierszach i kolumnach
        for (int i = 0; i < board.length; i++) {
            boolean winRow = true;
            boolean winCol = true;

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != currentPlayer) {
                    winRow = false;
                }
                if (board[j][i] != currentPlayer) {
                    winCol = false;
                }
            }

            if (winRow || winCol) {
                return true;
            }
        }

        // Sprawdzanie wygranej na przekątnych
        boolean winDiagonals1 = true;
        boolean winDiagonals2 = true;

        for (int i = 0; i < board.length; i++) {
            if (board[i][i] != currentPlayer) {
                winDiagonals1 = false;
            }
            if (board[i][board.length - 1 - i] != currentPlayer) {
                winDiagonals2 = false;
            }
        }

        if (winDiagonals1 || winDiagonals2) {
            return true;
        }

        // Sprawdzanie wygranej w rzędach i kolumnach dla planszy 10x10
        for (int i = 0; i < board.length; i++) {
            boolean winRow = true;
            boolean winCol = true;

            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != currentPlayer) {
                    winRow = false;
                }
                if (board[j][i] != currentPlayer) {
                    winCol = false;
                }
            }

            if (winRow || winCol) {
                return true;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j <= board.length - 5; j++) {
                boolean winRow5 = true;
                boolean winCol5 = true;

                for (int k = 0; k < 5; k++) {
                    if (board[i][j + k] != currentPlayer) {
                        winRow5 = false;
                    }
                    if (board[j + k][i] != currentPlayer) {
                        winCol5 = false;
                    }
                }

                if (winRow5 || winCol5) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean checkForDraw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

