package core;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The BoardHandler class deals with the JavaFX implementations
 * of the GameBoard 19*19 in size.
 *
 * @author Will Davies and Alex Mair
 */
public class BoardHandler19 extends Application
        implements EventHandler<ActionEvent> {

    /**
     * Producing a new GameBoard to be used within the JavaFX program.
     */
    private GameBoard board = new GameBoard(19, 19);

    /**
     * Producing a PassCounter to keep track of the passes in the game.
     */
    private PassCounter passCounter = new PassCounter();

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
    public static final int BOARD_SCALING_FACTOR = 60;

    /**
     * Start the stage to display content in.
     * @param primaryStage This it the primary display stage.
     */
    public void start(final Stage primaryStage) {
        boolean[] end = {false};
        Pane root = new Pane();
        Scene scene = new Scene(root, 1200, 1200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Group 4 - CSCM94 - Go Game");
        primaryStage.show();
        Circle[][] circles = new Circle[board.getWidth()][board.getHeight()];

        Button passButton = new Button("Pass");
        passButton.setMinWidth(100);
        passButton.setMinHeight(10);
        passButton.setTranslateX(550);
        passButton.setTranslateY(10);
        root.getChildren().add(passButton);

        passButton.setOnAction(event -> {

            passCounter.setCurrentPass(game.getTurnCounter());
            if (passCounter.endOfGame()) {
                board.p1ScoreCalculator(p1);
                board.p2ScoreCalculator(p2);
                int p1Overall = p1.getScore() + p1.getStonesWon() + p1.getStonesLost();
                int p2Overall = p2.getScore() + p2.getStonesWon() + p2.getStonesLost();
                if (p1Overall < 0) {
                    p1Overall = 0;
                }
                if (p2Overall < 0) {
                    p2Overall = 0;
                }
                end[0] = true;
                if (end[0]) {
                    Pane endScene = new Pane();

                    if (p1Overall > p2Overall) {
                        Text whoWon = new Text(300, 200, "Congratulations!"
                                + "\nPlayer 1 has won" + " the game!" + "\nPlayer" + " 1 scored "
                                + p1Overall + "!\nPlayer 2 scored " + p2Overall + "!");
                        whoWon.setFont(new Font(25));
                        endScene.getChildren().add(whoWon);
                    } else if (p2Overall > p1Overall) {
                        Text whoWon = new Text(300, 200, "Congratulations!"
                                + "\nPlayer 2 has won the game!\nPlayer 2 scored "
                                + p2Overall + "!\nPlayer 1 scored " + p1Overall + "!");
                        whoWon.setFont(new Font(25));
                        endScene.getChildren().add(whoWon);
                    } else {
                        Text whoWon = new Text(300, 200, "Oh no! It was a draw!"
                                + "\nWould you like to play again to see who is the best?");
                        whoWon.setFont(new Font(25));
                        endScene.getChildren().add(whoWon);
                    }

                    endScene.setPrefSize(1000, 1000);
                    Button restartButton = new Button("Restart");
                    restartButton.setMinWidth(300);
                    restartButton.setMinHeight(100);
                    restartButton.setTranslateX(600);
                    restartButton.setTranslateY(400);
                    endScene.getChildren().add(restartButton);

                    Button dashboardButton = new Button("Dashboard");
                    dashboardButton.setMinWidth(300);
                    dashboardButton.setMinHeight(100);
                    dashboardButton.setTranslateX(100);
                    dashboardButton.setTranslateY(400);
                    endScene.getChildren().add(dashboardButton);

                    restartButton.setOnAction(Event -> {
                        for (int i = 0; i < board.getHeight(); i++) {
                            for (int j = 0; j < board.getWidth(); j++) {
                                board.setIntersectionState(j, i, 0);
                                root.getChildren().remove(circles[j][i]);
                            }
                        }
                        p1 = new Player("Alex", 1);
                        p2 = new Player("Will", 2);
                        game.setTurnCounter(1);
                        primaryStage.setScene(scene);
                    });
                    dashboardButton.setOnAction(Event -> {
                        {
                            Stage stage = (Stage) dashboardButton.getScene().getWindow();
                            stage.close();
                        }
                    });
                    Scene sceneTwo = new Scene(endScene, 1000, 1000);
                    primaryStage.setScene(sceneTwo);
                    primaryStage.setTitle("Group 4 - CSCM94 - Go Game");
                    primaryStage.show();
                }
            }
            passCounter.setLastPass(passCounter.getCurrentPass());
            game.incrementTurnCounter();
        });

        for (int i = 1; i < board.getHeight(); i++) {
            for (int j = 1; j < board.getWidth(); j++) {
                Tile19 tile = new Tile19();
                tile.setTranslateX(j * BOARD_SCALING_FACTOR);
                tile.setTranslateY(i * BOARD_SCALING_FACTOR);
                root.getChildren().addAll(tile);
            }
        }

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
                            yPosPane * BOARD_SCALING_FACTOR, 25, Color.BLACK);
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
    }

    @Override
    public void handle(final ActionEvent event) {
    }
}
