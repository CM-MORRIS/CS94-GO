package com.company;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;

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

                // shows dashboard
                GUI dashboard = new GUI();
                dashboard.showDash();
            }
        });
    }
}
