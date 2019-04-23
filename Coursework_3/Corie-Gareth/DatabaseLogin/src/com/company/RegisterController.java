package com.company;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import com.company.UserDB;

public class RegisterController {
    @FXML
    private TextField usernameField;
    @FXML
    private TextField passwordField;
    @FXML
    private TextField firstnameField;
    @FXML
    private TextField surnameField;
    
    public static UserDB userDB;
    public void onRegisterClick() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        String firstname = firstnameField.getText();
        String surname = surnameField.getText();
        userDB.addUser(username,password,firstname,surname);
        System.out.println("clicked");
    }
    
    
}
