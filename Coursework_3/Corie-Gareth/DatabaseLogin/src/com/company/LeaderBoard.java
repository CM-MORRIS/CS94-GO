package com.company;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.*;


public class LeaderBoard extends Stage {


    Button openOther = new Button("Open other Stage");
    HBox x = new HBox();

    LeaderBoard() {
        x.getChildren().add(openOther);
        this.setScene(new Scene(x, 300, 300));
        this.show();
    }
















//    public static void showScore() {
//
//
//
//        String query = ("SELECT "+  COLUMN_USERNAME + " FROM " + TABLE_USERS +" ");
//        try {
//            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
//            Statement statement = conn.createStatement();
//            ResultSet resultSet;
//            resultSet = statement.executeQuery(query);
//            return resultSet.next();

    }


