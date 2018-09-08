package subCells;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.shape.*;
import javafx.application.Application;


import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.input.KeyCode;



public class Main extends Application{
	static double d_x = 0;
	static double d_y = 0.1;
	static int[] playerPos = {400, 400};
	Rectangle[] objects = {};
	double[] wallLeftLOC = {70 + d_x, 20 + d_y};

	public static void main(String[] args) {
		launch(args);
		// TODO Auto-generated method stub

	}
	public void start(Stage theStage)
	{
		
		Group root = new Group();
		Scene scene = new Scene(root, 800, 800);
		theStage.setScene(scene);
		theStage.setResizable(false);
		
		
		
		
		Circle play = player();
		Rectangle wallLeft = new Rectangle(wallLeftLOC[0], wallLeftLOC[1], 200, 600);
		root.getChildren().addAll(play, wallLeft);
		
		
		
		theStage.show();
		animation(scene, wallLeft);
	}
	public Circle player()
	{
		Circle player = new Circle(playerPos[0], playerPos[1], 15);
		player.setFill(Color.BLUE);
		player.setStroke(Color.GRAY);
		return player;
	}
	private void animation(final Scene scene, Rectangle rec)
	{
		
		
		
		final Group root = (Group) scene.getRoot();
		
		
		
		Timeline tl = new Timeline();
		tl.setCycleCount(Animation.INDEFINITE);
		KeyFrame moveScene = new KeyFrame(Duration.seconds(.0200), e -> {
			
			rec.setTranslateX(rec.getTranslateX() + d_x);
			rec.setTranslateY(rec.getTranslateY() + d_y);
			root.setOnKeyPressed(s -> {
				switch (s.getCode()) {
				case A:
					d_x = 1;
					break;
				case D:
					d_x --;
					break;
				case W:
					d_y--;
					break;
				case S:
					d_y++;
					break;
				default:
					break;
				}
				
			});	
			
		});
		
		tl.getKeyFrames().add(moveScene);
		tl.setRate(50);
		tl.play();
		
		
	}
}

