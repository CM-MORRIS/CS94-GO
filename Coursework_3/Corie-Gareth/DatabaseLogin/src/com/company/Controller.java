package com.company;

import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class Controller {

    @FXML
    public Button btnLogin;

    @FXML
    public Button btnLdr;

    @FXML
    public Button backDash;

    @FXML
    public TextField usertxt;

    @FXML
    public PasswordField pswdtxt;



    public void onLoginClick() {
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override // <- notice the annotation, it overrides from the interface.
            public void handle(ActionEvent event) {
                System.out.println("Login button pressed");

                // instructions on button press. Only logs user in if credentials match.
                if (UserDB.checkUserPass(usertxt.getText(), pswdtxt.getText())) {
                    System.out.println(UserDB.checkUserPass(usertxt.getText(), pswdtxt.getText()));
                    System.out.println("Successfully found user");

                    // shows dashboard on successful login
                    GUI dashboard = new GUI();
                    dashboard.showDash();
                }
            }
        });
    }

    public void onLdrClick() {

        btnLdr.setOnAction(new EventHandler<ActionEvent>() {
             @Override
             public void handle(ActionEvent event) {

                 // shows leaderboard
                 GUI leaderboard = new GUI();
                 leaderboard.showLeaderboard();

             }
         });

    }
    public void onBackClick() {
        //provides functionality to go back to the dashboard from the leaderboatd

        backDash.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent back) {

                // shows dashboard on successful login
                GUI dashboard = new GUI();
                dashboard.showDash();
            }
        });
    }
}
