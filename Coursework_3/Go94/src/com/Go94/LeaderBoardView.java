package com.Go94;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


/**
 * Leaderboard view provides the functionality to display
 * information on the leaderboard.
 *
 * @author Corie Morris and Gareth Thomas
 */
public class LeaderBoardView implements Initializable {

    /**
     * Creating the button to return to the dashboard.
     */
    @FXML public Button backDash;

    /**
     * Setting the columns which will display the username.
     */
    @FXML private TableColumn<LeaderBoardData, String> colUsername;

    /**
     * Set the column for the wins.
     */
    @FXML private TableColumn<LeaderBoardData, Number> colWins;

    /**
     * Set the column for the win percentage.
     */
    @FXML private TableColumn<LeaderBoardData, Number> colWinPercentage;

    /**
     * Setting the actual table for the leaderboard which will contain the columns.
     */
    @FXML private TableView<LeaderBoardData> tableLeaderboard;

    /**
     * Setting the data for the leaderboard.
     */
    private ObservableList<LeaderBoardData> data;

    /**
     * Allows to display the data of wins, username and win.
     *
     * @param location where the DB is
     * @param resources the information used from the DB
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        colUsername.setCellValueFactory(f -> f.getValue().usernameProperty());
        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colWinPercentage.setCellValueFactory(f -> f.getValue().winPercentProperty());
        buildLeaderBoardData();
    }

    /**
     * The method to retrieve the information from the database
     * that will be used on the leaderboard.
     */
    private void buildLeaderBoardData() {
        try {
            ResultSet rs = UserDB.getLeaderBoardData();

            data = FXCollections.observableArrayList();

            while (rs.next()) {
                LeaderBoardData lb = new LeaderBoardData();
                lb.setUsername(rs.getString("username"));
                lb.setUserWins(rs.getDouble("wins"));
                lb.setWinPercentage(rs.getDouble("winPercentage"));

                data.add(lb);
            }
        } catch (SQLException ex) {
            System.out.println("Connection Failed! Check output console");
        }

        tableLeaderboard.setItems(data);
    }

    /**
     * The method to let the button take the user back to
     * the dashboard when clicked.
     */
    public void onBackClick() {
        GUI dashboard = new GUI();
        dashboard.showDash();
    }
}
