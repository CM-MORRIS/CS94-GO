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
            int xPositionPane = (int) Math.rint(event.getSceneX()
                    / boardScalingFactor);
            int yPositionPane = (int) Math.rint(event.getSceneY()
                    / boardScalingFactor);
            final int xPos = xPositionPane - 1;
            final int yPos = yPositionPane - 1;
            if (xPositionPane > 0 && xPositionPane < board.getWidth() + 1 && yPositionPane > 0
                    && yPositionPane < board.getHeight() + 1) {
                if (board.getIntersectionState(xPos,
                        yPos) == 0 && board.isSuicide(board.getIntersection(xPos, yPos), game)) {
                    board.setIntersectionState(xPos, yPos, game.whosTurn());

                    if (game.whosTurn() == 1) {
                        circles[xPos][yPos] = new Circle(xPositionPane * boardScalingFactor,
                                yPositionPane * boardScalingFactor, 35, Color.BLACK);
                        circles[xPos][yPos].setStroke(Color.BLACK);
                        root.getChildren().add(circles[xPos][yPos]);
                    } else {
                        circles[xPos][yPos] = new Circle(xPositionPane * boardScalingFactor,
                                yPositionPane * boardScalingFactor, 35, Color.WHITE);
                        circles[xPos][yPos].setStroke(Color.BLACK);
                        root.getChildren().add(circles[xPos][yPos]);
                    }
//                    System.out.println();
//                    for (Intersection n : board.getIntersection(xPos, yPos).getLiberties()) {
//                        System.out.print(n.getState() + ", ");
//                    }
//                    System.out.println();
//                    System.out.print(board.getIntersection(xPos, yPos).freeLiberties());
//
//                    System.out.println();
//                    board.getIntersection(xPos, yPos).changeLibertyState(game.whosTurn());
//                    System.out.print(board.getIntersection(xPositionPane, yPos).getState());
//                    System.out.println();
//                    for (Intersection n : board.getIntersection(xPositionPane -3, yPos).getLiberties()) {
//                        System.out.print(n.getState() + ", ");
//                    }
//
//                      System.out.println("(" + xPosition + ", " + yPosition + ")");
//                    if (board.getIntersectionState(xPosition, yPosition -1) == 1) {
//                        root.getChildren().remove(circles[xPosition][yPos]);
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
