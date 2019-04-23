package core;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Class to build tiles for the Go_Board of 19*19.
 *
 * @author Will Davies
 */
public class Tile19 extends StackPane {

    /**
     * Constructor to make the tiles that make up the gameboard.
     */
    public Tile19() {
        Rectangle boarder = new Rectangle(BoardHandler13.BOARD_SCALING_FACTOR,
                BoardHandler13.BOARD_SCALING_FACTOR);
        boarder.setFill(Color.BEIGE);
        boarder.setStroke(Color.BLACK);
        setAlignment(Pos.CENTER);
        getChildren().addAll(boarder);
    }
}
