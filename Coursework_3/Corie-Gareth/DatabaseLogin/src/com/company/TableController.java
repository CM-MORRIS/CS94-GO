//package com.company;
//
//import java.util.*;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.beans.property.SimpleStringProperty;
//
//
//import java.net.URL;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ResourceBundle;
//
//import static javax.swing.UIManager.getInt;
//import static javax.swing.UIManager.getString;
//
//public class TableController {
//
//    @FXML
//    private TableView<UserDB> tableLeaderboard;
//    @FXML
//    private TableColumn<UserData, String> username;
//    @FXML
//    private TableColumn<UserDB, String> wins;
//    @FXML
//    private TableColumn<UserDB, String> winPercentage;
//
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//
//        try {
//            ResultSet rs = UserDB.getLeaderboardData();
//
//            final ObservableList<UserData> data = FXCollections.observableArrayList(
//                    new UserData(rs.getString(1), rs.getInt(2), rs.getInt(3))
//            );
//
//        } catch (SQLException e) {
//            System.out.println("a");
//        }
//
//
//        username.setCellValueFactory(new PropertyValueFactory<>("username"));
//        wins.setCellValueFactory(new PropertyValueFactory<>("Wins"));
//        winPercentage.setCellValueFactory(new PropertyValueFactory<>("WinPercentage"));
//
//
//        tableLeaderboard.setitems(data);
//
//
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
