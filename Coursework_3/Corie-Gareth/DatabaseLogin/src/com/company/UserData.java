package com.company;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserData {

    public SimpleStringProperty username;
    public SimpleIntegerProperty wins;
    public SimpleIntegerProperty winPercentage;


//    public UserData(String username, int wins, int winPercentage) {
//        this.username = new SimpleStringProperty(username);
//        this.wins = new SimpleIntegerProperty(wins);
//        this.winPercentage = new SimpleIntegerProperty(winPercentage);
//    }



    public String getUsername() {
        return username.get();
    }



    public Integer getUserWins() {
        return wins.get();
    }



    public Integer getWinPercent() {
        return winPercentage.get();
    }



}
