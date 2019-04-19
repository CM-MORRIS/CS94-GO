package core;

import java.util.HashSet;
import java.util.Set;

public class StoneChain {

    private final Set<Intersection> stones;

    private final int owner;

    public StoneChain(Set<Intersection> stones, int owner) {
        this.stones = stones;
        this.owner = owner;
    }

    public StoneChain(Intersection intersection, int owner) {
        stones = new HashSet<>();
        stones.add(intersection);
        this.owner = owner;
    }

    public StoneChain(StoneChain stoneChain) {
        this.stones = new HashSet<>(stoneChain.stones);
        this.owner = stoneChain.owner;
    }

    public int getOwner() {
        return owner;
    }

    public Set<Intersection> getStones() {
        return stones;
    }

    /**
     * Adds a second StoneChain to the current StoneChain taking into account the stone that was played.
     * @param stoneChain the second StoneChain.
     * @param playedStone the stone played this turn.
     */
    public void add(StoneChain stoneChain, Intersection playedStone) {
        this.stones.addAll(stoneChain.stones);
    }

}
