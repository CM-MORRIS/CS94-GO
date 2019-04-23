package com.company;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Class to build tiles for the Go_Board of 9*9.
 *
 * @author Will Davies
 */
public class Tile9 extends StackPane {

    /**
     * Constructor to make the tiles that make up the gameboard.
     */
    public Tile9() {
        Rectangle boarder = new Rectangle(BoardHandler9.BOARD_SCALING_FACTOR,
                BoardHandler9.BOARD_SCALING_FACTOR);
        boarder.setFill(Color.BEIGE);
        boarder.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(boarder);
    }
}
