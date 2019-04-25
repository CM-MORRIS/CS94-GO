package com.Go94;

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


/**
 * Leaderboard view provides the functionality to display information on the leaderboard.
 *
 * @author Corie Morris and Gareth Thomas
 */
public class LeaderBoardView implements Initializable {

    /**
     * Creating the button to return to the dashboard
     */
    @FXML public Button backDash;

    /**
     * Setting the columns which will display the data
     */
    @FXML private TableColumn<LeaderBoardData, String> colUsername;
    @FXML private TableColumn<LeaderBoardData, Number> colWins;
    @FXML private TableColumn<LeaderBoardData, Number> colWinPercentage;
    
    /**
     * Setting the actual table for the leaderboard which will contain the columns
     */
    @FXML private TableView<LeaderBoardData> tableLeaderboard;
    private ObservableList<LeaderBoardData> data;

    /**
     * Allows to display the data of wins, username and win%
     *
     * @param location where the DB is
     * @param resources the information used from the DB
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colUsername.setCellValueFactory(f -> f.getValue().usernameProperty());
        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colWinPercentage.setCellValueFactory(f -> f.getValue().winPercentProperty());
        buildLeaderBoardData();

//        colUsername.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData,String>("username"));
//        colWins.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("wins"));
//        colWinPercentage.setCellValueFactory(
//                new PropertyValueFactory<LeaderBoardData, Integer>("winPercentage"));



    }

    /**
     * The method to retrieve the information from the database that will be used on the leaderboard
     */
    public void buildLeaderBoardData() {
        try {
            ResultSet rs = UserDB.getLeaderBoardData();

            data = FXCollections.observableArrayList();

            while (rs.next()) {
                LeaderBoardData lb = new LeaderBoardData();
                lb.setUsername(rs.getString("username"));
                lb.setUserWins(rs.getInt("wins"));
                lb.setWinPercentage(rs.getInt("winPercentage"));

                data.add(lb);
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


    /**
     * The method to let the button take the user back to the dashboard when clicked
     */
    public void onBackClick() {
        //provides functionality to go back to the dashboard from the leaderboatd

        GUI dashboard = new GUI();
        dashboard.showDash();
    }
}
