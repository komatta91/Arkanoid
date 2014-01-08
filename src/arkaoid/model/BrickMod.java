package arkaoid.model;

import java.awt.Point;

public class BrickMod
{
	private int life;
	private Point point;
	
	public BrickMod(int life, Point point)
	{
		setPoint(point);
		setLife(life);
	}
	
	
	
	public int getLife()
	{
		return life;
	}
	public void setLife(int life)
	{
		this.life = life;
	}
	public Point getPoint()
	{
		return point;
	}
	public void setPoint(Point point)
	{
		this.point = point;
	}
}
