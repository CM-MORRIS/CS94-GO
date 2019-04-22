package core;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Intersection class handles determines where stones can be placed
 * it is used by the GameBoard class.
 *
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
     * This is the board that the intersections are all on.
     */
    private final GameBoard board;

    /**
     * A set of intersections which are the neighbours
     * to the given intersection.
     */
    private Set<Intersection> neighbours;

    /**
     * Who occupies the intersection.
     */
    private int state;

    /**
     * The stone or chain of stones that is associated with this intersection.
     */
//    private StoneChain stoneChain;

    /**
     * Constructor for intersections, given specific board
     * and position upon the board.
     *
     * @param x     This is the width position.
     * @param y     This is the height position.
     * @param board This is the game board being played on.
     */
    public Intersection(final GameBoard board, final int x, final int y) {
        xPosition = x;
        yPosition = y;
        state = 0;
        this.board = board;
//        stoneChain = null;
    }

    /**
     * This method sets the neighbours
     * for all intersections on the board.
     * As long as the intersections already exist.
     *
     * @param board This is the game board being played upon.
     */
    public void setneighbours() {
        neighbours = new HashSet<Intersection>();
        if (this.xPosition == board.getWidth() - 1) {
            if (this.yPosition == 0) { //TopRight
                neighbours.add(board.getIntersection(xPosition - 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition + 1));
            } else if (this.yPosition == board.getWidth() - 1) { //BottomRight
                neighbours.add(board.getIntersection(xPosition - 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition - 1));
            } else { //Right
                neighbours.add(board.getIntersection(xPosition, yPosition + 1));
                neighbours.add(board.getIntersection(xPosition - 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition - 1));
            }
        } else if (this.xPosition == 0) {
            if (this.yPosition == 0) { //TopLeft
                neighbours.add(board.getIntersection(xPosition, yPosition + 1));
                neighbours.add(board.getIntersection(xPosition + 1, yPosition));
            } else if (this.yPosition == board.getWidth() - 1) { //BottomLeft
                neighbours.add(board.getIntersection(xPosition, yPosition - 1));
                neighbours.add(board.getIntersection(xPosition + 1, yPosition));
            } else { //Left
                neighbours.add(board.getIntersection(xPosition, yPosition + 1));
                neighbours.add(board.getIntersection(xPosition + 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition - 1));
            }
        } else {
            if (this.yPosition == 0) { //Top
                neighbours.add(board.getIntersection(xPosition - 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition + 1));
                neighbours.add(board.getIntersection(xPosition + 1, yPosition));
            } else if (this.yPosition == board.getWidth() - 1) { //Bottom
                neighbours.add(board.getIntersection(xPosition - 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition - 1));
                neighbours.add(board.getIntersection(xPosition + 1, yPosition));
            } else { //Middle
                neighbours.add(board.getIntersection(xPosition - 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition + 1));
                neighbours.add(board.getIntersection(xPosition + 1, yPosition));
                neighbours.add(board.getIntersection(xPosition, yPosition - 1));
            }
        }
    }

    /**
     * Gets the x position of the intersection.
     *
     * @return xPosition
     */
    public int getxPosition() {
        return xPosition;
    }

    /**
     * Gets the y position of the intersection.
     *
     * @return yPosition
     */
    public int getyPosition() {
        return yPosition;
    }

    /**
     * Returns the set of neighbours
     * .
     *
     * @return neighbours
     */
    public Set<Intersection> getNeighbours() {
        return neighbours;
    }

    public Intersection getIntersection() {
        return this;
    }

    public void changeLibertyState(final int newState) {
        for (Intersection n : this.neighbours) {
            for (Intersection k : n.neighbours) {
                if (k.yPosition == this.yPosition && k.xPosition == this.xPosition) {
                    k.state = newState;
                }
            }
        }
    }

    /**
     * Determines whether the placed intersection stone kills others.
     * @param game is the state of the game
     * @return a list of dead intersections.
     */
//    public Set<Intersection> killer(GameLogic game) {
//        Set<Intersection> dead = new HashSet<>();
//        for (Intersection n : this.getNeighbours()) {
//            int surrounded = 0;
//            if (n.state == game.opponent()) {
//                if (n.getStoneChain().getLiberties().size() == 0) {
//                    dead.add(n);
//                } else {
//                    for (Intersection k : n.getNeighbours()) {
//                        if (k.state == game.whosTurn()) {
//                            surrounded++;
//                        }
//                    }
//                    if (surrounded == n.getStoneChain().getLiberties().size()) {
//                        dead.add(n);
//                    }
//                }
//            }
//        }
//        return dead;
//    }

//    public Set<Intersection> deady(GameLogic game) {
//        Set<Intersection> dead = new HashSet<>();
//        if (this.getStoneChain().getLiberties().size() == 0) {
//            dead.addAll(this.getStoneChain().getStones());
//        }
//        return dead;
//    }


//    public int freeNeighbours
//   () {
//        int free = 0;
//        for (Intersection n : this.neighbours
//       ) {
//            if (n.state == 0) {
//                free++;
//            }
//        }
//        return free;
//    }

    /**
     * Returns the current state of the intersection.
     *
     * @return state
     */
    public int getState() {
        return state;
    }

    /**
     * Sets the state for the intersection.
     *
     * @param newState the new state that the intersection is set to.
     */
    public void setState(final int newState) {
        state = newState;
    }

//    public StoneChain getStoneChain() {
//        return stoneChain;
//    }
//
//    public void setStoneChain(StoneChain stoneChain) {
//        this.stoneChain = stoneChain;
//    }
//
//    public Set<StoneChain> getAdjacentStoneChains() {
//        Set<StoneChain> adjacentStoneChains = new HashSet<StoneChain>();
//        for (Intersection n : this.getNeighbours()) {
//            if (n.getStoneChain() != null) {
//                adjacentStoneChains.add(n.getStoneChain());
//            }
//        }
//        return adjacentStoneChains;
//    }

    public Set<Intersection> friendNeighbours() {
        Set<Intersection> friends = new HashSet<>();
        for (Intersection n : this.getNeighbours()) {
            if (n.getState() == this.state) {
                friends.add(n);
            }
        }
        return friends;
    }

    public Set<Intersection> killer(GameLogic game) {
            int player = game.whosTurn();
            int opponent = game.opponent();
            Set<Intersection> opponentChain = new LinkedHashSet<>();
            Set<Intersection> deadChain = new LinkedHashSet<>();
            for (Intersection n : this.getNeighbours()) {
                try {
                    if (n.state == opponent) {
                        opponentChain.add(n);
                        opponentChain.addAll(n.friendNeighbours());
                        for (Intersection k : opponentChain) {
                            opponentChain.addAll(k.friendNeighbours());
                        }
                    }
                } catch (Exception concurrentmodificationexception) {
                }
                Set<Intersection> totalneighbours = new LinkedHashSet<>();
                Set<Intersection> friendneighbours = new LinkedHashSet<>();
                for (Intersection k : opponentChain) {
                    totalneighbours.addAll(k.getNeighbours());
                    friendneighbours.addAll(k.friendNeighbours());
                }
                int surrounded = 0;
                for (Intersection k : totalneighbours) {
                    if (k.getState() == player) {
                        surrounded++;
                    }
                }
                if (surrounded == totalneighbours.size() - friendneighbours.size()) {
                    deadChain.addAll(opponentChain);
                }
            }
        return deadChain;
    }
}
