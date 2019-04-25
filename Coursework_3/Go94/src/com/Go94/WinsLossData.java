package com.Go94;

import javafx.beans.property.*;


/**
 * The class which allows for the data from the database to be used within the javafx tables
 *
 * @author Corie Morris
 */
public class WinsLossData {

    
    /**
     * Each variable which will allow for a property to show for each element of the leaderboard
     */
    private IntegerProperty wins = new SimpleIntegerProperty();
    private IntegerProperty loss = new SimpleIntegerProperty();
    
    /**
     * Element needing to be displayed
     *
     * @return the wins and losses
     */
    public IntegerProperty userWinsProperty() { return wins; }

    public IntegerProperty userLossProperty() { return loss; }


    /**
     *  sets win as the int after it has been passed to a string.
     *
     * @param wins
     */
    public void setUserWins(int wins) {
        this.wins.set(wins);
    }

    /**
     *  sets loss as the int after it has been passed to a string.
     *
     * @param loss
     */
    public void setUserLoss(int loss) { this.loss.set(loss); }


    /**
     * Gets the property for the wins and losses and returns
     *
     * @return the win/loss after passed through the DB
     */
    public int getUserWins() { return wins.get(); }

    public int getLoss() {
        return loss.get();
    }

}
