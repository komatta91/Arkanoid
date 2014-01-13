package arkaoid.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import arkaoid.ArkanoidStatic;

public class Bricks
{
	List<Brick> bricks;
	BrickMaker maker = new BrickMaker();
	private int score;

	public void hit(Point point, int radius) throws NoBricksException
	{
		for (Brick b : bricks)
		{
			if (b.isHit(point, radius))
			{
				boolean find = false;
				b.decreasLife();
				switch (b.getLife())
				{
				case 2:
					setScore(getScore() + 30);
					break;
				case 1:
					setScore(getScore() + 20);
					break;
				case 0:
					setScore(getScore() + 10);
					bricks.remove(b);
					find = true;
					break;
				}
				if (find)
				{
					break;
				}
				// default: setScore(getScore() + 00); break;

				/*
				 * if (b.getLife() == 2) { setScore(getScore() + 30); } else if
				 * (b.getLife() == 1) { setScore(getScore() + 20); } else if
				 * (b.getLife() == 0) { setScore(getScore() + 10);
				 * bricks.remove(b); break; }
				 */
				// return true;
			}
		}
		int count = 0;
		for (Brick b : bricks)
		{
			if (b.getLife() >= 0)
			{
				++count;
			}
		}
		// System.out.println("NoBrickException");
		// System.out.println(count);
		if (0 == count)
		{
			// System.out.println("NoBrickException");
			throw new NoBricksException();
		}
		// return false;
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
		int a = ArkanoidStatic.BRICK_NUMBER;
		a += Math.random() * ArkanoidStatic.BRICK_NUMBER;
		bricks = maker.make(a);
	}

	/*
	 * public int count() { return bricks.size(); }
	 */

	/*
	 * public void print() {
	 * 
	 * 
	 * for (Brick e : bricks) { //System.out.println(e);
	 * e.print();//e.toString(); }
	 * 
	 * System.out.println(bricks.size()); }
	 */

	public List<BrickMod> getBricks()
	{
		List<BrickMod> list = new LinkedList<BrickMod>();
		for (Brick e : bricks)
		{
			// System.out.println(e);
			list.add(new BrickMod(e.getLife(), e.getPoint()));
		}
		return list;
	}

	public int getScore()
	{
		return score;
	}

	private void setScore(int score)
	{
		this.score = score;
	}
	
	public void resetScore()
	{
		this.score = 0;
	}
}
