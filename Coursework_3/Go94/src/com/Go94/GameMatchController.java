package com.Go94;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Allows for the creation of the game match after the size and both users playing are entered.
 *
 * @author Zhifang Li
 */
public class GameMatchController {

    /**
     * The size of the gameboard.
     */
    @FXML
    private TextField size;

    /**
     * The first user playing.
     */
    @FXML
    private TextField userA;

    /**
     * The second user playing.
     */
    @FXML
    private TextField userB;

    /**
     * read game board size, user A and user B.
     * Start game
     */
    public void onMarchClick() {
        BoardHandler game = new BoardHandler(Integer.parseInt(size.getText()), userA.getText(), userB.getText());
        Parent startgame = game.createContent();
        Stage mainStage = GUI.parentWindow;
        mainStage.getScene().setRoot(startgame);
        mainStage.setMinWidth(1000.0);
        mainStage.setMinHeight(1050.0);
        mainStage.setMaxWidth(1000.0);
        mainStage.setMaxHeight(1050.0);
        mainStage.show();
    }
}
