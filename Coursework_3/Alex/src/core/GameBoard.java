package core;

/**
 * GameBoard holds the board dimensions and handles counter placement.
 *
 * @author Alex Mair and Will Davies
 */
public class GameBoard {

    /**
     * The width of the board.
     */
    private final int width;

    /**
     * The height of the board.
     */
    private final int height;

    /**
     * Contains all intersections on the board.
     */
    private Intersection[][] intersections;

    /**
     * The GameBoard constructor that makes the actual GameBoard
     * with given height and width inputs.
     *
     * @param w This is the width of the board.
     * @param h This is the height of the board.
     */
    public GameBoard(final int w, final int h) {
        width = w;
        height = h;
        intersections = new Intersection[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                intersections[j][i] = new Intersection(this, j, i);
                //makes all the intersections.
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                intersections[j][i].setNeighbours();
                //assigns neighbours to all intersections.
            }
        }
    }

    /**
     * Method to get width of board.
     *
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method to get the height of the board.
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Method to return all the intersections on the board.
     * @return All of the intersections.
     */
    public Intersection[][] getIntersections() {
        return intersections;
    }

    /**
     * Set the intersections of a board.
     * @param newIntersections The new intersections.
     */
    public void setIntersections(final Intersection[][] newIntersections) {
        intersections = newIntersections;
    }

    /**
     * Method to get the intersection at a given point.
     *
     * @param x The x coordinate.
     * @param y The y coordinate.
     * @return The intersection.
     */
    public Intersection getIntersection(final int x, final int y) {
        return intersections[x][y];
    }

    /**
     * Gets the intersection state for a given intersection.
     *
     * @param x the x coordinate of the intersection.
     * @param y the y coordinate of the intersection.
     * @return the state of the intersection.
     */
    public int getIntersectionState(final int x, final int y) {
        return intersections[x][y].getState();
    }

    /**
     * Sets the state for a given intersection.
     *
     * @param x     the x coordinate of the intersection.
     * @param y     the y coordinate of the intersection.
     * @param state is the state to set the intersection to.
     */
    public void setIntersectionState(final int x, final int y,
                                     final int state) {
        intersections[x][y].setState(state);
    }

    /**
     * Checks to see if the liberties surround the space are
     * occupied by the opponent.
     *
     * @param intersection This is the space that has been clicked
     *                     to be played upon.
     * @param game         This is the current state of the game.
     * @return true or false
     */
    public boolean isSuicide(final Intersection intersection, final GameLogic game) {
        for (Intersection n : intersection.getNeighbours()) {
            if (n.getState() != game.opponent()) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks whether the move is legal and then updates the stone chains
     * and states for the move.
     *
     * @param intersection the point that is being played on.
     * @param game         the state of the game.
     * @return true if the move is legal and can be done.
     */
    public boolean playMove(final Intersection intersection, final GameLogic game) {
        final int originalState = intersection.getState();
        intersection.setState(game.whosTurn());
        final int takingState =  intersection.killer(game).size();
        intersection.setState(originalState);
        if (!onBoard(intersection.getxPosition(), intersection.getyPosition())) {
            return false;
        } else if (intersection.getState() != 0) {
            return false;
        } else if (isSuicide(intersection, game) && takingState == 0) {
            return false;
        } else {
            intersection.setState(game.whosTurn());
        }
        return true;
    }

    /**
     * Check to see if something is within the board parameters.
     *
     * @param x The x coordinate to check.
     * @param y The y coordinate to check.
     * @return true or false
     */
    public boolean onBoard(final int x, final int y) {
        return (x >= 0 && x < width && y >= 0 && y < width);
    }

    /**
     * Calculates the surrounded spaces for player 1.
     * @param player1 The player surrounding the spaces.
     * @return Player 1's score.
     */
    public int p1ScoreCalculator(final Player player1) {
        int p1Score = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (intersections[j][i].getState() == 1) {
                    for (Intersection n : intersections[j][i].scoreChecker(player1)) {
                        n.setState(3);
                        p1Score++;
                    }
                }
            }
        }
        player1.setScore(p1Score);
        return p1Score;
    }

    /**
     Calculates the surrounded spaces for player 2.
     * @param player2 The player surrounding the spaces.
     * @return Player 2's score.
     */
    public int p2ScoreCalculator(final Player player2) {
        int p2Score = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (intersections[j][i].getState() == 2) {
                    for (Intersection n : intersections[j][i].scoreChecker(player2)) {
                        n.setState(3);
                        p2Score++;
                    }
                }
            }
        }
        return p2Score;
    }



/*
    Due to the many variations of the Ko rule, we as a group have decided
    to leave this rule unused. The most common rule for Ko is that
    the two players both accept to abide by Ko and as such it does
    not strictly need to be implemented. However, to do so we would
    use the following method in conjunction with a GameBoard of a previous
    state that gets updated to be the state of the board two moves prior.
    This prevents any instances of Ko being achieved.

    public boolean ko(final GameBoard previousState, final GameLogic game) {
        if (game.getTurnCounter() == 1) {
            return false;
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.getIntersectionState(j, i) != (previousState.getIntersectionState(j, i))) {
                    return false;
                }
            }
        }
        return true;
    }
 */
}
