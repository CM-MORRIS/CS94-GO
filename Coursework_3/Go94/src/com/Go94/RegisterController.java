package com.Go94;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.util.ResourceBundle;

import java.io.IOException;
import java.net.URL;
import com.Go94.UserDB;

/**
* read register imformation send it to database
* Start game
* @author Zhifang Li and Corie Morris
*/
public class RegisterController implements Initializable {
    
    /**
     * Variables for the javafx fields to insert the data
     */
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField surnameField;

    @FXML
    private ComboBox<String> cb;

    /**
     * to allow for acces to the DB
     */
    public static UserDB userDB;

    /**
     * read register imformation send it to database
     */
    public void onRegisterClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstname = firstnameField.getText();
        String surname = surnameField.getText();
        String avatarName = AvatarImageName.getImageName(cb.getSelectionModel().getSelectedItem());
        userDB.addUser(username,password,firstname,surname,avatarName);
        System.out.println("clicked");
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("Manage.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     /**
     * come  back to manage interface
     */
    public void onBackClick() {
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("Manage.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * to be able to add avatar to the profiles
     */
    private void addAvatarImages(){
        ObservableList<String> avatars = FXCollections.observableArrayList();
        avatars.add(getClass().getResource("/avatarImages/Antman.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/BlackPanther.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/CaptainMarvel.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/CaptainAmerica.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Hulk.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Ironman.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Spiderman.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Thor.png").toExternalForm());
        cb.setPromptText("Select Avatar");
        cb.setItems(avatars);
        cb.setButtonCell(new AvatarImages());
        cb.setCellFactory(param -> new AvatarImages());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        addAvatarImages();
    }





}
