package application;
    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Pos;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.Pane;
	import javafx.scene.paint.Color;
	import javafx.scene.shape.Circle;
	import javafx.scene.Parent;
	import java.util.ArrayList;
	import java.util.List;

	/**
	 * @author Will
	 *
	 */
	public class Main extends Application implements EventHandler<ActionEvent>{
		/**
		 * Player class instance
		 * @param player 1
		 * @param player 2 
		 */
		Player player = new Player("Will", "Alex");
		/**
		 * Board Logic instance
		 * @param height
		 * @param width
		 */
		BoardLogic bl = new BoardLogic(12,12);
		
		/**
		 * Firstly creates the board using two for loops
		 * The board is then initialised with its starting values
		 * On click event implemented
		 * x and y of mouse click are found
		 * adjacent points called and printed
		 * @return the pane of the game
		 * 
		 */
		private Parent createContent() {
		Pane root = new Pane();
		root.setPrefSize(1000,1000);
		
		for(int i =1 ; i < 9; ++i) {
			for(int j=1 ; j< 9 ; ++j) {
				Tile tile = new Tile();
				tile.setTranslateX(j*100);
				tile.setTranslateY(i*100);
				root.getChildren().addAll(tile);
			}
		}
		bl.initiliseStates();
		root.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
			int x_coord = (int)(Math.rint((e.getSceneX())/100));
			int y_coord = (int)(Math.rint((e.getSceneY())/100));
			FindAdjacentPoints fap = new FindAdjacentPoints(bl, x_coord,y_coord);
			for (int i: fap.Find(x_coord,y_coord)) {
				
				System.out.print(" " + i);
			}
			if(player.whosTurn() == 1 && bl.getBoardValue(x_coord, y_coord) == 0) {
				try {
					Circle circle = new Circle(x_coord*100,y_coord*100,25);
				    circle.setFill(Color.BLACK);
				    root.getChildren().add(circle);
				    bl.updateBoard(x_coord  , y_coord);
				    player.incrementTurnCounter();
			        }
				
				catch(Exception place ){
					if(bl.getBoardValue(x_coord, y_coord) == 2) {
						Circle circle = new Circle(x_coord*100,y_coord*100,25);
					   	root.getChildren().remove(circle);
					   	player.decrementTurnCounter();
					 }
				}
			}
			else if(player.whosTurn() == 2 && bl.getBoardValue(x_coord, y_coord) == 0) {
				try {
					Circle circle = new Circle(x_coord*100,y_coord*100,25);
					circle.setFill(Color.WHITE);
					root.getChildren().add(circle);
					circle.setStroke(Color.BLACK);
					bl.updateBoard(x_coord, y_coord);
				    player.incrementTurnCounter();
				}
				catch(Exception place) {
					if(bl.getBoardValue(x_coord, y_coord) == 1) {
						Circle circle = new Circle(x_coord*100,y_coord*100,25);
					   	root.getChildren().remove(circle);
					   	player.decrementTurnCounter();
					   
					   		}
					   	}
					}
			System.out.println();
			//System.out.println(x_coord + " " + y_coord);
			//bl.printArray();
			}
			});
			return root;
		}
		@Override
		public void start(Stage primaryStage) {
				primaryStage.setScene(new Scene(createContent()));
				primaryStage.show();
		}
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void handle(ActionEvent event) {	
		
	}
	
	
}