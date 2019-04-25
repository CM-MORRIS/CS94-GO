package com.Go94;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The class which allows for the creation of the interactive GUI elements
 *
 *
 * @author Corie Morris and Gareth Thomas
 */

public class GUI extends Application {

    public static Stage parentWindow;

    /**
     * Launches the login screen on application launch.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        // shows login GUI
        parentWindow = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Group 4 - CSCM94 - Go Game");
        primaryStage.setScene(new Scene(root, 1000, 1000));
        primaryStage.show();
    }

    /**
     * Produce the interactive dashboard.
     */
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
    /**
     * Launches the register screen.
     */
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
    /**
     * Launches the leaderboard screen.
     */
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
    
    /**
     * Allows to launch and return to the login screen.
     */
    public void logIn() {
        try {
            Parent Login;
            Login = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(Login);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}











