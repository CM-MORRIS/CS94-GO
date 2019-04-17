package application;


    import javafx.application.Application;
    import javafx.event.ActionEvent;
    import javafx.event.EventHandler;
    import javafx.geometry.Pos;
	import javafx.stage.Stage;
	import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
	import javafx.scene.layout.Pane;
	import javafx.scene.layout.StackPane;
	import javafx.scene.paint.Color;
	import javafx.scene.shape.Circle;
	import javafx.scene.shape.Rectangle;
	import javafx.scene.Parent;


	public class Main extends Application implements EventHandler<ActionEvent>{
		double mouseX ;
		private Parent createContent() {
			
			
			Pane root = new Pane();
			root.setPrefSize(500,500);
			
			for (int i=0 ; i < 9 ; ++i) {
				for(int j = 0 ; j < 9 ; ++j) {
					Tile tile = new Tile();
					tile.setTranslateX(j*50);
					tile.setTranslateY(i*50);
					
					root.getChildren().add(tile);
				}
				
			}
			root.setOnMouseClicked(new EventHandler<MouseEvent>() {
			    @Override
			        public void handle(MouseEvent event) {
			        System.out.println(event.getSceneX());
			        System.out.println(event.getSceneY());
			    }
			});
			return root;
		}
		@Override
		public void start(Stage primaryStage) {
				primaryStage.setScene(new Scene(createContent()));
				primaryStage.show();
		}
		
		private class Tile extends StackPane{
			public Tile() {
				Rectangle boarder = new Rectangle(50,50);
				boarder.setFill(Color.BEIGE);
				boarder.setStroke(Color.BLACK);
				setAlignment(Pos.BASELINE_CENTER);
				getChildren().addAll(boarder);
			}
		}

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
