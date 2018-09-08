package RandomWalker;

import javafx.scene.shape.Circle; 
import java.util.Random;

public class Ball {
	Random rand = new Random();
	int x = rand.nextInt(5);
	int y = rand.nextInt(5);
	int xx = rand.nextInt(800);
	int yy = rand.nextInt(800);
	
	
	PVector vel = new PVector(x, y);
	PVector pos = new PVector(xx, yy);
	
	public Ball()
	{
		Circle ball = new Circle();
		ball.setCenterX(pos.x);
		ball.setCenterY(pos.y);
		
	}
	
	//public void render(GraphicsContext g) {
		
	//}
	
	//public void update(double duration) {
		
	//}

}
