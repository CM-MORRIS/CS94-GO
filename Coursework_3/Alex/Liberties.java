package go.core;

/* TODO MAYBE MAKE THIS A LIBERTIES CLASS WHICH TAKES IN THE BOARD AND POSITION
    AND THEN JUST HAS THE NUMBER OF LIBERTIES AT THAT POSITION.
 */

/**
 * Liberties class to keep track of and update the number
 * of liberties that each space on the board has.
 * @author Alex Mair
 */
public class Liberties {

    /**
     * Liberties instance variable to store the total liberties
     * of each space.
     */
    private int[][] liberties;

    /**
     * Liberties constructor which sets the liberties for
     * all spaces at the start of the game.
     * @param board This is the current board being
     *              played on.
     */
    public Liberties(final GameBoard board) {
        final int x = board.getWidth();
        final int y = board.getHeight();
        liberties = new int[x][y];
        for (int i = 0; i < y; i++) {
            System.out.println();
            for (int j = 0; j < x; j++) {
                if (i == 0 && j == 0 || i == y - 1 && j == x - 1
                        || i == 0 && j == x - 1 || i == y - 1 && j == 0) {
                    liberties[i][j] = 2;
                } else if ((i == 0 || i == y - 1 && j != x - 1 && j != 0)
                        || (j == x - 1 || j == 0 && i != 0 && i != y - 1)) {
                    liberties[i][j] = 3;
                } else {
                    liberties[i][j] = 4;
                }
                System.out.print(liberties[i][j] + " ");
            }
        }
    }

    /**
     * To get the liberties for any given co-ordinate.
     * @param x The x co-ordinate.
     * @param y The y co-ordinate.
     * @return the total number of liberties in that space.
     */
    public int getLiberties(final int x, final int y) {
        return liberties[x][y];
    }

    /**
     * Method to set the number of liberties at a space.
     * @param x The x co-ordinate.
     * @param y The y co-ordinate.
     * @param z The value to change the number of liberties by,
     *          either increase or decrease.
     */
    public void setLiberties(final int x, final int y, final int z) {
        liberties[x][y] = liberties[x][y] + z;
    }
}
