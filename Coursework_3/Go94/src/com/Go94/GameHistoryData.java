package com.Go94;

import javafx.beans.property.*;

/**
 * The class which allows for the data from the database to be used within the javafx tables.
 *
 * @author Corie Morris
 */
public class GameHistoryData {

    /**
     * Each variable which will allow for a property to show player 1 gamehistory.
     */
    private StringProperty player1 = new SimpleStringProperty();

    /**
     * Each variable which will allow for a property to show player 2 gamehistory.
     */
    private StringProperty player2 = new SimpleStringProperty();

    /**
     * Each variable which will allow for a property to show the winner gamehistory.
     */
    private StringProperty winner = new SimpleStringProperty();


    /**
     * Player 1 property for the database.
     * @return the first player.
     */
    public StringProperty player1Property() {
        return player1;
    }

    /**
     * Player 1 for the project.
     * @return the first player.
     */
    public String getPlayer1() {
        return player1.get();
    }

    /**
     * Set player 1's name.
     * @param player1 The players name.
     */
    public void setPlayer1(final String player1) {
        this.player1.set(player1);
    }

    /**
     * Player 2 property for the database.
     * @return The player 2 property.
     */
    public StringProperty player2Property() {
        return player2;
    }

    /**
     * Gets player two's name for the table.
     * @return Player two's name.
     */
    public String getPlayer2() {
        return player2.get();
    }

    /**
     * Sets player two's name.
     * @param player2 the players name.
     */
    public void setPlayer2(final String player2) {
        this.player2.set(player2);
    }


    /**
     * The winner property for the SQL database.
     * @return the winner.
     */
    public StringProperty winnerProperty() {
        return winner;
    }

    /**
     * Set winner method for the the code.
     * @param winner the winners name.
     */
    public void setWinner(final String winner) {
        this.winner.set(winner);
    }
}
