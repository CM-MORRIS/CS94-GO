package core;

import java.util.HashSet;
import java.util.Set;

public class StoneChain {

    private Set<Intersection> stones;

    private final int owner;

    private Set<Intersection> liberties;

    public StoneChain (Intersection intersection, GameLogic game) {
        owner = game.whosTurn();
        stones = new HashSet<>();
        stones.add(intersection);
        liberties = new HashSet<>();
        for (Intersection n : intersection.getNeighbours()) {
            if (n.getState() == 0) {
                liberties.add(n);
            }
        }
    }

    public StoneChain (Set<Intersection> stones, Set<Intersection> liberties, int owner) {
        this.stones = stones;
        this.liberties = liberties;
        this.owner = owner;
    }

    public int getOwner() {
        return owner;
    }


    public Set<Intersection> getStones() {
        return stones;
    }

    public Set<Intersection> getLiberties() {
        return liberties;
    }

    /**
     * Adds a second StoneChain to the current StoneChain taking into account the stone that was played.
     * @param playedStone the stone played this turn.
     */
    public void add(Intersection playedStone){
        this.stones.addAll(playedStone.getStoneChain().getStones());
        this.liberties.addAll(playedStone.getStoneChain().getLiberties());
        this.liberties.remove(playedStone);
    }

    /**
     * Method to remove a liberty from the stonechain.
     * @param playedStone the stone played
     * @return a newStoneChain with the liberty removed.
     */
    public StoneChain removeLiberty(Intersection playedStone) {
        this.liberties.remove(playedStone);
        return this;
    }

    /**
     *TODO FIX THIS
     * This does something, but I don't know what.
     * @param board
     */
    public void die(GameBoard board) {
        for (Intersection placedStone : this.stones) {
            placedStone.setStoneChain(null);
            Set<StoneChain> adjacentStoneChains = placedStone.getAdjacentStoneChains();
            for (StoneChain stoneChain : adjacentStoneChains) {
                stoneChain.liberties.add(placedStone);
            }
        }
    }
}
