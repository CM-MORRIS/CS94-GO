package com.Go94;

import javafx.beans.property.*;

/**
 * The class which allows for the data from the database to be used within the javafx tables
 *
 * @author Corie Morris
 */
public class LeaderBoardData {

    /**
     * Each variable which will allow for a property to show for each element of the leaderboard
     */
    private StringProperty username = new SimpleStringProperty();
    private DoubleProperty wins = new SimpleDoubleProperty();
    private DoubleProperty loss = new SimpleDoubleProperty();
    private DoubleProperty winPercentage = new SimpleDoubleProperty();

    /**
     * Essentially the same 3 functions for each element needing to be displayed
     *
     * @return the username from the DB
     */
    public StringProperty usernameProperty() {
        return username;
    }

    /**
     * Gets the property for the initial username and returns as a string
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
    public void setUsername(String name) {
        this.username.set(name);
    }

    public DoubleProperty userWinsProperty() {
        return wins;
    }

    public double getUserWins() {
        return wins.get();
    }

    public void setUserWins(double wins) {
        this.wins.set(wins);
    }

    public DoubleProperty userLossProperty() {
        return loss;
    }

    public double getUserLoss() {
        return loss.get();
    }

    public void setUserLoss(double loss) {
        this.loss.set(loss);
    }

    public DoubleProperty winPercentProperty() {
        return winPercentage;
    }

    public double getWinPercentage() {
        return winPercentage.get();
    }

    public void setWinPercentage(double percent) {
        this.winPercentage.set(percent);
    }

}
