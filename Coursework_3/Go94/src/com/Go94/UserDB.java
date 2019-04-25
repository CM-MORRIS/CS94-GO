package com.Go94;

import java.util.Date;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * The class which sets up the database, and allows
 * for it to be able to connect with javafx.
 *
 * @author Corie Morris, Zhifang Li, Pratibh Siris and Gareth Thomas
 */
public class UserDB {

    /**
     * Setting what the database will be called.
     */
    private static final String DB_NAME = "userDB.db";
    /**
     * Setting where the local database is actually stored.
     * Must be changed to local area in code.
     */
    private static final String CONNECTION_STRING = "jdbc:sqlite:/D:/Documents/OneDrive/CompSci/Semester_2/CSCM94_Software Eng Principles/Coursework/Coursework_3/CS94-GO/Coursework_3/Go94/Databases/" + DB_NAME;


    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String TABLE_USERS = "users";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_ID = "userid";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_USERNAME = "username";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_PASSWORD = "password";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_FIRSTNAME = "firstname";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_SURNAME = "surname";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_WINS = "wins";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_LOSS = "loss";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_WIN_PERCENTAGE = "winPercentage";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_ADMIN = "admin";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_LOGINHIS = "loginHistory";

    /**
     * Setting SQL names as variables to be used in statements.
     */
    private static final String COLUMN_AVATAR = "avatar";

    /**
     * Creates database "users" if doesn't exist.
     */
    public static void createDB() {
        try {
            // connects to DB
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);

            // ...
            Statement statement = conn.createStatement();

            // executes create DB query

            statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_USERS + " (" + COLUMN_ID + " INTEGER PRIMARY KEY, "
                    + COLUMN_USERNAME + " VARCHAR NOT NULL, " + COLUMN_PASSWORD + " VARCHAR NOT NULL, "
                    + COLUMN_FIRSTNAME + " VARCHAR NOT NULL, " + COLUMN_SURNAME + " VARCHAR NOT NULL, "
                    + COLUMN_LOGINHIS + " VARCHAR, " + COLUMN_WINS + " DOUBLE DEFAULT 0, " + COLUMN_LOSS
                    + " DOUBLE DEFAULT 0," + COLUMN_WIN_PERCENTAGE + " DOUBLE DEFAULT 0, "
                    + COLUMN_ADMIN + " INTEGER DEFAULT 0, " + COLUMN_AVATAR + " VARCHAR)"
            );


            statement.close();

            // closes connection to DB
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }


    /**
     * add the login history to the username who logs in.
     *
     * @param username The username of the user.
     */
    public static void addLoginHistory(final String username) {
        Connection conn;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = df.format(new Date());

            System.out.println("update " + TABLE_USERS + " set "
                    + COLUMN_LOGINHIS + "='" + date + "' where "
                    + COLUMN_USERNAME + "='" + username + "'");

            statement.executeUpdate("update " + TABLE_USERS + " set "
                    + COLUMN_LOGINHIS + "='" + date
                    + "' where " + COLUMN_USERNAME + "='" + username + "'");
            statement.close();
            conn.close();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * adds a user to database "users".
     *
     * @param u username
     * @param p password
     * @param f first name
     * @param s surname
     * @param avatar The users avatar.
     */
    public static void addUser(final String u, final String p, final String f, final String s, final String avatar) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate("INSERT INTO " + TABLE_USERS + " ("
                    + COLUMN_USERNAME + ", " + COLUMN_PASSWORD + ", "
                    + COLUMN_FIRSTNAME + ", " + COLUMN_SURNAME + ", "
                    + COLUMN_AVATAR + " ) " + "VALUES " + "(" + "'" + u
                    + "'" + ", " + "'" + p + "'" + ", " + "'" + f + "'"
                    + ", " + "'" + s + "'" + ", " + "'" + avatar + "'" + ")");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * To be able to delete a user.
     *
     * @param username to determine who to delete
     */
    public static void deleteUser(final String username) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate("delete from " + TABLE_USERS + " where " + COLUMN_USERNAME
                    + " = '" + username + "'");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }


    /**
     * Changes admin column in database.
     *
     * @param username Username to edit
     */
    public static void changeAuthority(final String username) {
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement statement = conn.createStatement();

            statement.executeUpdate("update " + TABLE_USERS + " set "
                    + COLUMN_ADMIN + "=1 where " + COLUMN_USERNAME + "='"
                    + username + "'");
            statement.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }

    /**
     * check the user whether is admin.
     *
     * @param u username, whoever it is
     * @return String authority
     */
    public static String getAuthority(final String u) {
        String query = "SELECT " + COLUMN_ADMIN + " FROM " + TABLE_USERS
                + " WHERE " + COLUMN_USERNAME + " = '" + u + "'";
        String lastdate = null;
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING,
                    "username", "password");
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lastdate = rs.getString(1);
            }
            rs.close();
            conn.close();
            if (lastdate == null) {
                lastdate = "0";
            }
            return lastdate;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        if (lastdate == null) {
            lastdate = "0";
        }
        return lastdate;
    }


    /**
     * retrieve the last time the user logged.
     *
     * @param u username, whoever it is
     * @return the login date
     */
    public static String getLastLogin(final String u) {
        String query = "SELECT " + COLUMN_LOGINHIS + " FROM " + TABLE_USERS
                + " WHERE " + COLUMN_USERNAME + " = '" + u + "'";
        String lastdate = null;
        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING, "username", "password");
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lastdate = rs.getString(1);
            }
            rs.close();
            conn.close();
            return lastdate;
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return lastdate;
    }


    /**
     * Checks credentials match.
     *
     * @param u Username
     * @param p Password
     * @return true or false depending on whether the user passes check.
     */
    public static boolean checkUserPass(String u, String p) {


        String query = "SELECT " + COLUMN_USERNAME + ", " + COLUMN_PASSWORD
                + " FROM " + TABLE_USERS + " WHERE " + COLUMN_USERNAME
                + " = '" + u + "'" + " AND " + COLUMN_PASSWORD + " = '" + p + "'";

        try {

            Connection conn = DriverManager.getConnection(CONNECTION_STRING, "username", "password");

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            // the (1) (2) represents column number of the returned query(rs). (4) would be 4th column etc.
            // rs.next iterates to next row in returned query set - next will keep iterating until no more rows.
            while (rs.next()) {
                if (u.equals(rs.getString(1))) {
                    if (p.equals(rs.getString(2))) {
                        rs.close();
                        conn.close();
                        return true;
                    }
                }
            }

            rs.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
        return false;
    }


    /**
     * Checks if user exists. returns true if yes, else false.
     *
     * @param u Username
     * @return boolean of true or false
     */
    public static boolean checkUser(final String u) {

        String query = "SELECT " + COLUMN_USERNAME + " FROM " + TABLE_USERS
                + " WHERE " + COLUMN_USERNAME + " = '" + u + "'";

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);

            PreparedStatement ps = conn.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (u.equals(rs.getString(1))) {
                    return true;
                }
            }

            rs.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
            return false;
        }
        return false;
    }


    /**
     * data to be used in the leaderboard.
     *
     * @return a ResultSet of data to store in Leader Board
     */
    public static ResultSet getLeaderBoardData() {

        String query = "SELECT " + COLUMN_USERNAME + ", " + COLUMN_WINS + ", "
                + "((wins)/(wins+loss)*100) AS 'winPercentage' FROM " + TABLE_USERS;

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

    /**
     * Returns as a ResultSet the win/loss data of a user.
     *
     * @param u Username
     * @return This returns the results set.
     */
    public static ResultSet getWinsLossData(final String u) {

        String query = "SELECT " + COLUMN_WINS + ", " + COLUMN_LOSS + " FROM "
                + TABLE_USERS + " WHERE " + COLUMN_USERNAME + " = '" + u + "'";

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


    /**
     * Updates win/loss in database.
     *
     * @param winner Game winner
     * @param loser  Game loser
     */
    public static void updateScores(final String winner, final String loser) {

        String queryWinner = "UPDATE " + TABLE_USERS + " SET " + COLUMN_WINS
                + " = wins + 1 WHERE " + COLUMN_USERNAME + " = " + "'" + winner + "'";

        String queryLoser = "UPDATE " + TABLE_USERS + " SET " + COLUMN_LOSS
                + " = loss + 1 WHERE " + COLUMN_USERNAME + " = " + "'" + loser + "'";

        try {
            Connection conn = DriverManager.getConnection(CONNECTION_STRING);
            Statement results = conn.createStatement();

            results.executeUpdate(queryWinner);
            results.executeUpdate(queryLoser);

            results.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
