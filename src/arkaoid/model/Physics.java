package arkaoid.model;

import java.awt.Point;

public class Physics
{
	Point previous;
	boolean ballIsMoving = false; 

	public void move(Ball ball, Bricks bricks)
	{
		if (null == previous)
		{
			start();
		}
	}

	public void restart()
	{
		previous = null;
	}
	
	private void start()
	{
		
	}
}
