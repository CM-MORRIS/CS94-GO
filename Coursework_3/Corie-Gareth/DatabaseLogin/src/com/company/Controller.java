package com.company;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import java.io.IOException;
import net.proteanit.sql.DbUtils;
import javafx.fxml.Initializable;

import javax.swing.*;

public class Controller {//implements Initializable {

    @FXML
    public Button btnLogin;

    @FXML
    public Button btnLdr;


    @FXML
    public TextField usertxt;

    @FXML
    public PasswordField pswdtxt;

//    @FXML private TableColumn<UserData, String> colUsername;
//    @FXML private TableColumn<UserData, Integer> colWins;
//    @FXML private TableColumn<UserData, Integer> colWinPercentage;
//    @FXML private TableView<UserData> tableLeaderboard;
//    private ObservableList<UserData> data;
//
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        colUsername.setCellValueFactory(
//                new PropertyValueFactory<UserData,String>("username"));
//        colWins.setCellValueFactory(
//                new PropertyValueFactory<UserData, Integer>("wins"));
//        colWinPercentage.setCellValueFactory(
//                new PropertyValueFactory<UserData, Integer>("winPercentage"));
//
//
//            buildData();
//
//
//    }
//
//
//    public void buildData() {
//        data = FXCollections.observableArrayList();
//        try {
//            ResultSet rs = UserDB.getLeaderboardData();
//
//            while(rs.next()){
//                UserData cm = new UserData();
//
//                cm.username.set(rs.getString("username"));
//                cm.wins.set(rs.getInt("wins"));
//                cm.winPercentage.set(rs.getInt("winPercentage"));
//
//                data.add(cm);
//            }
//            tableLeaderboard.setItems(data);
//
//        } catch(Exception e) {
//            e.printStackTrace();
//            System.out.println("Error on Building Data");
//        }
//    }












//        TableColumn username = new TableColumn("username");
//        TableColumn wins = new TableColumn("wins");
//        TableColumn winPercentage = new TableColumn("winPercentage");
//        tableLeaderboard.getColumns().addAll(username, wins, winPercentage);
//
////         ObservableList<UserData> data = FXCollections.observableArrayList(
////                new UserData("corie", 1, 2)
////        );
//
//        try {
//            ResultSet rs = UserDB.getLeaderboardData();
//            while (rs.next()) {
//                ObservableList<UserData> row = FXCollections.observableArrayList();
//                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
//                    row.add(rs.getString(i));
//                    System.out.println(row);
//                }
//                data.add(row);
//            }
//            tableLeaderboard.setItems(data);
//        } catch (SQLException ex) {
//
//        }
//
//        username.setCellValueFactory(new PropertyValueFactory("username"));
//        wins.setCellValueFactory(new PropertyValueFactory("Wins"));
//        winPercentage.setCellValueFactory(new PropertyValueFactory("WinPercentage"));
//
//
//        tableLeaderboard.setItems(data);
//

















    //    public static void bla() {
//        try {
//
//            ResultSet rs = UserDB.getLeaderboardData();
//
//
//            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
//                //We are using non property style for making dynamic table
//                final int j = i;
//                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
//                col.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                    public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
//                        return new SimpleStringProperty(param.getValue().get(j).toString());
//                    }
//                });
//
//                tableLeaderboard.getColumns().addAll(col);
//                System.out.println("Column [" + i + "] ");
//            }
//        } catch (SQLException e) {
//            System.out.println("someyhing fucked up");
//        }
//    }


















    public void onLoginClick() {
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override // <- notice the annotation, it overrides from the interface.
            public void handle(ActionEvent event) {
                System.out.println("Login button pressed");

                // instructions on button press. Only logs user in if credentials match.
                if (UserDB.checkUserPass(usertxt.getText(), pswdtxt.getText())) {
                    System.out.println(UserDB.checkUserPass(usertxt.getText(), pswdtxt.getText()));
                    System.out.println("Successfully found user");

                    // shows dashboard on successful login
                    GUI dashboard = new GUI();
                    dashboard.showDash();
                }
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

}
