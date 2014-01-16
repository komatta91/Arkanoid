package arkaoid.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import arkaoid.ArkanoidStatic;

public class BrickMaker
{
	Map<Long, Point> points = new TreeMap<Long, Point>();
	int count;

	public List<Brick> make(int n)
	{
		makePoints();
		List<Brick> bricks = new LinkedList<Brick>();

		for (int i = 0; i < n; ++i)
		{
			long l = Math.round((Math.random() * points.size()));
			bricks.add(makeBrick(l));
		}
		return bricks;
	}

	private void makePoints()
	{
		int count = 1;
		int x = 0;
		int y = 20;
		int dx = ArkanoidStatic.BRICK_DIMENSION.width;
		int dy = ArkanoidStatic.BRICK_DIMENSION.height;
		int inLine = ArkanoidStatic.GAME_PANEL_DIMENSION.width
				/ ArkanoidStatic.BRICK_DIMENSION.width;
		int lines = 10;
		for (int j = 0; j < lines; ++j)
		{
			for (int i = 0; i < inLine; ++i)
			{
				points.put((long) count, new Point(x, y));
				x += dx;
				++count;
			}
			x = 0;
			y += dy;
		}
		this.count = points.size();
	}

	private Brick makeBrick(long i)
	{
		if (ArkanoidStatic.ARE_INDESTRUCTIBLE && Math.random() > 0.9)
		{
			return new IndestructibleBrock(getPoint(i));
		} else
		{
			return new DestructibleBrick(getLife(), getPoint(i));
		}
	}

	private Point getPoint(long i)
	{
		Point p = points.get(i++);
		while (p == null)
		{
			p = points.get(i++);
			if (i > this.count)
			{
				i = 0;
			}
		}
		points.remove(--i);
		return p;
	}

	private int getLife()
	{
		int life = 1;
		for (int j = 0; j < 2; ++j)
		{
			if (Math.random() > 0.5)
			{
				++life;
			}
		}
		return life;
	}
}
