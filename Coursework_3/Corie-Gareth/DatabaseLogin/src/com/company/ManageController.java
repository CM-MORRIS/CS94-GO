package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;




public class ManageController implements Initializable {

//    @FXML public Button backDash;

    @FXML private TableColumn<ManageData, String> usernameCol;
    @FXML private TableView<ManageData> userTableView;
    private ObservableList<ManageData> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        usernameCol.setCellValueFactory(f -> f.getValue().usernameProperty());

        buildManageData();
    }
    public void buildManageData() {
        data = FXCollections.observableArrayList();
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
    public void onNewClick() {
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("Register.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void onDeleteClick() {
        int selectedIndex = userTableView.getSelectionModel().getSelectedIndex();
        UserDB.deleteuser(userTableView.getSelectionModel().getSelectedItem().getUsername());
        if (selectedIndex >= 0) {
            userTableView.getItems().remove(selectedIndex);
        } else {
        }
    }
    @FXML
    private void onChangeClick() {
        int selectedIndex = userTableView.getSelectionModel().getSelectedIndex();
        UserDB.changeAuothority(userTableView.getSelectionModel().getSelectedItem().getUsername());
        if (selectedIndex >= 0) {
            userTableView.getItems().remove(selectedIndex);
        } else {
        }
    }
    public void onBackClick() {
        try {
            Parent manageboard;
            manageboard = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
            Stage mainStage;
            mainStage = GUI.parentWindow;
            mainStage.getScene().setRoot(manageboard);
            mainStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
