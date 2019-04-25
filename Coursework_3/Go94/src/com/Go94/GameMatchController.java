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

public class GameMatchController {
    @FXML
    private TextField size;
    @FXML
    private TextField userA;
    @FXML
    private TextField userB;
    /**
     * read game board size, user A and user B,
     * Start game
     * @author Andy
     */
    public void onMarchClick() {
        BoardHandler game = new BoardHandler(Integer.parseInt(size.getText()), userA.getText(), userB.getText());
        Parent startgame = game.createContent();
        Stage mainStage = GUI.parentWindow;
        mainStage.getScene().setRoot(startgame);
        mainStage.show();
    }
}
