import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

class cleanMover {
	Vector location;
	Vector velocity;
	Vector acceleration;
	Vector dir;
	Vector mouse;
	double topspeed = 10; 
	Scene mainScene;
	double mass;
	Paint color;
	int[] neighbor = new int[Window.AMOUNT_OF_MOVERS];
	int ID;
	int neighbors;
	
	cleanMover(Scene scene)
	{
		location = new Vector((Math.random() * scene.getWidth()), (Math.random() * scene.getHeight())); 
		//location = new Vector((scene.getWidth()/2) + ((Math.pow(-1, Math.round(Math.random()))) * (250 * Math.random())), (scene.getHeight()/2) + ((Math.pow(-1, Math.round(Math.random()))) * (250 * Math.random())) );
		//velocity = new Vector((ThreadLocalRandom.current().nextInt(-2, 3)), (ThreadLocalRandom.current().nextInt(-2, 3)));
		//velocity = new Vector(Math.pow(-1, Math.round(Math.random())) * Math.random() * 2, Math.pow(-1, Math.round(Math.random())) * Math.random() * 2);
		velocity = new Vector(1, .3);
		acceleration = new Vector(0.00, 0.00);
		mainScene = scene;
		mass = 50;
		
		
		
		
		
		
		
		
		
	}
	
	void localGrav(Vector v)
	{
		Vector gravPull = Vector.sub(v, location);
		gravPull.normalize();
		gravPull.mult(mass);
		gravPull.mult(0.0002);
		
		applyForce(gravPull);
	}
	
	void setID(int i)
	{
		this.ID = i;
	}
	int getID()
	{
		return this.ID;
	}
	void update()
	{
		mouse = new Vector(Window.MOUSE_X, Window.MOUSE_Y);
		Vector dir = Vector.sub(mouse, location);
		Vector random_wind = new Vector((Math.pow(-1, Math.round(10 * Math.random())) * Math.random()), (Math.pow(-1, Math.round(10 * Math.random())) * Math.random()));
		Vector gravity = new Vector(0, 0.1 * mass);
		Vector wind = new Vector(0.1, 0);
		//System.out.println(dir.x + " " + dir.y);   //  ##  Mouselocation DEBUG  ##
		dir.normalize();
		dir.mult(0.5);
		//applyForce(dir);		//applies force of mouse pointer attractor
		applyForce(wind);
		
		//applyForce(random_wind);
		//applyForce(gravity);
		//applyForce(wind);
		//acceleration.Random2D();
		velocity.add(acceleration);
		velocity.limit(topspeed);
		location.add(velocity);
		acceleration.mult(0);
		
		
	}
	void display(GraphicsContext gc)
	{
		if(neighbors > 20)
		{
			this.color = Color.RED;
		}
		if(neighbors <= 20)
		{
			this.color = Color.BLUE;
		}
		gc.setFill(color);
		
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(1.5);
		gc.fillOval(location.x, location.y, mass, mass);
		
		
		
	}
	
	void calculateNeighbors(Mover reference)
	{
		
		if(this.location.dist(reference.location) < 50)
		{
			this.neighbor[reference.getID()] = 1;
		}
		else if(this.location.dist(reference.location) >= 70)
		{
			this.neighbor[reference.getID()] = 0;
		}
		
		
		
	}
	void processNeighbors()
	{
		neighbors = 0;
		for(int i = 0; i < Window.AMOUNT_OF_MOVERS; i++)
		{
			if(this.neighbor[i] == 1)
			{
				neighbors++;
			}
			
		}
	}
	void checkBounds_Bounce(Scene scene)
	{
		if(location.x > scene.getWidth() || location.x < 0)
		{
			velocity.x *= -1;
		}
		else if(location.y > scene.getHeight() || location.y < 0)
		{
			velocity.y *= -1;
		}
	}
	
	void checkBounds_infinite(Scene scene)
	{
		if(location.x > scene.getWidth())
		{
			location.x = 0;
		}else if (location.x < 0)
		{
			location.x = scene.getWidth();
		}
		if(location.y > scene.getHeight())
		{
			location.y = 0;
		}else if (location.y < 0)
		{
			location.y = scene.getHeight();
		}
	}
	void applyForce(Vector force)
	{
		Vector f = force.get();
		f.div(mass);
		acceleration.add(f);
		
	}
}
