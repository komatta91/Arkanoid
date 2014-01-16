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
		return (decreasLife() > 0);
	}

	@Override
	public int getLife()
	{
		return life;
	}

	private int decreasLife()
	{
		return --this.life;

	}

	@Override
	public boolean isDestructible()
	{
		return true;
	}

}
