package com.Go94;

public class Main {

    public static void main(String[] args) {

      UserDB.createDB();
      GUI.launch(GUI.class, args);

      // Application launch must not be called more than once or exception will be thrown
        // have to extend stage instead

      // LeaderBoard.launch(LeaderBoard.class, args);


    }
}
