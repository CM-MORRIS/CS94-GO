package com.company;

import javafx.beans.property.*;

public class LeaderBoardData {

    private StringProperty username = new SimpleStringProperty();
    private IntegerProperty wins = new SimpleIntegerProperty();
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

    public IntegerProperty winPercentProperty() {
        return winPercentage;
    }

    public int getWinPercentage() {
        return winPercentage.get();
    }

    public void setWinPercentage(int percent) {
        this.winPercentage.set(percent);
    }

//    public SimpleStringProperty username;
//    public SimpleIntegerProperty wins;
//    public SimpleIntegerProperty winPercentage;
//
//
//    public LeaderBoardData(String username, int wins, int winPercentage) {
//        this.username = new SimpleStringProperty(username);
//        this.wins = new SimpleIntegerProperty(wins);
//        this.winPercentage = new SimpleIntegerProperty(winPercentage);
//    }
//
//
//    public String getUsername() {
//        return username.get();
//    }
//
//
//
//    public Integer getUserWins() {
//        return wins.get();
//    }
//
//
//
//    public Integer getWinPercentage() {
//        return winPercentage.get();
//    }



}
