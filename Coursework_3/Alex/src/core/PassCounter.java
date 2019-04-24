package core;

/**
 * The PassCounter class is used to keep track of how many moves
 * have been passed and whether two have occurred in succession.
 * @author Alex Mair
 */
public class PassCounter {

    /**
     * The current turn the pass button was clicked on.
     */
    private int currentPass;

    /**
     * The previous turn the pass button was clicked on.
     */
    private int lastPass;

    /**
     * Constructor to set the default values for the counter.
     */
    public PassCounter() {
        currentPass = 0;
        lastPass = 0;
    }

    /**
     * Method to set the current pass turn.
     * @param currentPass The current turn passed.
     */
    public void setCurrentPass(final int currentPass) {
        this.currentPass = currentPass;
    }

    /**
     * Method to set the last turn that was passed.
     * @param lastPass The last turn that was passed.
     */
    public void setLastPass(final int lastPass) {
        this.lastPass = lastPass;
    }

    /**
     * Method to get the current pass turn.
     * @return The current pass turn.
     */
    public int getCurrentPass() {
        return currentPass;
    }

    /**
     * Checks to see whether two passes have occurred simultaneously.
     * @return true if two passes have occurred simultaneously.
     */
    public boolean endOfGame() {
        if (this.lastPass == this.currentPass - 1) {
            return true;
        }
        return false;
    }
}
