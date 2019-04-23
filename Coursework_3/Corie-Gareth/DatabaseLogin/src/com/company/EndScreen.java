package com.company;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class EndScreen extends Application {

    private Parent createContent() {
        Pane root = new Pane();
        root.setPrefSize(1000, 1000);

        Button button = new Button("Restart");
        button.setMinWidth(200);
        button.setMinHeight(50);
        button.setTranslateX(300);
        button.setTranslateY(500);
        root.getChildren().add(button);

        Button button_two = new Button("DashBoard");
        button_two.setMinWidth(200);
        button_two.setMinHeight(50);
        button_two.setTranslateX(600);
        button_two.setTranslateY(500);
        root.getChildren().add(button_two);

        button.setOnAction(event -> {
            // restart game

        });
        button_two.setOnAction(event -> {
            {
                //back to dash board
            }
        });
        return root;
    }

    public void start(final Stage primaryStage) {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
}