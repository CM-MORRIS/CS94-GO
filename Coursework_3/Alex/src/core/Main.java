package core;

import javafx.application.Application;

/**
 * The Main class for running the Go game.
 * @author Alex Mair
 */
public class Main {
    public static void main(final String[] args) {
        newGame(9);
        Application.launch(BoardHandler.class, args);


    }
    /**
     * New game method which sets up a GameBoard of a given size.
     *
     * @param size This is the size of the GameBoard
     */
    private static void newGame(final int size) { GameBoard board = new GameBoard(size, size);
    }
}
