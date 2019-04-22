package core;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 * The BoardHandler class deals with the JavaFX implementations
 * of the GameBoard.
 *
 * @author Will Davies and Alex Mair
 */
public class BoardHandler extends Application
        implements EventHandler<ActionEvent> {

    /**
     * Producing a new GameBoard to be used within the JavaFX program.
     */
    private GameBoard board = new GameBoard(9, 9);

    private Player P1 = new Player("Alex", 1);

    private Player P2 = new Player("Will", 2);

    /**
     * Producing a GameLogic instance to track players.
     */
    private GameLogic game = new GameLogic(P1.getName(), P2.getName());

    /**
     * Scaling factor for the board to make it display correctly.
     */
    public static final int BOARD_SCALING_FACTOR = 100;

    /**
     * Parent to display the pane and the content on.
     *
     * @return Information to go on the scene.
     */
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(1000, 1000);

        for (int i = 1; i < board.getHeight(); i++) {
            for (int j = 1; j < board.getWidth(); j++) {
                Tile tile = new Tile();
                tile.setTranslateX(j * BOARD_SCALING_FACTOR);
                tile.setTranslateY(i * BOARD_SCALING_FACTOR);
                root.getChildren().addAll(tile);
            }
        }

        Circle[][] circles = new Circle[board.getWidth()][board.getHeight()];

        //To track
        root.setOnMouseClicked(event -> {
            int xPosPane = (int) Math.rint(event.getSceneX()
                    / BOARD_SCALING_FACTOR);
            int yPosPane = (int) Math.rint(event.getSceneY()
                    / BOARD_SCALING_FACTOR);
            final int xPos = xPosPane - 1;
            final int yPos = yPosPane - 1;
            if (xPosPane > 0 && xPosPane < board.getWidth() + 1 && yPosPane > 0
                    && yPosPane < board.getHeight() + 1) {
                if (board.playMove(board.getIntersection(xPos, yPos), game)) {
                    circles[xPos][yPos] = new Circle(xPosPane * BOARD_SCALING_FACTOR,
                            yPosPane * BOARD_SCALING_FACTOR, 35, Color.BLACK);
                    circles[xPos][yPos].setStroke(Color.BLACK);
                    if (game.whosTurn() == 2) {
                        circles[xPos][yPos].setFill(Color.WHITE);
                    }
                    root.getChildren().add(circles[xPos][yPos]);
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
}
