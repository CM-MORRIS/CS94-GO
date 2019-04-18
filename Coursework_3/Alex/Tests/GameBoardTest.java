import go.core.GameBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameBoardTest {

    private GameBoard board = new GameBoard(9,9);

    @Test
    void getWidth() {
        assertEquals(9, board.getWidth());
    }

    @Test
    void getHeight() {
        assertEquals(9, board.getHeight());
    }

    @Test
    void getIntersectionState() {
        assertEquals(0, board.getIntersectionState(5,5));
    }

    @Test
    void setIntersectionState() {
        board.setIntersectionState(5,5,1);
        assertEquals(1, board.getIntersectionState(5,5));
    }
}