package RandomWalker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.scene.shape.Circle;

public class vectorBalls extends Application {
	
	
	private int WIDTH = 800;
	private int HEIGHT = 800;
	Group root = new Group();
	Scene scene = new Scene(root, WIDTH, HEIGHT);
	Circle cir1 = new Circle();
	Circle cir2 = new Circle();
	
	PVector location = new PVector(100, 100);
	PVector velocity = new PVector(2.5, 5.0);
	PVector location1 = new PVector(130, 360);
	PVector velocity1 = new PVector(8.5, 2.0);
	PVector location2 = new PVector(600, 200);
	PVector velocity2 = new PVector(3.5, 6.0);
	
	void iterate(Group rt, Stage s)
	{
		
		
		
		
		checkBounds(location, velocity, rt, cir1);
		checkBounds(location1, velocity1, rt, cir2);
		
		s.setScene(scene);
		s.setResizable(true);
		s.show();
		
	}
	void checkBounds(PVector loc, PVector vel, Group rt, Circle cir)
	{
		loc.add(vel);
		double w_x = scene.getWidth();
		double w_y = scene.getHeight();
		if((loc.x < 0)  || (loc.x > w_x))
		{
			vel.x *=-1;
		}
		if((loc.y < 0) || (loc.y > w_y))
		{
			vel.y *=-1;
		}
		cir.setRadius(15);
		cir.setFill(Color.BLUE);
		cir.setCenterX(loc.x);
		cir.setCenterY(loc.y);
		rt.getChildren().add(cir);
		
	}
	
	
	
	public void start(Stage theStage)
	{
		root.getChildren().clear();
		KeyFrame key = new KeyFrame(Duration.millis(10),e ->
		iterate(root, theStage)
		);
		Timeline t = new Timeline();
		t.getKeyFrames().add(key);
		t.setCycleCount(Timeline.INDEFINITE);
		t.setRate(1);
		t.playFromStart();
		
		
		
	}
	public static void main(String[] args)
	{
		launch(args);
	}
	
	

}
