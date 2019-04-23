package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;


public class GUI extends Application {

    public static Stage parentWindow;


    @Override
    public void start(Stage primaryStage) throws Exception {

        // shows login GUI
        parentWindow = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 600, 550));
        primaryStage.show();
    }


    public void showDash() {
        try {
            Parent dashBoard;
            dashBoard = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(dashBoard);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRegister() {
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("Register.fxml"));

            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLeaderboard() {
        try {
            Parent Leaderboard;
            Leaderboard = FXMLLoader.load(getClass().getResource("Leaderboard.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(Leaderboard);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public void showGame9() {
            BoardHandler9 game = new BoardHandler9();

            Parent startgame = game.createContent();
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(startgame);
            mainStage.show();
    }








    }











