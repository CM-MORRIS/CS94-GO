package com.Go94;

import javafx.beans.property.*;

/**
 * The class which allows for the data from the database to
 * be used within the javafx tables.
 *
 * @author Corie Morris
 */
public class LeaderBoardData {

    /**
     * Username variable which will allow for a username to
     * show for each element of the leaderboard.
     */
    private StringProperty username = new SimpleStringProperty();

    /**
     * Wins variable which will allow for a win count to
     * show for each element of the leaderboard.
     */
    private DoubleProperty wins = new SimpleDoubleProperty();

    /**
     * Loss variable which will allow for a loss count to
     * show for each element of the leaderboard.
     */
    private DoubleProperty loss = new SimpleDoubleProperty();

    /**
     * Win Percentage variable which will allow for a win percentage to
     * show for each element of the leaderboard.
     */
    private DoubleProperty winPercentage = new SimpleDoubleProperty();

    /**
     * Essentially the same 3 functions for each element needing to be displayed.
     *
     * @return the username from the DB
     */
    public StringProperty usernameProperty() {
        return username;
    }

    /**
     * Gets the property for the initial username and returns as a string.
     *
     * @return the username after passed through the DB
     */
    public String getUsername() {
        return username.get();
    }

    /**
     * Finally sets name as the username after it has been passed to a string.
     *
     * @param name what will be set the username to be displayed.
     */
    public void setUsername(final String name) {
        this.username.set(name);
    }

    /**
     * Returns the user wins.
     * @return The number of wins.
     */
    public DoubleProperty userWinsProperty() {
        return wins;
    }

    /**
     * Sets the users win count.
     * @param wins The number of wins.
     */
    public void setUserWins(final double wins) {
        this.wins.set(wins);
    }

    /**
     * Gets the win percentage as a property.
     * @return the win percentage.
     */
    public DoubleProperty winPercentProperty() {
        return winPercentage;
    }

    /**
     * Gets the win percentage.
     * @return the win percentage.
     */
    public double getWinPercentage() {
        return winPercentage.get();
    }

    /**
     * Sets the win percentage for the user.
     * @param percent The win percentage.
     */
    public void setWinPercentage(final double percent) {
        this.winPercentage.set(percent);
    }

}
