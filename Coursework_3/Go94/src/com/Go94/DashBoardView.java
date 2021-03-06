package com.Go94;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


/**
 * DashBoardView deals with the various aspects that
 * the user can interact with on the dashboard.
 *
 *
 * @author Corie Morris, Gareth Thomas, Zhifang Li and Pratibh Siris
 */
public class DashBoardView implements Initializable {

    /**
     * Creating the button to take to leaderboard.
     */
    @FXML
    public Button btnLdr;

    /**
     * The last login text.
     */
    @FXML
    public Label lastLoginLabel;

    /**
     * Creating the button to click to return to the login screen.
     */
    @FXML
    public Button logOut;

    /**
     * Creating the table for wins/loss.
     */
    @FXML
    private TableView<WinsLossData> winlosstable;

    /**
     * The data to fill the table with wins.
     */
    @FXML
    private TableColumn<WinsLossData, Number> colWins;

    /**
     * The data to fill the table with losses.
     */
    @FXML
    private TableColumn<WinsLossData, Number> colLoss;


    /**
     * The data to fill the table with GameHistory - The game.
     */
    @FXML private TableView<GameHistoryData> gameHisTbl;

    /**
     * The data to fill the table with GameHistory - The First player.
     */
    @FXML private TableColumn<GameHistoryData, String> colP1;

    /**
     * The data to fill the table with GameHistory - The Second player.
     */
    @FXML private TableColumn<GameHistoryData, String> colP2;

    /**
     * The data to fill the table with GameHistory - The winner.
     */
    @FXML private TableColumn<GameHistoryData, String> colWinner;

    /**
     * Creating list that is needed to fill tables.
     */
    private ObservableList<WinsLossData> data1;


    /**
     * Creating list for game history that is needed to fill tables.
     */
    private ObservableList<GameHistoryData> data2;

    /**
     * Creating the box to choose avatar.
     */
    @FXML
    private ComboBox cb;

    /**
     * Creating label to change the view with the avatar.
     */
    @FXML
    private Label lbIV;

    /**
     * Allows to display the data of wins and losses.
     *
     * @param location where the DB is.
     * @param resources the information used from the DB.
     */
    @Override
    public void initialize(final URL location, final ResourceBundle resources) {

        // win/loss table view
        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colLoss.setCellValueFactory(f -> f.getValue().userLossProperty());
        buildWinsLossDashData();


        // Game history table view
        colP1.setCellValueFactory(f -> f.getValue().player1Property());
        colP2.setCellValueFactory(f -> f.getValue().player2Property());
        colWinner.setCellValueFactory(f -> f.getValue().winnerProperty());
        buildGameHistory();


        addAvatarImages();
        System.out.println(Controller.lastLogin);
        lastLoginLabel.setText(Controller.lastLogin);
    }


    /**
     * Actually builds the information displayed for the Game History.
     */
    public void buildGameHistory() {
        try {

            ResultSet rs = UserDB.getGameHistory();

            data2 = FXCollections.observableArrayList();

            while (rs.next()) {
                GameHistoryData gh = new GameHistoryData();
                gh.setPlayer1(rs.getString("player1"));
                gh.setPlayer2(rs.getString("player2"));
                gh.setWinner(rs.getString("winner"));
                data2.add(gh);
            }

        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");
        }

        gameHisTbl.setItems(data2);
    }


    /**
     * Actually builds the information displayed for the win/loss.
     */
    private void buildWinsLossDashData() {
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


    /**
     * Allows for the leaderboard to be displayed on button click.
     */

    public void onLdrClick() {
        GUI leaderboard = new GUI();
        leaderboard.showLeaderboard();
    }


    /**
     * Open a new interface for Admin manage users.
     */
    public void onManageClick() {
        if (Integer.parseInt(UserDB.getAuthority(Controller.username)) == 1) {
            System.out.println("You are Admin");
            try {
                Parent manageboard;
                manageboard = FXMLLoader.load(getClass().getResource("Manage.fxml"));
                Stage mainStage;
                mainStage = GUI.parentWindow;
                mainStage.getScene().setRoot(manageboard);
                mainStage.setMinWidth(625.0);
                mainStage.setMinHeight(450.0);
                mainStage.setMaxWidth(625.0);
                mainStage.setMaxHeight(450.0);
                mainStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("You are not an Admin");
        }
    }
    /**
     * Switch to another stage of setting gameboard size and players.
     * @throws IOException Exception thrown
     */
    public void onNewGame() throws IOException {
        Parent gameMatch;
        gameMatch = FXMLLoader.load(getClass().getResource("GameMatch.fxml"));
        Stage mainStage;
        mainStage = GUI.parentWindow;
        mainStage.getScene().setRoot(gameMatch);
        mainStage.setMinWidth(400.0);
        mainStage.setMinHeight(300.0);
        mainStage.setMaxWidth(400.0);
        mainStage.setMaxHeight(300.0);
        mainStage.show();
    }

    /**
     * Provides functionality to go back to the login screen from the dashboard.
     */
    public void onLogOut() {
        GUI login = new GUI();
        login.logIn();
    }

    /**
     * This method will add avatar images and avatar images names in the combo-box.
     */
    private void addAvatarImages() {
        ObservableList<String> avatars = FXCollections.observableArrayList();
        avatars.add(getClass().getResource("/avatarImages/Antman.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/BlackPanther.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/CaptainMarvel.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/CaptainAmerica.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Hulk.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Ironman.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Spiderman.png").toExternalForm());
        avatars.add(getClass().getResource("/avatarImages/Thor.png").toExternalForm());
        cb.setPromptText("Select Avatar");
        cb.setItems(avatars);
        cb.setButtonCell(new AvatarImages());
        cb.setCellFactory(param -> new AvatarImages());

        lbIV.setStyle("-fx-background-radius: 200px;"
                + "-fx-background-color: red;"
                + "-fx-border-radius:40px");

        cb.setOnAction(event -> {
            String n = cb.getSelectionModel().getSelectedItem().toString();
            BackgroundImage myBI = new BackgroundImage(new Image("/avatarImages/"
                    + AvatarImageName.getImageName(n) + ".png", 80, 80, false, true),
                    BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
            lbIV.setBackground(new Background(myBI));
        });
    }
}
