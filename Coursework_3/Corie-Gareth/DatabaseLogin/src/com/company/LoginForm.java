package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
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

public class LoginForm extends Application {


      @Override
      public void start (Stage primaryStage){
        try {
          primaryStage.setTitle("Login");

          BorderPane bp = new BorderPane();
          bp.setPadding(new Insets(10, 50, 50, 50));

          // Adding HBox
          HBox hb = new HBox();
          hb.setPadding(new Insets(20, 20, 20, 30));

          // Adding GridPane
          GridPane gridPane = new GridPane();
          gridPane.setPadding(new Insets(20, 20, 20, 20));
          gridPane.setHgap(5);
          gridPane.setVgap(5);


          // Implementing Nodes for GridPane
          Label lblUserName = new Label("Username");
          final TextField txtUserName = new TextField();

          Label lblPassword = new Label("Password");
          final PasswordField pf = new PasswordField();


          // Login Button
          Button btnLogin = new Button("Register");
          final Label lblMessage = new Label();



        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
          @Override // <- notice the annotation, it overrides from the interface.
          public void handle(ActionEvent event) {

            // instructions on button press
            UserDB.addUser(txtUserName.getText(), pf.getText());
            System.out.println("button pressed");

          }
        });



      // Adding Nodes to GridPane layout
      gridPane.add(lblUserName, 0, 0);
      gridPane.add(txtUserName, 1, 0);
      gridPane.add(lblPassword, 0, 1);
      gridPane.add(pf, 1, 1);
      gridPane.add(btnLogin, 2, 1);
      gridPane.add(lblMessage, 1, 2);


      // Adding text
      Text text = new Text("Login");
      text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));

      // Adding text to HBox
      hb.getChildren().add(text);

      // Add ID's to Nodes
      bp.setId("bp");
      gridPane.setId("root");
      btnLogin.setId("btnLogin");
      text.setId("text");

      // Add HBox and GridPane layout to BorderPane Layout
      bp.setTop(hb);
      bp.setCenter(gridPane);

      // Adding BorderPane to the scene and loading CSS
      Scene scene = new Scene(bp);
      scene.getStylesheets().add(getClass().getClassLoader().getResource("login.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.titleProperty().bind(
              scene.widthProperty().asString().
                      concat(" : ").
                      concat(scene.heightProperty().asString()));
      primaryStage.setResizable(false);
      primaryStage.show();

        } catch(Exception e) {
          e.printStackTrace();
        }
      }
  }


