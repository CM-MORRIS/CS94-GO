package com.Go94;

import javafx.beans.property.*;

public class LeaderBoardData {

    private StringProperty username = new SimpleStringProperty();
    private IntegerProperty wins = new SimpleIntegerProperty();
    private IntegerProperty loss = new SimpleIntegerProperty();
    private IntegerProperty winPercentage = new SimpleIntegerProperty();

    public StringProperty usernameProperty() {
        return username;
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String name) {
        this.username.set(name);
    }

    public IntegerProperty userWinsProperty() {
        return wins;
    }

    public int getUserWins() {
        return wins.get();
    }

    public void setUserWins(int wins) {
        this.wins.set(wins);
    }

    public IntegerProperty userLossProperty() {
        return loss;
    }

    public int getUserLoss() {
        return loss.get();
    }

    public void setUserLoss(int loss) {
        this.loss.set(loss);
    }

    public IntegerProperty winPercentProperty() {
        return winPercentage;
    }

    public int getWinPercentage() {
        return winPercentage.get();
    }

    public void setWinPercentage(int percent) {
        this.winPercentage.set(percent);
    }

}
