package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameSuite {

    @Test
    void testOWinsInRows() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    void testOWinsInColumns() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 0);
        game.makeMove(1, 1);
        game.makeMove(2, 0);
        assertTrue(game.checkForWin());
    }

    @Test
    void testOWinsInDiagonals() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0);
        game.makeMove(0, 2);
        game.makeMove(1, 1);
        game.makeMove(1, 2);
        game.makeMove(2, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    void testXWinsInRows() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(1, 0);
        game.makeMove(0, 0);
        game.makeMove(1, 1);
        game.makeMove(0, 1);
        game.makeMove(1, 2);
        game.makeMove(0, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    void testXWinsInColumns() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(2, 0);
        assertTrue(game.checkForWin());
    }

    @Test
    void testXWinsInDiagonals() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0);
        game.makeMove(0, 2);
        game.makeMove(1, 1);
        game.makeMove(1, 2);
        game.makeMove(2, 2);
        assertTrue(game.checkForWin());
    }

    @Test
    void testDraw() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(0, 2);
        game.makeMove(1, 0);
        game.makeMove(1, 1);
        game.makeMove(1, 2);
        game.makeMove(2, 0);
        game.makeMove(2, 1);
        game.makeMove(2, 2);
        assertTrue(game.checkForDraw());
    }

    @Test
    void testInvalidMove() {
        TicTacToeGame game = new TicTacToeGame();
        game.makeMove(0, 0);
        assertThrows(IllegalArgumentException.class, () -> game.makeMove(0, 0));
    }
}
