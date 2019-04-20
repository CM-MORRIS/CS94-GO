package core;

/**
 * Intersection class handles determines where stones can be placed
 * it is used by the GameBoard class.
 * @author Alex Mair
 */

public class Intersection {

    /**
     * The position on the width of the board.
     */
    private int xPosition;

    /**
     * The position on the height of the board.
     */
    private int yPosition;

    /**
     * The number of liberties each intersection has.
     */
    private int liberties;

    /**
     * Who occupies the intersection.
     */
    private int state;

    /**
     * Constructor for intersections, given specific board
     * and position upon the board.
     * @param x This is the width position.
     * @param y This is the height position.
     * @param dimension This is the size of the game board.
     */
    public Intersection(final int dimension, final int x, final int y) {
        xPosition = x;
        yPosition = y;
        state = 0;
        final int size = dimension - 1;
        if (y == 0 && x == 0 || y == size && x == size
                || y == 0 && x == size || y == size && x == 0) {
            liberties = 2;
        } else if ((y == 0 || x == size && y != size && x != 0)
                || (y == size || y == 0 && x != 0 && x != size)) {
            liberties = 3;
        } else {
            liberties = 4;
        }
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

    /**
     * Returns the number of liberties that each intersection has.
     * @return liberties
     */
    public int getLiberties() {
        return liberties;
    }

    /**
     * Sets the number of liberties to whatever the new number of liberties is.
     * @param newLiberties Is how many liberties the intersection now has.
     */
    public void setLiberties(final int newLiberties) {
        liberties = newLiberties;
    }

    /**
     * Returns the current state of the intersection.
     * @return state
     */
    public int getState() {
        return state;
    }

    /**
     * Sets the state for the intersection.
     * @param newState the new state that the intersection is set to.
     */
    public void setState(final int newState) {
        state = newState;
    }
}
