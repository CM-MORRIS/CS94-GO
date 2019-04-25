package com.Go94;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The AvatarImageName is used split the image url address into
 * image name like hulk etc
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
