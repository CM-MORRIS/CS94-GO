package com.company;

import java.sql.*;

public class UserDB {

    public static final String DB_NAME = "userDB.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/cmorris/Desktop/CS94-GO/Coursework_3/Corie-Gareth/DatabaseLogin/" + DB_NAME;
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "userid";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";


    public static void createDB() {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            // statement.execute("DROP TABLE IF EXISTS " + TABLE_USERS);

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                        COLUMN_USERNAME + " TEXT NOT NULL, " + COLUMN_PASSWORD + " TEXT NOT NULL" + ")");

            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
          }
    }

//pomwopemowemowefow

    public static void addUser(String u, String p) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate("INSERT INTO " + TABLE_USERS + " (" + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ") " +
                                     "VALUES " + "(" + "'" + u + "'" + ", " + "'" + p + "'" + ")");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }


    // if user and password match returns true NOT WORKING
    public static boolean checkUser(String u, String p) {

        String query = ("SELECT EXISTS(SELECT * FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = " + "'" + u + "'" +
                "AND " + COLUMN_PASSWORD + " = " + "'" + p + "'" + ")");

        try {

            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement;
            ResultSet resultSet;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(query);
            return resultSet.next();

        } catch (SQLException se) {
            se.printStackTrace();
            return false;
          }
    }


    // not complete
    public void deleteUser(String user) {

    }


}
