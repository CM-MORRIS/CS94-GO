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
    private GameLogic game = new GameLogic("Alex", "Will");

    /**
     * Parent to display the pane and the content on.
     * @return Information to go on the scene.
     */
    private Parent createContent() {
        final int boardScalingFactor = 100;

        Pane root = new Pane();

        root.setPrefSize(1000, 1000);

        for (int i = 1; i < board.getHeight(); ++i) {
            for (int j = 1; j < board.getWidth(); ++j) {
                Tile tile = new Tile();
                tile.setTranslateX(j * boardScalingFactor);
                tile.setTranslateY(i * boardScalingFactor);
                root.getChildren().addAll(tile);
            }
        }

        Circle[][] circles = new Circle[board.getWidth()][board.getHeight()];
        root.setOnMouseClicked(event -> {
            int xPosPane = (int) Math.rint(event.getSceneX()
                    / boardScalingFactor);
            int yPosPane = (int) Math.rint(event.getSceneY()
                    / boardScalingFactor);
            final int xPos = xPosPane - 1;
            final int yPos = yPosPane - 1;
            if (xPosPane > 0 && xPosPane < board.getWidth() + 1 && yPosPane > 0
                    && yPosPane < board.getHeight() + 1) {
                if (board.playMove(board.getIntersection(xPos, yPos), game)) {
                    circles[xPos][yPos] = new Circle(xPosPane * boardScalingFactor,
                            yPosPane * boardScalingFactor, 35, Color.BLACK);
                    circles[xPos][yPos].setStroke(Color.BLACK);
                    if (game.whosTurn() == 2) {
                        circles[xPos][yPos].setFill(Color.WHITE);
                    }
                    root.getChildren().add(circles[xPos][yPos]);
                    //board.getIntersection(xPos, yPos).setState(game.whosTurn());

//                    for (Intersection n : board.boardDead()) {
//                        root.getChildren().remove(circles[n.getxPosition()][n.getyPosition()]);
//                    }
                    for (Intersection n : board.getIntersection(xPos, yPos).killer(game)) {
                        root.getChildren().remove(circles[n.getxPosition()][n.getyPosition()]);
                        n.setState(0);
                    }
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
