package arkaoid.model;

import java.awt.Point;

/**
 * Klaca reprezentuj�ca makiet� klocka.
 * @author Karol
 *
 */
public class BrickMod
{
	/**
	 * ilo�� �y� klocka
	 */
	private int life;
	/**
	 * punkt w kt�rym zaczepiony jest klocek.
	 */
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
		return (Point) point.clone();
	}

	public void setPoint(Point point)
	{
		this.point = point;
	}
}
