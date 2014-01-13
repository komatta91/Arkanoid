package arkaoid.model;

import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import arkaoid.ArkanoidStatic;

public abstract class Brick
{

	protected Point point;
	private int height = ArkanoidStatic.BRICK_DIMENSION.height;
	private int width = ArkanoidStatic.BRICK_DIMENSION.width;

	public Brick(Point point)
	{
		
		this.point = point;
	}
	
	public Brick(int x, int y)
	{
		this.point = new Point(x, y);
	}

	public boolean isHit(Point point, int radius)
	{
		Ellipse2D ball = new Ellipse2D.Double();
		ball.setFrame(point.x, point.y, radius, radius);
		Rectangle2D brick = new Rectangle2D.Double(this.point.x, this.point.y, width, height);
		Area area = new Area(ball);
		//if (area.intersects(brick)) System.out.println("x = " + this.point.x + ", y =" + this.point.y);
		return area.intersects(brick);
	}
	
	abstract public boolean hit();
	
	public void print()
	{
		System.out.println("x = " + point.x + ", y =" + point.y);
	}
	
	public Point getPoint()
	{
		return (Point) this.point.clone();
	}
	
	public abstract int getLife();
	public abstract void decreasLife();
	public abstract boolean isDestructible();
}