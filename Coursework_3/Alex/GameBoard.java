package go.core;

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
    private final int[][][] intersections;

    /**
     * The GameBoard constructor that makes the actual GameBoard
     * with given height and width inputs.
     * @param w This is the width of the board.
     * @param h This is the height of the board.
     */
    public GameBoard(final int w, final int h) {
        width = w;
        height = h;
        intersections = new int[width][height][1];
        for (int i = 0; i < height; i++) {
            System.out.println();
            for (int j = 0; j < width; j++) {
                if (i == 3 && j == 0) {
                    intersections[i][j][0] = 1;
                }
                    //System.out.print(intersections[i][j][0] + " ");
            }
        }
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
     * Method to get the state at the intersection, 1 to 9.
     * @param x This is the position of the intersection on the width.
     * @param y This is the position of the intersection on the height.
     * @return This returns the state in the intersection position.
     */
    public int getIntersectionState(final int x, final int y) {
        return intersections[x-1][y-1][0];
    }


}
