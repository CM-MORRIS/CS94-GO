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



public class LeaderboardView implements Initializable {

    @FXML public Button backDash;

    @FXML private TableColumn<UserData, String> colUsername;
    @FXML private TableColumn<UserData, Integer> colWins;
    @FXML private TableColumn<UserData, Integer> colWinPercentage;
    @FXML private TableView<UserData> tableLeaderboard;
    private ObservableList<UserData> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colUsername.setCellValueFactory(
                new PropertyValueFactory<UserData,String>("username"));
        colWins.setCellValueFactory(
                new PropertyValueFactory<UserData, Integer>("wins"));
        colWinPercentage.setCellValueFactory(
                new PropertyValueFactory<UserData, Integer>("winPercentage"));

        buildData();

    }


    public void buildData() {
        data = FXCollections.observableArrayList();
        try {
            ResultSet rs = UserDB.getLeaderboardData();

            while(rs.next()){
                UserData cm = new UserData();

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
