package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class UserDB {

    // Includes:
    // createDB
    // addUser
    // checkUserPass
    // checkUser


    public static final String DB_NAME = "userDB.db";
//    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Tibo/Pictures/DatabaseLogin/" + DB_NAME;
    public static final String CONNECTION_STRING = "jdbc:sqlite:/Users/Tibo/Pictures/DatabaseLogin2/" + DB_NAME;
    public static final String TABLE_USERS = "users";
    public static final String COLUMN_ID = "userid";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_SURNAME = "surname";
    public static final String COLUMN_WINS = "wins";
    public static final String COLUMN_LOSS = "loss";
    public static final String COLUMN_WIN_PERCENTAGE = "winPercentage";
    public static final String COLUMN_ADMIN = "admin";
    public static final String COLUMN_AVATAR = "avatar";

    // creates a database if doesn't exist
    public static void createDB() {
        try {
            // connects to DB
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            // ...
            Statement statement = conn.createStatement();
            // executes create DB query
//             statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
//                                 COLUMN_USERNAME + " VARCHAR NOT NULL, " + COLUMN_PASSWORD + " VARCHAR NOT NULL, " +
//                                 COLUMN_WINS + " INTEGER DEFAULT 0, " + COLUMN_LOSS + " INTEGER DEFAULT 0," +
//                                 COLUMN_WIN_PERCENTAGE + " INTEGER DEFAULT 0, " + COLUMN_ADMIN + " INTEGER DEFAULT 0)");
//            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
//                                COLUMN_USERNAME + " VARCHAR NOT NULL, " + COLUMN_PASSWORD + " VARCHAR NOT NULL, " +
//                                COLUMN_WINS + " INTEGER DEFAULT 0, " + COLUMN_LOSS + " INTEGER DEFAULT 0," +
//                                COLUMN_FIRSTNAME + " INTEGER DEFAULT 0, " + COLUMN_SURNAME + " INTEGER DEFAULT 0, " +
//                                COLUMN_WIN_PERCENTAGE + " INTEGER DEFAULT 0, " + COLUMN_ADMIN + " INTEGER DEFAULT 0)");

/*            statement.execute("DROP TABLE "+ TABLE_USERS);*/
            statement.execute("CREATE TABLE if NOT EXISTS " + TABLE_USERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
                    COLUMN_USERNAME + " VARCHAR NOT NULL, " + COLUMN_PASSWORD + " VARCHAR NOT NULL, " +
                    COLUMN_FIRSTNAME + " VARCHAR NOT NULL, " + COLUMN_SURNAME + " VARCHAR NOT NULL, " +
                    COLUMN_WINS + " INTEGER DEFAULT 0, " + COLUMN_LOSS + " INTEGER DEFAULT 0," +
                    COLUMN_WIN_PERCENTAGE + " INTEGER DEFAULT 0, " + COLUMN_ADMIN + " INTEGER DEFAULT 0, "+
                    COLUMN_AVATAR + " VARCHAR NOT NULL)"
            );

            // 1 if admin, else 0
            statement.close();
            // closes connection to DB
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    // adds user to DB
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

    //adds user with username, password, firstname and surname
    public static void addUser(String u, String p, String f,String s,String avatar) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate("INSERT INTO " + TABLE_USERS + " (" + COLUMN_USERNAME + ", " + COLUMN_PASSWORD +", "
                    + COLUMN_FIRSTNAME +", " + COLUMN_SURNAME +", "+COLUMN_AVATAR+ ") " +
                    "VALUES " + "(" + "'" + u + "'" + ", " + "'" + p + "'" +  ", " + "'" + f + "'" + "," +
                    " " + "'" + s +  "'"+", " + "'" + avatar + "'" + " )");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    public static void deleteUser(String username) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate("delete from "+TABLE_USERS+" where "+COLUMN_USERNAME
                    +" = '"+username+"'");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    //
    public static void changeAuothority(String username) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate("update "+TABLE_USERS+" set "+
            COLUMN_ADMIN+"=1 where "+COLUMN_USERNAME+"='"+username+"'");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    // returns true if user and password match
    public static boolean checkUserPass(String u, String p) {


        String query = "SELECT " + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + " FROM " + TABLE_USERS +
                " WHERE " + COLUMN_USERNAME + " = '" + u + "'" + " AND " + COLUMN_PASSWORD + " = '" + p + "'";

        try {

            Connection conn = DriverManager.getConnection(CONNECTION_STRING, "username", "password");

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();


            // the (1) (2) represents column number of the returned query(rs). (4) would be 4th column etc.
            // rs.next iterates to next row in returned query set - next will keep iterating until no more rows.
            while (rs.next()) {
                if (u.equals(rs.getString(1))) {
                    if (p.equals(rs.getString(2))) return true;
                }
            }

            rs.close();
            conn.close();

            } catch(SQLException e){
                System.out.println("Something went wrong: " + e.getMessage());
                return false;
            }
            return false;
        }

    // checks DB for existing username
    public static boolean checkUser(String u) {

        String query = "SELECT " + COLUMN_USERNAME + " FROM " + TABLE_USERS +
            " WHERE " + COLUMN_USERNAME + " = '" + u + "'";

        try {

            Connection conn = DriverManager.getConnection(CONNECTION_STRING);

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (u.equals(rs.getString(1))) return true;
            }

            rs.close();
            conn.close();

        } catch(SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
        return false;
    }

    public static ResultSet getLeaderBoardData() {

            String query = "SELECT " + COLUMN_USERNAME + ", " + COLUMN_WINS + ", " + COLUMN_WIN_PERCENTAGE + " FROM " + TABLE_USERS;

            try {
                Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                Statement results = conn.createStatement();

                ResultSet rs = results.executeQuery(query);

                // NOTE: do not close connection otherwise results will not show in tableView
//                results.close();
//                conn.close();

                return rs;


            } catch (SQLException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }


            return null;
        }

    public static ResultSet getWinsLossData(String u) {

        String query = "SELECT " + COLUMN_WINS + ", " + COLUMN_LOSS + " FROM " +
                        TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + u + "'";

         try {
                Connection conn = DriverManager.getConnection(CONNECTION_STRING);
                Statement results = conn.createStatement();
                ResultSet rs = results.executeQuery(query);

                return rs;

            } catch (SQLException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
            return null;
    }


}
