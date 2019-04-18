package go.core;

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

        root.setOnMouseClicked(event -> {
            int xPosition = (int) Math.rint(event.getSceneX() / boardScalingFactor);
            int yPosition = (int) Math.rint(event.getSceneY() / boardScalingFactor);
            // TODO FIX THE OUT OF BOUNDS ERRORS FOR -1 AND 9.
                if (board.getIntersectionState(xPosition - 1, yPosition - 1) == 0) {
                    board.setIntersectionState(xPosition - 1, yPosition - 1, 1);

                    Circle circle = new Circle(xPosition * boardScalingFactor,
                            yPosition * boardScalingFactor, 35, Color.BLACK);
                    root.getChildren().addAll(circle);
                }
                /*
                System.out.println("(" + xPosition + ", " + yPosition + ")");
                System.out.println("(" + event.getSceneX() + ", "
                + event.getSceneY() + ")");
                */
            });
        return root;
    }
    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
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

    /**
     * The main function to run the javafx.
     * @param args Takes the args?
     */
    public static void main(final String[] args) {
        launch(args);
    }
    @Override
    public void handle(final ActionEvent event) {
        // TODO Auto-generated method stub

    }

}
