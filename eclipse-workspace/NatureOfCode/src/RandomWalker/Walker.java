package RandomWalker;
import java.lang.Math;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;


import java.util.Random;
import javafx.scene.shape.Circle;

public class Walker extends Application{
	int x;
	int y;
	int d_;
	int WIDTH = 1200;
	int HEIGHT = 800;
	int color;
	
	void walk()
	{
		x = WIDTH/2;
		y = HEIGHT/2;
		
	}
	void point(Group f, double time)
	{
		
		Circle point = new Circle();
		point.setRadius((time) + 1);
		System.out.println(time);
		if(color == 1) point.setFill(Color.RED);
		else if(color == 2) point.setFill(Color.GREEN);
		else if(color == 3) point.setFill(Color.BLUE);
		else if(color == 4) point.setFill(Color.YELLOW);
		point.setCenterX(x);
		point.setCenterY(y);
		f.getChildren().add(point);
		
		
	}
	void display(Group g, double time)
	{
		point(g, time);
	}
	
	public int random(int i)
	{
		Random rn = new Random();
		
		int random = rn.nextInt(i);
		return random + 1;
	}
	
	void step(double t)
	{
		int choice = random(4);
		if(choice == 1)
		{
			x += 2 + (random(10)/6);
			color = 1;
		}
		else if(choice ==2)
		{
			y += 2 + (random(10)/6);	
			color = 2;
		}
		else if(choice == 3)
		{
			x -= 2 + (random(10)/6);
			color = 3;
		} 
		else if(choice == 4)
		{
			y -= 2 + (random(10)/6);
			color = 4;
		}
	}
	void draw(Group g, double time)
	{
		step(time);
		display(g, time);
		
		
	}
	double currentTime(double t)
	{
		return System.currentTimeMillis() - t;
	}
	public void start(Stage theStage)
	{
		double startTime = System.currentTimeMillis();
		
		
		walk();
		Group root = new Group();
		Scene scene = new Scene(root, WIDTH, HEIGHT);
		theStage.setScene(scene);
		theStage.setResizable(false);
		scene.setFill(Color.BLACK);
		
		KeyFrame key = new KeyFrame(Duration.millis(1), e ->
		 {
			 double sinAlternator = java.lang.Math.abs(java.lang.Math.sin(currentTime(startTime)/100));
			
			draw(root, sinAlternator);
		
			
			
			
		});
		Timeline tl = new Timeline();
		tl.getKeyFrames().add(key);
		tl.setCycleCount(Timeline.INDEFINITE);
		tl.setRate(1);
		tl.playFromStart();
		theStage.show();
	
		

		
	}
	
	
	
	public static void main(String[] args)
	{
		launch(args);
	}

}
class PVector {
	double x;
	double y;
	
	PVector(double d, double e)
	{
		x = d;
		y = e;
	}
	void add(PVector v)
	{
		x = v.x + x;
		y = v.y + y;
	}
	
}
