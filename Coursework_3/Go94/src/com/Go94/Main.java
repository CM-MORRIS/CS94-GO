package com.Go94;

/**
 * The main class that starts the project.
 *
 * @author Gareth Thomas and Corie Morris
 */
class Main {

    /**
     * To start the project.
     * @param args The arguments for the project.
     */
    public static void main(final String[] args) {
      UserDB.createDB();
      GUI.launch(GUI.class, args);
    }
}
