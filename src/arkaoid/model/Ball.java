package arkaoid.model;

import java.awt.Point;

import arkaoid.ArkanoidStatic;

public class Ball
{
	private Point center = new Point();
	private int radius = ArkanoidStatic.BALL_RADIUS;
	private boolean isMoving = false;
	private int dy = 0;
	private int dx = 0;
	
	
	public boolean isMoving()
	{
		return isMoving;
	}
	
	public void reRandom()
	{
		///TODO Przenieœæ do klasy zajmuj¹cej siê fizyk¹
		double random = Math.random();
		random *= 357;
		random %= 7;
		//if (Math.random() > 0.5) random = -random;
		
		System.out.println((int)-random);
		dy = (int) -random;
		random = Math.sqrt(36-random*random);
		//random = random - (random % 1);
		if (Math.random() > 0.5) random = -random;
		dx = (int) random ;
		if (dx == 0 || dy == 0) reRandom();
		///Test
	}
	
	public void startMoving()
	{
		isMoving = true;
	}
	
	public void stopMoving()
	{
		isMoving = false;
	}
	
	public void setPoint(Point p)
	{
		if (isMoving)
		{
			//TODO Jeœli siê porusza
			if (!(this.center.x + dx > 0 && this.center.x < ArkanoidStatic.GAME_PANEL_DIMENSION.height))
			{
				this.dx = -this.dx;
			}
			
			this.center.x += dx;
				//System.out.println("move");
			
			
			
		} else
		{
			//Point newPoint = new Point(p.x-radius, p.y-radius);
			center.setLocation(p.x-radius/2, p.y-(ArkanoidStatic.PALETTE_DIMENSION.height+1));
			//System.out.println("dont move");
		}
	}
	
	public void move()
	{
		if (!(this.center.x + dx > 0 && this.center.x < ArkanoidStatic.GAME_PANEL_DIMENSION.width-radius))
		{
			this.dx = -this.dx;
		}
		
		if (!(this.center.y + dy > 0 && this.center.y < ArkanoidStatic.GAME_PANEL_DIMENSION.height-radius))
		{
			this.dy = -this.dy;
		}
		
		//System.out.println("from move");
		if (isMoving)
		{
			this.center.x += dx;
			this.center.y += dy;
		}
	}
	
	public Point getPoint()
	{
		return (Point) center.clone();
	}
}
