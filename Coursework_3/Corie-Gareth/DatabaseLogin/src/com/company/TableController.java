package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TableController implements Initializable {

    @FXML private TableView<UserDB> tableLeaderboard;
    @FXML private TableColumn<UserDB, String> userCol;
    @FXML private TableColumn<UserDB, String> winsCol;
    @FXML private TableColumn<UserDB, String> winPercentageCol;

    ObservableList<UserDB> oblist = FXCollections.observableArrayList();



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ResultSet rs = UserDB.getLeaderboardData();

        try {

            while(rs.next()) {
                oblist.add(
            }

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }




        userCol.setCellValueFactory(new PropertyValueFactory<UserDB, String>("User"));
        winsCol.setCellValueFactory(new PropertyValueFactory<UserDB, String>("Wins"));
        winPercentageCol.setCellValueFactory(new PropertyValueFactory<UserDB, String>("WinPercentage"));

    }





}
