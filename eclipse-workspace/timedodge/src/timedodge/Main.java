package timedodge;
import javafx.animation.AnimationTimer;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.stage.Stage;


public class Main extends Application{

	
	static int dx_obstacle = 1;
	static int[] viewPort = new int[]{400,700};
	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage theStage) {
		
		Points[] obj = new Points[1];
		obj[0] = new Points(-200, -200);
		
		theStage.setTitle("TimeDodge ALPHA");
		Group root = new Group();
		Scene scene = new Scene(root, 400, 700);
		theStage.setScene(scene);
		theStage.centerOnScreen();
		theStage.setResizable(false);
		obstacle(scene, obj[0].getX(), obj[0].getY());
		theStage.show();
		;
		
		
		
		
		
		
		
		
		
		
	}
	@SuppressWarnings("unused")
	private void obstacle(final Scene scene, int x, int y) {
		Circle obstacle = new Circle(x + viewPort[0], y + viewPort[1],  25);
		obstacle.setFill(Color.GRAY);
		obstacle.setStroke(Color.BLANCHEDALMOND);
		
		final Group root = (Group) scene.getRoot();
		root.getChildren().add(obstacle);
	}
}
class Points{
	private int x;
	private int y;
	public Points(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	
	public int getX() {
		return x;
	}
	public  int getY() {
		return y;
	}
	
}
