package com.Go94;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import static com.Go94.UserDB.*;


public class DashBoardView implements Initializable {


    @FXML
    public Button btnLdr;

    @FXML
    public Button newGameBtn;

    @FXML
    public Button newGameBtn9;

    @FXML
    public Button newGameBtn13;

    @FXML
    public Button newGameBtn19;

    @FXML
    public Label lastLoginLabel;

    @FXML
    public Button logOut;

    @FXML
    private TableView<WinsLossData> winlosstable;

    @FXML
    private TableColumn<WinsLossData, Number> colWins;

    @FXML
    private TableColumn<WinsLossData, Number> colLoss;
    private ObservableList<WinsLossData> data1;
    @FXML
    private ComboBox cb;
    @FXML
    private Label lbIV;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // win/loss table view
        colWins.setCellValueFactory(f -> f.getValue().userWinsProperty());
        colLoss.setCellValueFactory(f -> f.getValue().userLossProperty());
        buildWinsLossDashData();
        addAvatarImages();
        System.out.println(Controller.lastLogin);
        lastLoginLabel.setText(Controller.lastLogin);
    }


    // shows win/loss table view
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


    /**
     *
     */

    public void onLdrClick() {
        GUI leaderboard = new GUI();
        leaderboard.showLeaderboard();
    }


    /**
     * Open a new interface for Admin manage users
     * @author Andy
     */
    public void onManageClick() {
        if(Integer.parseInt(UserDB.getAuthority(Controller.username))==1) {
            System.out.println("You are Admin");
            try {
                Parent manageboard;
                manageboard = FXMLLoader.load(getClass().getResource("Manage.fxml"));
                Stage mainStage;
                mainStage = GUI.parentWindow;
                mainStage.getScene().setRoot(manageboard);
                mainStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else System.out.println("You are not Admin");
    }
    /**
     * Switch to another stage of setting gameboard size and players
     * @author Andy
     * @throws IOException
     */
    public void onNewGame() throws IOException {
        Parent Leaderboard;
        Leaderboard = FXMLLoader.load(getClass().getResource("GameMatch.fxml"));
        Stage mainStage;
        mainStage = GUI.parentWindow;
        mainStage.getScene().setRoot(Leaderboard);
        mainStage.show();
    }

    /**
     * Provides functionality to go back to the login screen from the dashboard.
     */
    public void onLogOut() {
        GUI login = new GUI();
        login.logIn();
    }


     /*
     * @author tibo
     * This method will add avatar images and avatar images names in the combo-box
     * */
    private void addAvatarImages(){
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

        lbIV.setStyle("-fx-background-radius: 200px;" +
                "-fx-background-color: red;" +
                "-fx-border-radius:40px");

        cb.setOnAction(event -> {
            String n = cb.getSelectionModel().getSelectedItem().toString();
            BackgroundImage myBI= new BackgroundImage(new Image("/avatarImages/"+AvatarImageName.getImageName(n)+".png",
                    80,80,false,true),
                    BackgroundRepeat.ROUND, BackgroundRepeat.ROUND, BackgroundPosition.CENTER,
                    BackgroundSize.DEFAULT);
            lbIV.setBackground(new Background(myBI));
        });

    }

}

