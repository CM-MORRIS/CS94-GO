package go.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameLogicTest {

    private GameBoard board = new GameBoard(9,9);
    private GameLogic game = new GameLogic(board, "Alex", "Will");

    @Test
    void incrementPassCounter() {
        game.incrementPassCounter();
        assertEquals(1, game.getPassCounter());
    }

    @Test
    void incrementTurnCounter() {
        game.incrementTurnCounter();
        assertEquals(2, game.getTurnCounter());
    }

    @Test
    void getTurnCounter() {
        assertEquals(1, game.getTurnCounter());
    }

    @Test
    void getPassCounter() {
        assertEquals(0, game.getPassCounter());
    }

    @Test
    void getPlayer1() {
        assertEquals("Alex", game.getPlayer1());
    }

    @Test
    void getPlayer2() {
        assertEquals("Will", game.getPlayer2());
    }

    @Test
    void whosTurn() {
        assertEquals("Alex", game.whosTurn());
    }

    @Test
    void whosTurn1() {
        game.incrementTurnCounter();
        assertEquals("Will", game.whosTurn());
    }
}