package com.company;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author tibo
 */
public class AvatarImageName {

    public static String getImageName(String fileUrl){
        if(!fileUrl.isEmpty()){
            String[] sp = fileUrl.split("/");
            String fullName = sp[sp.length-1];
            String[] name = fullName.split(".png");
            return name[0];
        }
        return "";
    }

}
