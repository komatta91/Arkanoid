package arkaoid.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

public class Bricks
{
	List<Brick> bricks;
	BrickMaker maker = new BrickMaker();

	public Bricks()
	{
		// int a = 40;
		// a+= Math.random()*40;
		// bricks = maker.make(0);
	}

	public boolean isHit(Point point, int radius)
	{

		for (Brick b : bricks)
		{
			if (b.isHit(point, radius))
			{
				return true;
			}
		}
		return false;
	}

	public void make()
	{
		int a = 40;
		a += Math.random() * 60;
		bricks = maker.make(a);
	}

	public int count()
	{
		return bricks.size();
	}

	public void print()
	{

		/*
		 * for (Brick e : bricks) { //System.out.println(e);
		 * e.print();//e.toString(); }
		 */
		System.out.println(bricks.size());
	}

	public List<BrickMod> getBricks()
	{
		List<BrickMod> list = new LinkedList<BrickMod>();
		for (Brick e : bricks)
		{
			//System.out.println(e);
			list.add(new BrickMod(e.getLife(), e.getPoint()));
		}
		return list;
	}
}
