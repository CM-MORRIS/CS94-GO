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



public class LeaderBoardView implements Initializable {

    @FXML public Button backDash;

    @FXML private TableColumn<LeaderBoardData, String> colUsername;
    @FXML private TableColumn<LeaderBoardData, Number> colWins;
    @FXML private TableColumn<LeaderBoardData, Number> colWinPercentage;
    @FXML private TableView<LeaderBoardData> tableLeaderboard;
    private ObservableList<LeaderBoardData> data;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colUsername.setCellValueFactory(f -> f.getValue().usernameProperty());
        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colWinPercentage.setCellValueFactory(f -> f.getValue().winPercentProperty());

//        colUsername.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData,String>("username"));
//        colWins.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("wins"));
//        colWinPercentage.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("winPercentage"));

        buildLeaderBoardData();

    }


    public void buildLeaderBoardData() {
        data = FXCollections.observableArrayList();
        try {
            ResultSet rs = UserDB.getLeaderBoardData();




            data = FXCollections.observableArrayList();

            while (rs.next()) {
                LeaderBoardData cm = new LeaderBoardData();
                cm.setUsername(rs.getString("username"));
                cm.setUserWins(rs.getInt("wins"));
                cm.setWinPercentage(rs.getInt("winPercentage"));

                System.out.println(rs.getString("username"));
                System.out.println(rs.getInt("wins"));
                System.out.println(rs.getInt("winPercentage"));

                data.add(cm);
            }
        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
        }

        tableLeaderboard.setItems(data);
    }








//            while(rs.next()){
//                LeaderBoardData cm = new LeaderBoardData();
//
//                cm.setUsername(rs.getString("username"));
//                cm.setUserWins(rs.getInt("userWins"));
//                cm.setWinPercentage(rs.getInt("winPercentage"));
//                data.add(cm);
//
//                //System.out.println(data.get());
//            }
//            tableLeaderboard.setItems(data);
//
//        } catch(Exception e) {
//            e.printStackTrace();
//            System.out.println("Error on Building Data");
//        }





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
