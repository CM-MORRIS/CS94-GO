package com.Go94;

import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.TextAlignment;

/**
 * the AvatarImages class is used to set image in the combo box with image text.
 *  * It extends the listCell class that is used to override the
 *  * update method of the listCell class.
 *
 * @author tibo
 */

public class AvatarImages extends ListCell<String> {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        setText(null);
        if(item!=null){
            ImageView imageView = new ImageView(new Image(item));
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            setAlignment(Pos.CENTER_LEFT);
            setGraphicTextGap(10);
            setTextAlignment(TextAlignment.CENTER);
            setGraphic(imageView);
            setText(AvatarImageName.getImageName(item));
        }
    }
}

