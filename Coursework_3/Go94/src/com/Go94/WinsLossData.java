package com.Go94;

import javafx.beans.property.*;

/**
 * The class which allows for the data from the database
 * to be used within the javafx tables.
 *
 * @author Corie Morris
 */
class WinsLossData {

    /**
     * The wins for a user.
     */
    private final IntegerProperty wins = new SimpleIntegerProperty();

    /**
     * The losses for a user.
     */
    private final IntegerProperty loss = new SimpleIntegerProperty();

    /**
     *  Returns how many wins the user has.
     * @return The number of wins.
     */
    public IntegerProperty userWinsProperty() {
        return wins;
    }

    /**
     * Returns how many losses the user has.
     * @return The number of losses.
     */
    public IntegerProperty userLossProperty() {
        return loss;
    }

    /**
     *  sets win as the int after it has been passed to a string.
     *
     * @param wins The number of wins.
     */
    public void setUserWins(final int wins) {
        this.wins.set(wins);
    }

    /**
     *  sets loss as the int after it has been passed to a string.
     *
     * @param loss The number of losses.
     */
    public void setUserLoss(final int loss) {
        this.loss.set(loss);
    }

}
