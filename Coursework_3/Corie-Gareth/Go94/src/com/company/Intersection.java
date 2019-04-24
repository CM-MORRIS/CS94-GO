package com.company;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Intersection class handles determines where stones can be placed
 * it is used by the GameBoard class.
 *
 * @author Alex Mair and Will Davies
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
    }

    /**
     * This method sets the neighbours
     * for all intersections on the board.
     * As long as the intersections already exist.
     */
    public void setNeighbours() {
        neighbours = new HashSet<>();
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
     * Returns the set of neighbours.
     *
     * @return neighbours
     */
    public Set<Intersection> getNeighbours() {
        return neighbours;
    }


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

    /**
     * This method finds the outermost neighbours of a set of intersections.
     *
     * @param linkedStones The set of linked intersections
     * @param owner        The owner of the linked stones being checked.
     * @return A set of Intersections.
     */
    public Set<Intersection> getOuterNeighbour(final Set<Intersection> linkedStones,
                                               final int owner) {
        Set<Intersection> outside = new LinkedHashSet<>();
        for (Intersection n : linkedStones) {
            for (Intersection k : n.getNeighbours()) {
                if (k.state != owner) {
                    outside.add(k);
                }
            }
        }
        return outside;
    }

    /**
     * A method to determine for a given point, which neighbours to that point
     * have the same state as that point.
     *
     * @return A set of intersections.
     */
    public Set<Intersection> friendNeighbours() {
        Set<Intersection> friends = new HashSet<>();
        for (Intersection n : this.getNeighbours()) {
            if (n.getState() == this.state) {
                friends.add(n);
            }
        }
        return friends;
    }

    /**
     * A method to check if the stone just placed finishes the surrounding
     * of opponent stones and thus kills the chain within their bounds
     * causing the removal of these stones.
     *
     * @param game The current state of the game.
     * @return A set of Intersections which are the taken stones.
     */
    public Set<Intersection> killer(final GameLogic game) {
        int player = game.whosTurn();
        int opponent = game.opponent();
        Set<Intersection> deadChain = new LinkedHashSet<>();
        for (Intersection n : this.getNeighbours()) {
            Set<Intersection> finalChain = new LinkedHashSet<>();
            Set<Intersection> opponentChain = new LinkedHashSet<>();
            if (n.state == opponent) {
                finalChain.add(n);
                opponentChain.addAll(n.friendNeighbours());
                finalChain.addAll(opponentChain);
                int i = 0;
                while (i < finalChain.size()) {
                    for (Intersection m : finalChain) {
                        opponentChain.addAll(m.friendNeighbours());
                    }
                    finalChain.addAll(opponentChain);
                    i++;
                }
            }
            Set<Intersection> totalNeighbours = new LinkedHashSet<>(
                    getOuterNeighbour(finalChain, opponent));
            int surrounded = 0;
            for (Intersection k : totalNeighbours) {
                if (k.getState() == player) {
                    surrounded++;
                }
            }
            if (surrounded == totalNeighbours.size()) {
                deadChain.addAll(finalChain);
            }
        }
        return deadChain;
    }

    /**
     * This is similar to the killer function but checks for empty
     * spaces rather than enemy spaces. This helps calculate the
     * final score for each player.
     * @param player The player to calculate the score for.
     * @return The points they have enclosed as territory.
     */
    public Set<Intersection> scoreChecker(final Player player) {
        int territory = 0;
        Set<Intersection> deadChain = new LinkedHashSet<>();
        for (Intersection n : this.getNeighbours()) {
            Set<Intersection> finalChain = new LinkedHashSet<>();
            Set<Intersection> opponentChain = new LinkedHashSet<>();
            if (n.state == territory) {
                finalChain.add(n);
                opponentChain.addAll(n.friendNeighbours());
                finalChain.addAll(opponentChain);
                int i = 0;
                while (i < finalChain.size()) {
                    for (Intersection m : finalChain) {
                        opponentChain.addAll(m.friendNeighbours());
                    }
                    finalChain.addAll(opponentChain);
                    i++;
                }
            }
            Set<Intersection> totalNeighbours = new LinkedHashSet<>(
                    getOuterNeighbour(finalChain, territory));
            int surrounded = 0;
            for (Intersection k : totalNeighbours) {
                if (k.getState() == player.getId()) {
                    surrounded++;
                }
            }
            if (surrounded == totalNeighbours.size()) {
                deadChain.addAll(finalChain);
            }
        }
        return deadChain;
    }
}
