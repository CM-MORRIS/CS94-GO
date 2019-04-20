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
      public void start (Stage primaryStage) {
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
              final PasswordField txtPassword = new PasswordField();


              // Register Button
              Button btnRegister = new Button("Register");
              final Label lblMessageRegister = new Label();

              // Login Button
              Button btnLogin = new Button("Login");
              final Label lblMessageLogin = new Label();








              // handles what happens when 'Register' pressed

              btnRegister.setOnAction(new EventHandler<ActionEvent>() {
                  @Override // <- notice the annotation, it overrides from the interface.
                  public void handle(ActionEvent event) {
                      System.out.println("Register button pressed");
                    if(!txtUserName.getText().isEmpty() || !txtPassword.getText().isEmpty()) {
                        // only updates DB if username available
                        if (!UserDB.checkUser(txtUserName.getText())) UserDB.addUser(txtUserName.getText(), txtPassword.getText());
                        else System.out.println("Username taken, choose another.");
                    }
                    else System.out.println("Please complete all fields");
                  }
              });


              // handles what happens when 'Login' pressed NOT WORKING

              btnLogin.setOnAction(new EventHandler<ActionEvent>() {
                  @Override // <- notice the annotation, it overrides from the interface.
                  public void handle(ActionEvent event) {
                      System.out.println("Login button pressed");

                      // instructions on button press. Only logs user in if credentials match.
                      if (UserDB.checkUserPass(txtUserName.getText(), txtPassword.getText())) {
                          System.out.println(UserDB.checkUserPass(txtUserName.getText(), txtPassword.getText()));
                          System.out.println("Successfully found user");

                          // Opens LeaderBoard on successful login
                          new LeaderBoard();
                      }
                      else System.out.println("User: " + txtUserName.getText() + " AND password: " + txtPassword.getText() + " not found");
                  }
              });


              // Adding Nodes to GridPane layout

              gridPane.add(lblUserName, 0, 0);
              gridPane.add(txtUserName, 1, 0);
              gridPane.add(lblPassword, 0, 1);
              gridPane.add(txtPassword, 1, 1);
              gridPane.add(btnRegister, 1, 3);
              gridPane.add(btnLogin, 1, 2);
              gridPane.add(lblMessageRegister, 1, 2);
              gridPane.add(lblMessageLogin, 1, 2);



            // Adding text
              Text text = new Text("Login to Play Go");
              text.setFont(Font.font("Courier New", FontWeight.BOLD, 28));

              // Adding text to HBox
              hb.getChildren().add(text);

              // Add ID's to Nodes
              bp.setId("bp");
              gridPane.setId("root");
              btnRegister.setId("btnRegister");
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


