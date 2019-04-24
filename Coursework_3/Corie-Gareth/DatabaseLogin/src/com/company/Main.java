package com.company;


import javafx.application.Application;

public class Main {
    public static void main(String[] args) {

      UserDB.createDB();
      GUI.launch(GUI.class, args);

      // Application.launch(BoardHandler9.class, args);

    }
}
