package core;

import java.util.HashSet;
import java.util.Set;

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
    private Set<Intersection> liberties;

    /**
     * Who occupies the intersection.
     */
    private int state;


    private final int size;

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
        size = dimension - 1;
    }

    public void setLiberties(GameBoard board) {
        liberties = new HashSet<Intersection>();
        if (this.xPosition == size) {
            if (this.yPosition == 0) { //BottomRight
                liberties.add(board.getIntersections(xPosition - 1, yPosition));
                liberties.add(board.getIntersections(xPosition , yPosition + 1));
            } else if (this.yPosition == size) { //TopRight
                liberties.add(board.getIntersections(xPosition - 1, yPosition));
                liberties.add(board.getIntersections(xPosition, yPosition - 1));
            } else { //Right
                liberties.add(board.getIntersections(xPosition, yPosition + 1));
                liberties.add(board.getIntersections(xPosition - 1, yPosition));
                liberties.add(board.getIntersections(xPosition, yPosition - 1));
            }
        } else if (this.xPosition == 0) {
            if (this.yPosition == 0) { //BottomLeft
                liberties.add(board.getIntersections(xPosition, yPosition + 1));
                liberties.add(board.getIntersections(xPosition + 1, yPosition));
            } else if (this.yPosition == size) { //TopLeft
                liberties.add(board.getIntersections(xPosition, yPosition - 1));
                liberties.add(board.getIntersections(xPosition + 1, yPosition));
            } else { //Left
                liberties.add(board.getIntersections(xPosition, yPosition + 1));
                liberties.add(board.getIntersections(xPosition + 1, yPosition));
                liberties.add(board.getIntersections(xPosition, yPosition - 1));
            }
        } else {
            if (this.yPosition == 0) { //Bottom
                liberties.add(board.getIntersections(xPosition - 1, yPosition));
                liberties.add(board.getIntersections(xPosition, yPosition + 1));
                liberties.add(board.getIntersections(xPosition + 1, yPosition));
            } else if (this.yPosition == size) { //Top
                liberties.add(board.getIntersections(xPosition - 1, yPosition));
                liberties.add(board.getIntersections(xPosition, yPosition - 1));
                liberties.add(board.getIntersections(xPosition + 1, yPosition));
            } else { //Middle
                liberties.add(board.getIntersections(xPosition - 1, yPosition));
                liberties.add(board.getIntersections(xPosition, yPosition + 1));
                liberties.add(board.getIntersections(xPosition + 1, yPosition));
                liberties.add(board.getIntersections(xPosition, yPosition - 1));
            }
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
    public Set<Intersection> getLiberties() {
        return liberties;
    }

    /**
     * Sets the number of liberties to whatever the new number of liberties is.
     * @param newLiberties Is how many liberties the intersection now has.
     */
    public void changeLibertyState(final int x, final int y, final int newState) {
        for (Intersection n : liberties) {
            n.state = newState;
        }
    }

    public int freeLiberties() {
        int free = 0;
        for (Intersection n : this.liberties) {
            if (n.state == 0) {
                free++;
            }
        }
        return free;
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
