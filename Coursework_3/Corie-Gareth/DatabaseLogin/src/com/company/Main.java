package com.company;

public class Main {

    public static void main(String[] args) {

      UserDB.createDB();
      LoginForm.launch(LoginForm.class, args);
      LeaderBoard.showScore();
    }
}
