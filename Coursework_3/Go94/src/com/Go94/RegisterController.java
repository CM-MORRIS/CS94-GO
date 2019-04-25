package com.Go94;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

/**
 * Read register information send it to database.
 * @author Zhifang (Andy) Li and Corie Morris
 */
public class RegisterController implements Initializable {

    /**
     * Username Variable for JavaFX.
     */
    @FXML
    private TextField usernameField;

    /**
     *  Password Variable for JavaFX.
     */
    @FXML
    private TextField passwordField;

    /**
     * * First name Variable for JavaFX.
     */
    @FXML
    private TextField firstnameField;

    /**
     * Surname Variable for JavaFX.
     */
    @FXML
    private TextField surnameField;

    /**
     * A ComboBo to display avatar names.
     */
    @FXML
    private ComboBox<String> cb;

    /**
     * Read register information send it to database.
     */
    public void onRegisterClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstname = firstnameField.getText();
        String surname = surnameField.getText();
        String avatarName = AvatarImageName.getImageName(cb.getSelectionModel().getSelectedItem());
        UserDB.addUser(username, password, firstname, surname, avatarName);
        System.out.println("clicked");
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("Manage.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.setMinWidth(625.0);
            mainStage.setMinHeight(450.0);
            mainStage.setMaxWidth(625.0);
            mainStage.setMaxHeight(450.0);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     /**
     * Return to the manage users window.
     */
    public void onBackClick() {
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("Manage.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.setMinWidth(625.0);
            mainStage.setMinHeight(450.0);
            mainStage.setMaxWidth(625.0);
            mainStage.setMaxHeight(450.0);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to add the avatar to the profile.
     */
    private void addAvatarImages() {
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
    public void initialize(final URL location, final ResourceBundle resources) {
        addAvatarImages();
    }





}
