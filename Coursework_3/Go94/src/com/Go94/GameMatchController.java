package com.Go94;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import com.Go94.BoardHandler;

/**
 * Allows for the creation of the game match after the size and both users playing are entered
 *
 * @author Zhifan Li
 */
public class GameMatchController {
    
    /**
     * The size of the gameboard
     */
    @FXML
    private TextField size;
    
    /**
     * The first user playing
     */
    @FXML
    private TextField userA;
    
    /**
     * The second user playing
     */
    @FXML
    private TextField userB;
    
   /**
     * read game board size, user A and user B,
     * Start game
     */
    public void onMarchClick() {
        BoardHandler game = new BoardHandler(Integer.parseInt(size.getText()), userA.getText(), userB.getText());
        Parent startgame = game.createContent();
        Stage mainStage = GUI.parentWindow;
        mainStage.getScene().setRoot(startgame);
        mainStage.show();
    }
}
