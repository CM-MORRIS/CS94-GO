package go.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibertiesTest {

    private GameBoard board = new GameBoard(9,9);
    private Liberties liberties = new Liberties(board);
    @Test
    void getLiberties() {
        assertEquals(4, liberties.getLiberties(3,2));
    }

    @Test
    void setLiberties() {
        liberties.setLiberties(0, 0, -1);
        assertEquals(1, liberties.getLiberties(0, 0));
    }
}