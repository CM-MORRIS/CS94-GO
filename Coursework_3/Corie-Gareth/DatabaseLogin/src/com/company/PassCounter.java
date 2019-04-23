package com.company;

public class PassCounter {

    /**
     * The current turn the pass button was clicked on.
     */
    private int currentPass;

    /**
     * The previous turn the pass button was clicked on.
     */
    private int lastPass;

    public PassCounter() {
        currentPass = 0;
        lastPass = 0;
    }

    public void setCurrentPass(int currentPass) {
        this.currentPass = currentPass;
    }

    public void setLastPass(int lastPass) {
        this.lastPass = lastPass;
    }

    public int getCurrentPass() {
        return currentPass;
    }

    public int getLastPass() {
        return lastPass;
    }

    public boolean endOfGame() {
        if (this.lastPass == this.currentPass -1) {
            return true;
        }
        return false;
    }
}
