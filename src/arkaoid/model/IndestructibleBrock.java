package arkaoid.model;

import java.awt.Point;

public class IndestructibleBrock extends Brick
{

	public IndestructibleBrock(Point point)
	{
		super(point);
	}

	public IndestructibleBrock(int x, int y)
	{
		super(x, y);
	}

	public boolean hit()
	{
		return true;
	}

	@Override
	public int getLife()
	{
		return -1;
	}

	@Override
	public boolean isDestructible()
	{
		return false;
	}

}
