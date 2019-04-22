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
    private final Intersection[][] intersections;

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
        if (! onBoard(intersection.getxPosition(), intersection.getyPosition())) {
            return false;
        } else if (intersection.getState() != 0) {
            return false;
        } else if (this.isSuicide(intersection, game)) {
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
}
