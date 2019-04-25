package com.Go94;

import javafx.beans.property.*;

public class ManageData {
     /**
     * create element which can store data
     * Start game
     * @author Andy
     */
    private StringProperty username = new SimpleStringProperty();

    public StringProperty usernameProperty() {
        return username;
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(String name) {
        this.username.set(name);
    }
}
