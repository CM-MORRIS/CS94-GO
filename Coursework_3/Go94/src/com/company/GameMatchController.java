package com.company;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import com.company.BoardHandler;

public class GameMatchController {
    @FXML
    private TextField size;
    @FXML
    private TextField userA;
    @FXML
    private TextField userB;
    
    public void onMarchClick() {
        BoardHandler game = new BoardHandler(Integer.parseInt(size.getText()),userA.getText(),userB.getText());
        System.out.println(game);
        Parent startgame = game.createContent();
        Stage secondWindow=new Stage();
        Scene scene=new Scene(startgame,900,900);
        secondWindow.setTitle("secondWindow");
        secondWindow.setScene(scene);
        secondWindow.show();
    }
}
