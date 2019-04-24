package com.Go94;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.*;

import java.io.IOException;


/**
 * The BoardHandler class deals with the JavaFX implementations
 * of the GameBoard.
 *
 * @author Will Davies and Alex Mair
 */
public class BoardHandler
        implements EventHandler<ActionEvent> {

    /**
     * Producing a new GameBoard to be used within the JavaFX program.
     */
    private GameBoard board;

    /**
     * Producing a PassCounter to keep track of the passes in the game.
     */
    private PassCounter passCounter;

    /**
     * The first player of the game.
     */
    private Player p1;

    /**
     * The second player of the game.
     */
    private Player p2;

    /**
     * Producing a GameLogic instance to track players.
     */
    private GameLogic game;

    /**
     * The constructor for the Board handler class.
     * @param size The dimension of the board.
     * @param firstPlayer The name of the first player.
     * @param secondPlayer The name of the seconds player.
     */
    public BoardHandler(final int size, final String firstPlayer,
                        final String secondPlayer) {
        board = new GameBoard(size, size);
        p1 = new Player(firstPlayer, 1);
        p2 = new Player(secondPlayer, 2);
        game = new GameLogic(p1, p2);
        passCounter = new PassCounter();
    }

    /**
     * Scaling factor for the board to make it display correctly.
     * @return the scale for a given board size.
     */
    public int getScale() {
        if (board.getWidth() == 9) {
            return 100;
        } else if (board.getWidth() == 13) {
            return 70;
        } else {
            return 50;
        }
    }

    /**
     * Parent to display the pane and the content on.
     *
     * @return Information to go on the scene.
     */
    public Parent createContent() {
        boolean[] end = {false, false, false, false};
        Pane root = new Pane();
        root.setPrefSize(1100, 1100);
        Circle[][] circles = new Circle[board.getWidth()][board.getHeight()];

        Button passButton = new Button("Pass");

        passButton.setMinWidth(100);
        passButton.setMinHeight(10);
        passButton.setTranslateX(600);
        passButton.setTranslateY(10);
        root.getChildren().add(passButton);

        Button endButton = new Button("Quit");
        endButton.setMinWidth(100);
        endButton.setMinHeight(10);
        endButton.setTranslateX(300);
        endButton.setTranslateY(10);
        root.getChildren().add(endButton);

        passButton.setOnAction(event -> {

            passCounter.setCurrentPass(game.getTurnCounter());
            if (passCounter.endOfGame()) {

                // TODO PASS GAME DATA TO DATABASE





                board.p1ScoreCalculator(p1);
                board.p2ScoreCalculator(p2);
                int p1Overall = p1.getScore() + p1.getStonesWon()
                        + p1.getStonesLost();
                int p2Overall = p2.getScore() + p2.getStonesWon()
                        + p2.getStonesLost();
                if (p1Overall < 0) {
                    p1Overall = 0;
                }
                if (p2Overall < 0) {
                    p2Overall = 0;
                }
                end[0] = true;
                if (end[0]) {
                    Pane endScene = new Pane();
                    ImageView iv1 = new ImageView(new Image("http://icons.iconarchive.com/icons/atti12/tv-series-folder/512/Game-of-Thrones-icon.png"));
                    //TODO CHANGE THIS. DON'T LEAVE IT LIKE THIS YOU IDIOT.
                    iv1.relocate(800, 600);
                    endScene.getChildren().add(iv1);

                    if (p1Overall > p2Overall) {
                        Text whoWon = new Text(300, 200, "Congratulations!"
                                + "\n" + p1.getName() + " has won the game!\n"
                                + p1.getName() + " scored " + p1Overall + "!\n"
                                + p2.getName() + " scored " + p2Overall + "!");
                        whoWon.setFont(new Font(25));
                        endScene.getChildren().add(whoWon);
                    } else if (p2Overall > p1Overall) {
                        Text whoWon = new Text(300, 200, "Congratulations!"
                                + "\n" + p2.getName() + " has won the game!\n"
                                + p2.getName() + " scored " + p2Overall + "!\n"
                                + p1.getName() + " scored " + p1Overall + "!");
                        whoWon.setFont(new Font(25));
                        endScene.getChildren().add(whoWon);
                    } else {
                        Text whoWon = new Text(200, 200, "                  "
                                + "       Oh no! It was a draw!\n"
                                + "\nWould you like to play again to see who is the best?");
                        whoWon.setFont(new Font(25));
                        endScene.getChildren().add(whoWon);
                    }

                    Stage mainStage;
                    mainStage = GUI.parentWindow;
                    mainStage.getScene().setRoot(endScene);
                    mainStage.show();

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
                        end[1] = true;
                        if (end[1]) {
                            Pane restart = root;
                            for (int i = 0; i < board.getHeight(); i++) {
                                for (int j = 0; j < board.getWidth(); j++) {
                                    board.setIntersectionState(j, i, 0);
                                    root.getChildren().remove(circles[j][i]);
                                }
                            }
                            p1 = new Player("Alex", 1);
                            p2 = new Player("Will", 2);
                            game.setTurnCounter(1);

                            Stage restartStage;
                            restartStage = GUI.parentWindow;
                            restartStage.getScene().setRoot(restart);
                            restartStage.show();
                        }
                    });

                    dashboardButton.setOnAction(Event -> {
                        end[2] = true;
                        if (end[2]) {
                            {
                                try {
                                    Parent dashBoard;
                                    dashBoard = FXMLLoader.load(getClass()
                                            .getResource("dashboard.fxml"));
                                    Stage dashStage;
                                    dashStage = GUI.parentWindow;
                                    dashStage.getScene().setRoot(dashBoard);
                                    dashStage.show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
            }
            passCounter.setLastPass(passCounter.getCurrentPass());
            game.incrementTurnCounter();
        });

        endButton.setOnAction(Event -> {
            end[3] = true;
            if (end[3]) {
                {
                    try {
                        Parent dashBoard;
                        dashBoard = FXMLLoader.load(getClass()
                                .getResource("dashboard.fxml"));
                        Stage dashStage;
                        dashStage = GUI.parentWindow;
                        dashStage.getScene().setRoot(dashBoard);
                        dashStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        for (int i = 1; i < board.getHeight(); i++) {
            for (int j = 1; j < board.getWidth(); j++) {
                Tile tile = new Tile(getScale());
                tile.setTranslateX(j * getScale());
                tile.setTranslateY(i * getScale());
                root.getChildren().addAll(tile);
            }
        }

        root.setOnMouseClicked(event -> {
            int xPosPane = (int) Math.rint(event.getSceneX()
                    / getScale());
            int yPosPane = (int) Math.rint(event.getSceneY()
                    / getScale());
            final int xPos = xPosPane - 1;
            final int yPos = yPosPane - 1;
            double circleRadius;
            if (board.getWidth() == 9) {
                circleRadius = 35.0;
            } else if (board.getWidth() == 13) {
                circleRadius = 30.0;
            } else {
                circleRadius = 20.0;
            }

            if (xPosPane > 0 && xPosPane < board.getWidth() + 1 && yPosPane > 0
                    && yPosPane < board.getHeight() + 1) {
                if (board.playMove(board.getIntersection(xPos, yPos), game)) {
                    circles[xPos][yPos] = new Circle(xPosPane * getScale(),
                            yPosPane * getScale(), circleRadius, Color.BLACK);
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
    public void handle(final ActionEvent event) {
    }
}
