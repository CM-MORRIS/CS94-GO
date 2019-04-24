package com.Go94;

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
     * GameLogic constructor.
     *
     * @param p1 String of player 1's name.
     * @param p2 String of player 2's name.
     */
    public GameLogic(final Player p1, final Player p2) {
        player1 = p1;
        player2 = p2;
        turnCounter = 1;
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
     * Method to set the turncounter.
     * @param turnCounter The new value for the turn counter.
     */
    public void setTurnCounter(final int turnCounter) {
        this.turnCounter = turnCounter;
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
}
