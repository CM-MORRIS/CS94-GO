//this class is a test example of how to pull the data from the database for when populating the GUI


//package com.company;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.Statement;
//
//public class SQLiteJDBC {
//    public static final String TABLE_TESTING = "users"; //the name of the table you want to use
//    public static void main( String args[] ) {
//
//
//        Connection c = null;
//        Statement stmt = null;
//        try {
//            Class.forName("org.sqlite.JDBC");
//            c = DriverManager.getConnection("jdbc:sqlite:userDB.db"); //userDB is the name of the database
//            c.setAutoCommit(false);
//            System.out.println("Opened database successfully");
//
//            stmt = c.createStatement();
//            ResultSet rs = stmt.executeQuery( "SELECT * FROM " + TABLE_TESTING + ";" );  // the SQL statement
//
//            while ( rs.next() ) { //loop through the date, in this case username 1,2,3.... etc...
//
//                String  username = rs.getString("USERNAME");
//
//
//
//                System.out.println( "username = " + username );  //print out the information (this can be implemented with the gui)
//                System.out.println();
//            }
//            rs.close();
//            stmt.close();
//            c.close();
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//            System.exit(0);
//        }
//        System.out.println("Operation done successfully");
//    }
//}

