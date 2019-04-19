package core;

public class Player {

    private final int id;

    private int takenStones;

    public Player(int id) {
        this.id = id;
        this.takenStones = 0;
    }

    public int getId() {
        return id;
    }

    public int getTakenStones() {
        return takenStones;
    }

    public void addTakenStones(int taken) {
        takenStones += taken;
    }

    public void removeTakenStones(int removed) {
        takenStones -= removed;
    }

}
