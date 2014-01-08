package arkaoid.model;

import java.awt.Point;

public class DestructibleBrick extends Brick
{
	private int life;
	public DestructibleBrick(int life, Point point)
	{
		super(point);
		this.life = life;
	}
	
	public DestructibleBrick(int life, int x, int y)
	{
		super(new Point(x, y));
		this.life = life;
	}
	
	public boolean hit()
	{
		--this.life;
		if (life  > 0)
		{
			return true;
		} else 
		{
			return false;
		}
	}

	@Override
	public int getLife()
	{
		// TODO Auto-generated method stub
		return life;
	}
	
	
}
