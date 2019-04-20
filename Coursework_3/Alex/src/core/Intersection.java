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
     * A set of intersections which are the liberties to the given intersection.
     */
    private Set<Intersection> liberties;

    /**
     * Who occupies the intersection.
     */
    private int state;

    /**
     * The size of the board being played upon.
     */
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

    /**
     * This method sets the liberties for all intersections on the board.
     * As long as the intersections already exist.
     * @param board This is the game board being played upon.
     */
    public void setLiberties(GameBoard board) {
        liberties = new HashSet<Intersection>();
        if (this.xPosition == size) {
            if (this.yPosition == 0) { //BottomRight
                liberties.add(board.getIntersection(xPosition - 1, yPosition));
                liberties.add(board.getIntersection(xPosition , yPosition + 1));
            } else if (this.yPosition == size) { //TopRight
                liberties.add(board.getIntersection(xPosition - 1, yPosition));
                liberties.add(board.getIntersection(xPosition, yPosition - 1));
            } else { //Right
                liberties.add(board.getIntersection(xPosition, yPosition + 1));
                liberties.add(board.getIntersection(xPosition - 1, yPosition));
                liberties.add(board.getIntersection(xPosition, yPosition - 1));
            }
        } else if (this.xPosition == 0) {
            if (this.yPosition == 0) { //BottomLeft
                liberties.add(board.getIntersection(xPosition, yPosition + 1));
                liberties.add(board.getIntersection(xPosition + 1, yPosition));
            } else if (this.yPosition == size) { //TopLeft
                liberties.add(board.getIntersection(xPosition, yPosition - 1));
                liberties.add(board.getIntersection(xPosition + 1, yPosition));
            } else { //Left
                liberties.add(board.getIntersection(xPosition, yPosition + 1));
                liberties.add(board.getIntersection(xPosition + 1, yPosition));
                liberties.add(board.getIntersection(xPosition, yPosition - 1));
            }
        } else {
            if (this.yPosition == 0) { //Bottom
                liberties.add(board.getIntersection(xPosition - 1, yPosition));
                liberties.add(board.getIntersection(xPosition, yPosition + 1));
                liberties.add(board.getIntersection(xPosition + 1, yPosition));
            } else if (this.yPosition == size) { //Top
                liberties.add(board.getIntersection(xPosition - 1, yPosition));
                liberties.add(board.getIntersection(xPosition, yPosition - 1));
                liberties.add(board.getIntersection(xPosition + 1, yPosition));
            } else { //Middle
                liberties.add(board.getIntersection(xPosition - 1, yPosition));
                liberties.add(board.getIntersection(xPosition, yPosition + 1));
                liberties.add(board.getIntersection(xPosition + 1, yPosition));
                liberties.add(board.getIntersection(xPosition, yPosition - 1));
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
     * Returns the set of liberties.
     * @return liberties
     */
    public Set<Intersection> getLiberties() {
        return liberties;
    }


//    public void changeLibertyState(final int newState) {
//        for (Intersection n : this.liberties) {
//            for (Intersection k : n.liberties) {
//                if (k.yPosition == this.yPosition && k.xPosition == this.xPosition) {
//                    k.state = newState;
//                }
//            }
//        }
//    }

//    public int freeLiberties() {
//        int free = 0;
//        for (Intersection n : this.liberties) {
//            if (n.state == 0) {
//                free++;
//            }
//        }
//        return free;
//    }

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
