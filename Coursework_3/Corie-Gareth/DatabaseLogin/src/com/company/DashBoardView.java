package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;



public class DashBoardView implements Initializable {


    @FXML
    public Button btnLdr;

    @FXML private TableView<WinsLossData> winlosstable;
    @FXML private TableColumn<WinsLossData, Number> colWins;
    @FXML private TableColumn<WinsLossData, Number> colLoss;
    private ObservableList<WinsLossData> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colLoss.setCellValueFactory(f -> f.getValue().userLossProperty());

//        colUsername.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData,String>("username"));
//        colWins.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("wins"));
//        colWinPercentage.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("winPercentage"));

        buildWinsLossDashData();

    }


    public void buildWinsLossDashData() {

        data = FXCollections.observableArrayList();
        try {
            ResultSet rs = UserDB.getWinsLossData("1");

            data = FXCollections.observableArrayList();

            while (rs.next()) {
                WinsLossData wl = new WinsLossData();

                wl.setUserWins(rs.getInt("wins"));
                wl.setUserLoss(rs.getInt("loss"));

                data.add(wl);
            }
        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
        }

        winlosstable.setItems(data);
    }

    public void onLdrClick() {

        btnLdr.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                // shows leaderboard
                GUI leaderboard = new GUI();
                leaderboard.showLeaderboard();
            }
        });
    }











}
