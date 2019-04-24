package com.Go94;

/**
 * The player class for tracking the details of each player.
 *
 * @author Alex Mair and Will Davies.
 */
public class Player {

    /**
     * The players name.
     */
    private final String name;

    /**
     * The ID for the player for this game.
     */
    private final int id;

    /**
     * How many stones the player captured during the game.
     */
    private int stonesWon;

    /**
     * How many stones the player had captured from them
     * during the game.
     */
    private int stonesLost;

    /**
     *
     */
    private int score;

    /**
     * Constructor for the Player class.
     *
     * @param name The name of the Player.
     * @param id   Their ID for this game.
     */
    public Player(final String name, final int id) {
        this.name = name;
        this.id = id;
        stonesWon = 0;
        stonesLost = 0;
        score = 0;
    }

    /**
     * Method to return the Players ID.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Method to get the stones the player has won.
     *
     * @return The number of stones that were won.
     */
    public int getStonesWon() {
        return stonesWon;
    }

    /**
     * Method to get the stones that the player has lost.
     *
     * @return The number of stones that were lost.
     */
    public int getStonesLost() {
        return stonesLost;
    }

    /**
     * Method to get the player name.
     *
     * @return Player name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method to add to the stones the player has won.
     *
     * @param won The number of stones the player has won.
     */
    public void addStonesWon(final int won) {
        stonesWon += won;
    }

    /**
     * Method to add to the stones the player has lost.
     *
     * @param lost The number of stones the player has lost.
     */
    public void addStonesLost(final int lost) {
        stonesLost -= lost;
    }

    /**
     * Method to get the score for the player.
     *
     * @return The player's score.
     */
    public int getScore() {
        return score;
    }

    /**
     * Method to set the score for a player.
     *
     * @param newScore The new score for the player.
     */
    public void setScore(final int newScore) {
        score = newScore;
    }
}
