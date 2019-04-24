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

public class Controller {

    @FXML
    public Button btnLogin;
    
    @FXML
    public TextField usertxt;

    @FXML
    public PasswordField pswdtxt;

    public static String loggedUsr;
    
    public static String username;
    
    public static String lastLogin;


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
        
