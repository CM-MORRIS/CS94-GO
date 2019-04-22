package core;

/**
 * GameLogic class for handling the turns and passes.
 * Who the players are and what board they're playing on.
 *
 * @author Alex Mair and Will Davies
 */
public class GameLogic {

    /**
     * Player 1.
     */
    private Player player1;

    /**
     * Player 2.
     */
    private Player player2;

    /**
     * Counter to keep track of the turns in the game.
     */
    private int turnCounter;

    /**
     * Counter to keep track of the passed turns that have occurred.
     */
    private int passCounter;

    /**
     * Winner of the Game.
     */
    private int winner;

    /**
     * GameLogic constructor.
     *
     * @param p1 String of player 1's name.
     * @param p2 String of player 2's name.
     */
    public GameLogic(final Player p1, final Player p2) {
        player1 = p1;
        player2 = p2;
        passCounter = 0;
        turnCounter = 1;
        winner = 0;
    }

    /**
     * Method to increment the pass counter.
     * Needs to force the end of the game is the counter reaches 2.
     */
    public void incrementPassCounter() {
        ++passCounter;
        /*if (passCounter >= 2) {
            TODO THIS IS WHERE WE PUT THE END GAME FUNCTION
        }
         */
    }

    /**
     * Method to increment the turn counter.
     */
    public void incrementTurnCounter() {
        turnCounter++;
    }

    /**
     * Method to get the current turn counter.
     *
     * @return turnCounter
     */
    public int getTurnCounter() {
        return turnCounter;
    }

    /**
     * Method to get the current pass counter.
     *
     * @return passCounter
     * I DON'T KNOW IF THIS IS NEEDED AS IT MAY BE
     * HANDLED IN INCREMENT PASS COUNTER.
     */
    public int getPassCounter() {
        return passCounter;
    }

    /**
     * Method to get the first players name.
     *
     * @return player1
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Method to get the second players name.
     *
     * @return player2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Method to check who's turn in the game it is currently.
     *
     * @return the current player
     */
    public int whosTurn() {
        if (turnCounter % 2 == 0) {
            return player2.getId();
        } else {
            return player1.getId();
        }
    }

    /**
     * Method to see who the opponent is.
     *
     * @return the opponent
     */
    public int opponent() {
        if (turnCounter % 2 == 0) {
            return player1.getId();
        } else {
            return player2.getId();
        }
    }

    /**
     * Method to set the winner of the game.
     *
     * @param winner The winner of the game.
     */
    public void setWinner(final int winner) {
        this.winner = winner;
    }

    /**
     * Method to get the winner of the game.
     *
     * @return The winner of the game.
     */
    public int getWinner() {
        return winner;
    }
}
