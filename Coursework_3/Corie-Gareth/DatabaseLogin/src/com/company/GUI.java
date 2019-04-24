package com.company;

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
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 950, 950));
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
     * Launches the 9*9 screen from BoardHandler9.
     */
    public void showGame9() {
        BoardHandler9 game = new BoardHandler9();
        Parent startgame = game.createContent();
        Stage secondWindow=new Stage();
        Scene scene=new Scene(startgame,900,900);
        secondWindow.setTitle("secondWindow");
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * Launches the 13*13 screen from BoardHandler13.
     */
    public void showGame13() {
        BoardHandler13 game = new BoardHandler13();
        Parent startgame = game.createContent();
        Stage secondWindow=new Stage();
        Scene scene=new Scene(startgame,900,900);
        secondWindow.setTitle("secondWindow");
        secondWindow.setScene(scene);
        secondWindow.show();
    }

    /**
     * Launches the 19*19 screen from BoardHandler19.
     */
    public void showGame19() {
        BoardHandler19 game = new BoardHandler19();
        Parent startgame = game.createContent();
        Stage secondWindow=new Stage();
        Scene scene=new Scene(startgame,900,900);
        secondWindow.setTitle("secondWindow");
        secondWindow.setScene(scene);
        secondWindow.show();
    }
}











