package core;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class BoardTest extends Application {

    Stage window;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        final double BUTTON_PADDING = 90;
        window = primaryStage;
        window.setTitle("test");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(BUTTON_PADDING,BUTTON_PADDING,BUTTON_PADDING,BUTTON_PADDING));
        grid.setHgap(0);
        grid.setVgap(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                String a = String.valueOf(i);
                String b = String.valueOf(j);
                Button button = new Button("(" + a + ", " + b + ")");
                button.setId(a + b);
                button.setPrefHeight(BUTTON_PADDING);
                button.setPrefWidth(BUTTON_PADDING);
                GridPane.setConstraints(button, i, j);

                grid.getChildren().add(button);
            }
        }

        Scene scene = new Scene(grid, 900, 900);
        window.setScene(scene);

        window.show();


    }
}
