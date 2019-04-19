package core;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

/**
 * The BoardHandler class deals with the JavaFX implementations
 * of the GameBoard.
 */
public class BoardHandler extends Application
        implements EventHandler<ActionEvent> {

    /**
     * Producing a new GameBoard to be used within the JavaFX program.
     */
    private GameBoard board = new GameBoard(9, 9);

    /**
     * Producing a GameLogic instance to track players.
     */
    private GameLogic game = new GameLogic(board, "Alex", "Will");

    /**
     * Parent to display the pane and the content on.
     * @return Information to go on the scene.
     */
    private Parent createContent() {
        final int boardScalingFactor = 100;

        Pane root = new Pane();
        root.setPrefSize(1000, 1000);

        for (int i = 1; i < 9; ++i) {
            for (int j = 1; j < 9; ++j) {
                Tile tile = new Tile();
                tile.setTranslateX(j * boardScalingFactor);
                tile.setTranslateY(i * boardScalingFactor);
                root.getChildren().addAll(tile);
            }
        }

        Circle[][] circles = new Circle[board.getWidth()][board.getHeight()];
        root.setOnMouseClicked(event -> {
            int xPosition = (int) Math.rint(event.getSceneX()
                    / boardScalingFactor);
            int yPosition = (int) Math.rint(event.getSceneY()
                    / boardScalingFactor);
            if (xPosition > 0 && xPosition < 10 && yPosition > 0
                    && yPosition < 10) {
                if (board.getIntersectionState(xPosition - 1,
                        yPosition - 1) == 0 && board.legalMove(xPosition-1, yPosition -1, game)) {
                    board.setIntersectionState(xPosition - 1,
                            yPosition - 1, game.whosTurn());

                    if (game.whosTurn() == 1) {
                        circles[xPosition-1][yPosition-1] = new Circle(xPosition * boardScalingFactor,
                                yPosition * boardScalingFactor, 35, Color.BLACK);
                        circles[xPosition-1][yPosition-1].setStroke(Color.BLACK);
                        root.getChildren().add(circles[xPosition-1][yPosition-1]);
                    } else {
                        circles[xPosition-1][yPosition-1] = new Circle(xPosition * boardScalingFactor,
                                yPosition * boardScalingFactor, 35, Color.WHITE);
                        circles[xPosition-1][yPosition-1].setStroke(Color.BLACK);
                        root.getChildren().add(circles[xPosition-1][yPosition-1]);
                    }
//                    if (board.getIntersectionState(xPosition, yPosition -1) == 1) {
//                        root.getChildren().remove(circles[xPosition][yPosition-1]);
//                    }
                    game.incrementTurnCounter();
                }
            }
        });
        return root;
    }
    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }

    @Override
    public void handle(final ActionEvent event) {

    }

    /**
     * TILE CLASS NEEDS TO GO IN IT'S OWN FILE.
     * @author Will Davies
     */
    private final class Tile extends StackPane {
        /**
         * HOW TO DO TILE. GOD I DON'T KNOW.
         */
        private Tile() {
            Rectangle boarder = new Rectangle(100, 100);
            boarder.setFill(Color.BEIGE);
            boarder.setStroke(Color.BLACK);
            setAlignment(Pos.CENTER);
            getChildren().addAll(boarder);
        }
    }
}
