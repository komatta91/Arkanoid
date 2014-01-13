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
			//System.out.println(l);
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
		int inLine = ArkanoidStatic.GAME_PANEL_DIMENSION.width / ArkanoidStatic.BRICK_DIMENSION.width;
		int lines = 10;
		for (int j = 0; j < lines; ++j)
		{
			for (int i = 0; i < inLine; ++i)
			{
				points.put((long)count, new Point(x,y));
				x += dx;
				++count;
			}
			x = 0;
			y+= dy;
		}
		this.count = points.size();
		//System.out.println(points.size());
	}

	private Brick makeBrick(long i)
	{
		int life = 1;
		for (int j = 0; j < 2; ++j)
		{
			if (Math.random() > 0.5)
			{
				++life;
			}
		}
		Point p = points.get(i++);
		while (p == null) 
		{
			p = points.get(i++);
			if (i > this.count) i = 0;
		}
		//System.out.println("Numer Klocka: " + i);
		points.remove(--i);
		if (Math.random() > 0.9)
		{
			return new IndestructibleBrock(p);
		} else
		{
			return new DestructibleBrick(life, p);
		}
		// return null;
	}

}
