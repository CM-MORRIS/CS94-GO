package go.core;

public class TurnCounter {

    private int turn;

    public TurnCounter() {
        turn = 0;
    }

    public int getTurn() {
        return turn;
    }

    public void incrementTurn() {
        turn += 1;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
