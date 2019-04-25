package com.Go94;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



/**
 * Leaderboard view provides the functionality to display
 * information on the leaderboard.
 *
 * @author Corie Morris, Zhifang (Andy) Li and Gareth Thomas
 */
public class ManageController implements Initializable {

    /**
     * Setting the column which will display the data.
     */
    @FXML private TableColumn<ManageData, String> usernameCol;
    /**
     * Setting the table to contain the column.
     */
    @FXML private TableView<ManageData> userTableView;

    /**
     * Read data from database, set it into text view table.
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        usernameCol.setCellValueFactory(f -> f.getValue().usernameProperty());

        buildManageData();
    }

    /**
     * Set user data into text view table.
     */
    private void buildManageData() {
        ObservableList<ManageData> data = FXCollections.observableArrayList();
        try {
            ResultSet rs = UserDB.getLeaderBoardData();
            data = FXCollections.observableArrayList();
            while (rs.next()) {
                ManageData lb = new ManageData();
                lb.setUsername(rs.getString("username"));
                data.add(lb);
            }
        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
        }

        userTableView.setItems(data);
    }

    /**
     * Switch window to register interface.
     */
    public void onNewClick() {
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("Register.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.setMinWidth(325.0);
            mainStage.setMinHeight(350.0);
            mainStage.setMaxWidth(325.0);
            mainStage.setMaxHeight(350.0);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete user which has been select.
     */
    @FXML
    private void onDeleteClick() {
        int selectedIndex = userTableView.getSelectionModel().getSelectedIndex();
        UserDB.deleteUser(userTableView.getSelectionModel().getSelectedItem().getUsername());
        if (selectedIndex >= 0) {
            userTableView.getItems().remove(selectedIndex);
        }
    }
    
    /**
     * Set the user as an admin.
     */
    @FXML
    private void onChangeClick() {
        int selectedIndex = userTableView.getSelectionModel().getSelectedIndex();
        UserDB.changeAuthority(userTableView.getSelectionModel().
                getSelectedItem().getUsername());
        if (selectedIndex >= 0) {
            userTableView.getItems().remove(selectedIndex);
        }
    }

    /**
     * Return back to the Dashboard.
     */
    public void onBackClick() {
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.setMinWidth(1100.0);
            mainStage.setMinHeight(700.0);
            mainStage.setMaxWidth(1100.0);
            mainStage.setMaxHeight(700.0);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
