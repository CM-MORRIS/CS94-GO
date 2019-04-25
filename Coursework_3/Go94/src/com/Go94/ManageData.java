package com.Go94;

import javafx.beans.property.*;

/**
 * create element which can store data
 * Start game
 * @author Zhifang Li
 */
public class ManageData {
     
    /**
     * create variable to show element
     */
    private StringProperty username = new SimpleStringProperty();
     
    /**
     * Element needing to be displayed
     *
     * @return the username from the DB
     */
    public StringProperty usernameProperty() {
        return username;
    }
     
    /**
     * Gets the property for the initial username and returns as a string
     *
     * @return the username after passed through the DB
     */
    public String getUsername() {
        return username.get();
    }

    /**
     * Finally sets name as the username after it has been passed to a string.
     *
     * @param name what will be set the username to be displayed.
     */
    public void setUsername(String name) {
        this.username.set(name);
    }
}
