package arkaoid.model;

import java.awt.Point;

public class IndestructibleBrock extends Brick
{

	public IndestructibleBrock(Point point)
	{
		super( point);
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
		// TODO Auto-generated method stub
		return -1;
	}

	@Override
	public void decreasLife()
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDestructible()
	{
		// TODO Auto-generated method stub
		return false;
	}
	

}
