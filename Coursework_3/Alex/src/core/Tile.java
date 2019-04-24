package com.company;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Class to build tiles for the Go_Board.
 *
 * @author Will Davies and Alex Mair
 */
public class Tile extends StackPane {

    /**
     * Constructor to make the tiles that make up the gameboard.
     * @param size This is the size of the gameboard scaling factor.
     */
    public Tile(final int size) {
        Rectangle boarder = new Rectangle(size, size);
        boarder.setFill(Color.BEIGE);
        boarder.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(boarder);
    }
}
