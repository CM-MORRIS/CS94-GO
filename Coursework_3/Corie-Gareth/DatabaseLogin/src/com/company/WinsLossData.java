package com.company;

import javafx.beans.property.*;

public class WinsLossData {

    private IntegerProperty wins = new SimpleIntegerProperty();
    private IntegerProperty loss = new SimpleIntegerProperty();


    public IntegerProperty userWinsProperty() {
        return wins;
    }

    public int getUserWins() {
        return wins.get();
    }

    public void setUserWins(int win) {
        this.wins.set(win);
    }

    public IntegerProperty userLossProperty() {
        return loss;
    }

    public int getLoss() {
        return loss.get();
    }

    public void setUserLoss(int losses) {
        this.loss.set(losses);
    }



}
