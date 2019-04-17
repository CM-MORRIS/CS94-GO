package go.core;

import java.util.*;

/**
 * Intersection class handles determines where stones can be placed
 * it is used by the GameBoard class.
 * @author Alex Mair
 */

public class Intersection {

    /**
     * The GameBoard upon which all the intersections fall.
     */
    private final GameBoard gameBoard;

    /**
     * The position on the width of the board.
     */
    private final int xPosition;

    /**
     * The position on the height of the board.
     */
    private final int yPosition;

    /**
     * Constructor for intersections, given specific board
     * and position upon the board.
     * @param board This is the actual board.
     * @param x This is the width position.
     * @param y This is the height position.
     */
    public Intersection(final GameBoard board, final int x, final int y) {
        gameBoard = board;
        xPosition = x;
        yPosition = y;
    }

    /**
     * Gets the x position of the intersection.
     * @return xPosition
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * Gets the y position of the intersection.
     * @return yPosition
     */
    public int getyPosition() {
        return yPosition;
    }
}
