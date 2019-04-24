package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.company.UserDB.*;


public class DashBoardView implements Initializable {


    @FXML
    public Button btnLdr;

    @FXML
    public Button newGameBtn;

    @FXML
    public Button newGameBtn9;

    @FXML
    public Button newGameBtn13;

    @FXML
    public Button newGameBtn19;

    @FXML
    public Label lastLoginLabel;

    @FXML
    private TableView<WinsLossData> winlosstable;

    @FXML
    private TableColumn<WinsLossData, Number> colWins;

    @FXML
    private TableColumn<WinsLossData, Number> colLoss;

    private ObservableList<WinsLossData> data1;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // win/loss table view
        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colLoss.setCellValueFactory(f -> f.getValue().userLossProperty());
        buildWinsLossDashData();
        System.out.println(Controller.lastLogin);
        lastLoginLabel.setText(Controller.lastLogin);
    }


    // shows win/loss table view
    public void buildWinsLossDashData() {
        try {

            ResultSet rs = UserDB.getWinsLossData(Controller.loggedUsr);

            data1 = FXCollections.observableArrayList();

            WinsLossData wl = new WinsLossData();

            wl.setUserWins(rs.getInt("wins"));
            wl.setUserLoss(rs.getInt("loss"));

            data1.add(wl);

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
        }

        winlosstable.setItems(data1);
    }


    /**
     *
     */

    public void onLdrClick() {
        GUI leaderboard = new GUI();
        leaderboard.showLeaderboard();
    }


    public void onManageClick() {
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


    public void onNewGame9() {
        GUI new9 = new GUI();
        new9.showGame9();
    }

    public void onNewGame13() {
        GUI new13 = new GUI();
        new13.showGame13();
    }

    public void onNewGame19() {
        GUI new19 = new GUI();
        new19.showGame19();
    }
}

