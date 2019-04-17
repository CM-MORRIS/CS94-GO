package go.core;

/**
 * GameBoard holds the board dimensions and handles counter placement.
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
    private final int[][] intersections;

    /**
     * The GameBoard constructor that makes the actual GameBoard
     * with given height and width inputs.
     * @param w This is the width of the board.
     * @param h This is the height of the board.
     */
    public GameBoard(final int w, final int h) {
        width = w;
        height = h;
        intersections = new int[width][height];
        /*
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                System.out.print(intersections[i][j] + " ");
            }
        }
         */
    }

    /**
     * Method to get width of board.
     * @return width
     */
    public int getWidth() {
        return width;
    }

    /**
     * Method to get the height of the board.
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Method to get the state at the intersection, 0 to 8.
     * @param x This is the position of the intersection on the width.
     * @param y This is the position of the intersection on the height.
     * @return This returns the state in the intersection position.
     */
    public int getIntersectionState(final int x, final int y) {
        return intersections[x][y];
    }

    /**
     * Method to set the state at a given intersection point.
     * @param x The position of the intersection along the width.
     * @param y The position of the intersection along the height.
     * @param state The new state that the intersection point is set to.
     */
    public void setIntersectionState(final int x, final int y, final int state) {
        intersections[x][y] = state;
    }
}
