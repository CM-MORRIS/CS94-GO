package com.company;

import java.sql.*;

public class LeaderBoard {

    public static final String DB_NAME = "userDB.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Gareth\\IdeaProjects\\CS94-GO\\Coursework_3\\Corie-Gareth\\DatabaseLogin\\userDB.db" + DB_NAME;
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_USERNAME = "username";

    public static boolean showScore() {
        String query = ("SELECT "+  COLUMN_USERNAME + "FROM " + TABLE_USERS +" ");
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery(query);
            return resultSet.next();
        } catch (SQLException se) {
            System.out.println("Something went wrong: " + se.getMessage());
            se.printStackTrace();
            return false;
        }
    }
}

