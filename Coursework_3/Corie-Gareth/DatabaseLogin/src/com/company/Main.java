package com.company;

public class Main {

    public static void main(String[] args) {

      UserDB.createDB();
      LoginForm.launch(LoginForm.class, args);

      // Application launch must not be called more than once or exception will be thrown
        // have to extend stage instead

      // LeaderBoard.launch(LeaderBoard.class, args);


    }
}
