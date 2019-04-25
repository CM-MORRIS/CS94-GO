package com.Go94;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * The Controller that deals with opening the initial login screen.
 *
 * @author Corie Morris and Gareth Thomas
 */
public class Controller {

    /**
     * Creating the button to click to login.
     */
    @FXML
    public Button btnLogin;

    /**
     * The area to enter the username.
     */
    @FXML
    public TextField usertxt;

    /**
     * The area to enter the password.
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
    public void onLoginClick() {
        System.out.println("Login button pressed");
        // instructions on button press. Only logs user in if credentials match.
        if (UserDB.checkUserPass(usertxt.getText(), pswdtxt.getText())) {
            loggedUsr = usertxt.getText();
            lastLogin = "         Last Login: \n" + UserDB.getLastLogin(loggedUsr);
            username = usertxt.getText();
            UserDB.addLoginHistory(Controller.username);
            // shows dashboard on successful login
            GUI dashboard = new GUI();
            dashboard.showDash();
        }
    }
}
