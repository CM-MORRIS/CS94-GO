package core;
/**
 * GameBoard holds the board dimensions and handles counter placement.
 *
 * @author Alex Mair
 * @version 1.6
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
                intersections[j][i] = new Intersection(this.height, j, i);
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
     * Gets the intersection state for a given intersection.
     * @param x the x coordinate of the intersection.
     * @param y the y coordinate of the intersection.
     * @return the state of the intersection.
     */
    public int getIntersectionState(final int x, final int y) {
        return intersections[x][y].getState();
    }

    /**
     * Sets the state for a given intersection.
     * @param x the x coordinate of the intersection.
     * @param y the y coordinate of the intersection.
     * @param state is the state to set the intersection to.
     */
    public void setIntersectionState(final int x, final int y,
                                     final int state) {
        intersections[x][y].setState(state);
    }

    public boolean isCaptured(final int x, final int y) {
        boolean surrounded = false;
        int owner = intersections[x][y].getState();
        if (intersections[x-1][y].getState() == 2 || intersections[x][y-1].getState() == 2
            || intersections[x+1][y].getState() == 2 || intersections[x][y+1].getState() == 2) {
            surrounded = true;
        }
        return surrounded;
    }

    public boolean legalMove(final int x, final int y, GameLogic game) {
        int player = game.whosTurn();
        int opponent = game.notTheirTurn();
        if (intersections[x-1][y].getState() == opponent  && intersections[x][y-1].getState() == opponent
                && intersections[x+1][y].getState() == opponent && intersections[x][y+1].getState() == opponent) {
            return false;
        } else {
            return true;
        }

    }

    public boolean onBoard(final int x, final int y) {
        return (x >= 0 && x < width && y >= 0 && y < width);
    }

}

