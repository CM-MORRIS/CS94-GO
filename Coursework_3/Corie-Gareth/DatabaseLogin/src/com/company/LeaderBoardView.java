package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;



public class LeaderBoardView implements Initializable {

    @FXML public Button backDash;

    @FXML private TableColumn<LeaderBoardData, String> colUsername;
    @FXML private TableColumn<LeaderBoardData, Integer> colWins;
    @FXML private TableColumn<LeaderBoardData, Integer> colWinPercentage;
    @FXML private TableView<LeaderBoardData> tableLeaderboard;
    private ObservableList<LeaderBoardData> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colUsername.setCellValueFactory(
                new PropertyValueFactory<LeaderBoardData,String>("username"));
        colWins.setCellValueFactory(
                new PropertyValueFactory<LeaderBoardData, Integer>("wins"));
        colWinPercentage.setCellValueFactory(
                new PropertyValueFactory<LeaderBoardData, Integer>("winPercentage"));

        buildLeaderBoardData();

    }


    public void buildLeaderBoardData() {
        data = FXCollections.observableArrayList();
        try {
            ResultSet rs = UserDB.getLeaderboardData();

            while(rs.next()){
                LeaderBoardData cm = new LeaderBoardData();

                cm.username.set(rs.getString("username"));
                cm.wins.set(rs.getInt("wins"));
                cm.winPercentage.set(rs.getInt("winPercentage"));

                data.add(cm);
            }
            tableLeaderboard.setItems(data);

        } catch(Exception e) {
            e.printStackTrace();
            System.out.println("Error on Building Data");
        }
    }


    public void onBackClick() {
        //provides functionality to go back to the dashboard from the leaderboatd

        backDash.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent back) {

                // shows dashboard
                GUI dashboard = new GUI();
                dashboard.showDash();
            }
        });
    }
}
