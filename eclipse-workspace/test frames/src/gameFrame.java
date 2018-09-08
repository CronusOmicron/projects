import javax.swing.GroupLayout.Group;
import javax.swing.JFrame;

import javafx.stage.Stage;
import javafx.*;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Circle;

import javax.*;
import java.awt.*;


public class gameFrame {
	public void start(Stage theStage) {
		theStage.setTitle("Planets");
		
		Group root = new Group();
		Scene theScene = new Scene(root);
		theStage.setScene(theScene);
		
		Canvas canvas = new Canvas(512, 512);
		root.getChildren() .add( canvas );
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		Circle circle = new Circle();
		circle.setRadius(5);
		circle.setCenterX(50);
		circle.setCenterY(50);
	
		
		
		
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
