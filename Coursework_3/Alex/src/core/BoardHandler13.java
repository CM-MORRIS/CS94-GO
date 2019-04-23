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
 * of the GameBoard 13*13 in size.
 *
 * @author Will Davies and Alex Mair
 */
public class BoardHandler13 extends Application
        implements EventHandler<ActionEvent> {

    /**
     * Producing a new GameBoard to be used within the JavaFX program.
     */
    private GameBoard board = new GameBoard(13, 13);

    /**
     * The first player of the game.
     */
    private Player p1 = new Player("Alex", 1);

    /**
     * The second player of the game.
     */
    private Player p2 = new Player("Will", 2);

    /**
     * Producing a GameLogic instance to track players.
     */
    private GameLogic game = new GameLogic(p1, p2);

    /**
     * Scaling factor for the board to make it display correctly.
     */
    public static final int BOARD_SCALING_FACTOR = 80;

    /**
     * Parent to display the pane and the content on.
     *
     * @return Information to go on the scene.
     */
    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(1100, 1100);

        for (int i = 1; i < board.getHeight(); i++) {
            for (int j = 1; j < board.getWidth(); j++) {
                Tile13 tile = new Tile13();
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
                        if (game.whosTurn() == 1) {
                            p1.addStonesWon(1);
                            p2.addStonesLost(1);
                        } else {
                            p2.addStonesWon(1);
                            p1.addStonesLost(1);
                        }
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