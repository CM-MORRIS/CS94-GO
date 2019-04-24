package com.Go94;

import javafx.beans.property.*;

public class WinsLossData {

    private IntegerProperty wins = new SimpleIntegerProperty();
    private IntegerProperty loss = new SimpleIntegerProperty();


    public IntegerProperty userWinsProperty() { return wins; }

    public IntegerProperty userLossProperty() { return loss; }


    public void setUserWins(int wins) {
        this.wins.set(wins);
    }

    public void setUserLoss(int loss) { this.loss.set(loss); }


    public int getUserWins() { return wins.get(); }

    public int getLoss() {
        return loss.get();
    }

}
