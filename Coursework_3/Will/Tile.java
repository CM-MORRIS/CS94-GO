package application;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

	/**
	 * @author Will
	 *
	 */
	public class Tile extends StackPane{
		
		/**
		 * Defines tiles used to build board 
		 */
		public Tile() {
		Rectangle boarder = new Rectangle(100,100);
		boarder.setFill(Color.BEIGE);
		boarder.setStroke(Color.BLACK);
		setAlignment(Pos.CENTER);
		getChildren().addAll(boarder);
	}

			
}
