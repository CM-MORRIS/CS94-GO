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
import java.sql.*;
import java.util.ResourceBundle;

import static com.company.UserDB.*;


public class DashBoardView implements Initializable {


    @FXML
    public Button btnLdr;

    @FXML
    public Button newGameBtn;

    @FXML
    public Button registerButton;


    @FXML private TableView<WinsLossData> winlosstable;
    @FXML private TableColumn<WinsLossData, Number> colWins;
    @FXML private TableColumn<WinsLossData, Number> colLoss;
    private ObservableList<WinsLossData> data1;


    @FXML private TableView<LeaderBoardData> userTable;
    @FXML private TableColumn<LeaderBoardData, String> col1;
    @FXML private TableColumn<LeaderBoardData, Number> col2;
    @FXML private TableColumn<LeaderBoardData, Number> col3;

    private ObservableList<LeaderBoardData> data2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //win/loss table not working
        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colLoss.setCellValueFactory(f -> f.getValue().userLossProperty());
        buildWinsLossDashData();

//        colUsername.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData,String>("username"));
//        colWins.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("wins"));
//        colWinPercentage.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("winPercentage"));





        // user table test
//        col1.setCellValueFactory(f -> f.getValue().usernameProperty());
//        col2.setCellValueFactory(f -> f.getValue().userWinsProperty());
//        col3.setCellValueFactory(f -> f.getValue().winPercentProperty());
//
//        buildLeaderBoardData();








    }

//    public void buildLeaderBoardData() {
//        try {
//            ResultSet rs = UserDB.getLeaderBoardData();
//
//            data2 = FXCollections.observableArrayList();
//
//            while (rs.next()) {
//                LeaderBoardData lb = new LeaderBoardData();
//                lb.setUsername(rs.getString("username"));
//                lb.setUserWins(rs.getInt("wins"));
//                lb.setUserLoss(rs.getInt("loss"));
//
//                data2.add(lb);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Connection Failed! Check output console");
//        }
//
//        userTable.setItems(data2);
//    }



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















    public void onRegisterClick() {
        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // shows leaderboard
                GUI register = new GUI();
                register.showRegister();
            }
       });
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


    public void onNewGame() {
        newGameBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // shows leaderboard
                GUI register = new GUI();
                register.showGame9();
            }
        });
    }












}
