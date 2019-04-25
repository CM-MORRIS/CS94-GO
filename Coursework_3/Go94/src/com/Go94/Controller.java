package com.Go94;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.IOException;
import javafx.fxml.Initializable;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.*;

/**
 * The Controller that deals with opening the initial login screen
 *
 * @author Corie Morris and Gareth Thomas
 */
public class Controller {

    /**
     * Creating the button to click to login
     */
    @FXML
    public Button btnLogin;
    
    /**
     * The area to enter the username
     */
    @FXML
    public TextField usertxt;

    /**
     * The area to enter the password
     */
    @FXML
    public PasswordField pswdtxt;

    /**
     * To get the date from the UserDB class of last time logged in
     */
    public static String loggedUsr;
    
    /**
     * String to send what username to get the info of last logged in from the database
     */
    public static String username;
    
    /**
     * The string for what to display the return the last login from the database.
     */
    public static String lastLogin;

    /**
     * What happens when the actual login button is clicked successfully.
     */
    public void onLoginClick() throws SQLException {
        System.out.println("Login button pressed");
        // instructions on button press. Only logs user in if credentials match.
        if (UserDB.checkUserPass(usertxt.getText(), pswdtxt.getText())) {
            loggedUsr = usertxt.getText();
            lastLogin="last login:"+UserDB.getLastLogin(loggedUsr);
            username = usertxt.getText();
            UserDB.addLoginHistory(Controller.username);
            // shows dashboard on successful login
            GUI dashboard = new GUI();
            dashboard.showDash();
        }
    }
}
        
