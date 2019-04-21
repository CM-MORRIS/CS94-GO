package com.company;

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
                    try {
                        Parent dashboard;
                        dashboard = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                        Stage mainStage;
                        mainStage = GUI.parentWindow;
                        mainStage.getScene().setRoot(dashboard);
                        //mainStage.setResizable(false);
                        mainStage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}

