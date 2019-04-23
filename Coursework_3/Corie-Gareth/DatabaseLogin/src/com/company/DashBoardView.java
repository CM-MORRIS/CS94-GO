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


    @FXML
    public Button newGameBtn9;

    @FXML
    public Button newGameBtn13;

    @FXML
    public Button newGameBtn19;


    @FXML
    public Button registerButton;


    
//    @FXML
//    public Button registerButton;

    @FXML private TableView<WinsLossData> winlosstable;
    @FXML private TableColumn<WinsLossData, Number> colWins;
    @FXML private TableColumn<WinsLossData, Number> colLoss;
    private ObservableList<WinsLossData> data1;


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


//        winlosstable.setItems(UserDB.getWinsLossData(Controller.loggedUsr));

        //buildWinsLossDashData();

    }






//    public void buildWinsLossDashData() {
//
//        data = FXCollections.observableArrayList();
//        try {
//            ResultSet rs = UserDB.getWinsLossData(Controller.loggedUsr);
//
//            System.out.println(rs.getInt("wins"));
//            System.out.println(rs.getInt("loss"));
//
//            while (rs.next()) {
//                WinsLossData wl = new WinsLossData();
//
//                wl.setUserWins(rs.getInt("wins"));
//                wl.setUserLoss(rs.getInt("loss"));
//
//                System.out.println(rs.getInt("wins"));
//                System.out.println(rs.getInt("loss"));
//
//                data.add(wl);
//            }
//        } catch (SQLException ex) {
//            System.out.println("Connection Failed! Check output console");
//        }
//
//    }

//        winlosstable.setItems(data);
//    }
    
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
//
//    public void onRegisterClick() {
//        registerButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                // shows leaderboard
//                GUI register = new GUI();
//                register.showRegister();
//            }
//        });
//    }


    public void onNewGame9() {
        newGameBtn9.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // shows leaderboard
                GUI register = new GUI();
                register.showGame9();
            }
        });
    }

    public void onNewGame13() {
        newGameBtn13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // shows leaderboard
                GUI register = new GUI();
                register.showGame13();
            }
        });
    }
    public void onNewGame19() {
        newGameBtn19.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // shows leaderboard
                GUI register = new GUI();
                register.showGame19();
            }
        });
    }












}
