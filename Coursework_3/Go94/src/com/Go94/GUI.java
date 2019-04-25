package com.Go94;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The class which allows for the creation of the interactive GUI elements.
 *
 *
 * @author Corie Morris and Gareth Thomas
 */
public class GUI extends Application {

    /**
     * Producing a Stage for the window.
     */
    public static Stage parentWindow;

    /**
     * Launches the login screen on application launch.
     */
    @Override
    public void start(final Stage primaryStage) throws Exception {

        // shows login GUI
        parentWindow = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        primaryStage.setTitle("Group 4 - CSCM94 - Go Game");
        primaryStage.setScene(new Scene(root, 450, 250));
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
            mainStage.setMinWidth(1100.0);
            mainStage.setMinHeight(700.0);
            mainStage.setMaxWidth(1100.0);
            mainStage.setMaxHeight(700.0);
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
            Parent leaderboard;
            leaderboard = FXMLLoader.load(getClass().getResource("Leaderboard.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(leaderboard);
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
            Parent login;
            login = FXMLLoader.load(getClass().getResource("Login.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(login);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}











