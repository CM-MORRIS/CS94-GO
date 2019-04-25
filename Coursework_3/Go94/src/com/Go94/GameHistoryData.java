package com.Go94;

import javafx.beans.property.*;

/**
 * The class which allows for the data from the database to be used within the javafx tables
 *
 * @author Corie Morris
 */
public class GameHistoryData {

    /**
     * Each variable which will allow for a property to show for each element of the gamehistory
     */
    private StringProperty player1 = new SimpleStringProperty();
    private StringProperty player2 = new SimpleStringProperty();
    private StringProperty winner = new SimpleStringProperty();


    public StringProperty player1Property() {
        return player1;
    }
    public String getPlayer1() {
        return player1.get();
    }
    public void setPlayer1(String player1) {
        this.player1.set(player1);
    }


    public StringProperty player2Property() {
        return player2;
    }
    public String getPlayer2() {
        return player2.get();
    }
    public void setPlayer2(String player2) {
        this.player2.set(player2);
    }


    public StringProperty winnerProperty() {
        return winner;
    }
    public String getWinner() {
        return winner.get();
    }
    public void setWinner(String winner) {
        this.winner.set(winner);
    }

}
