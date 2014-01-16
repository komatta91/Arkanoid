package arkaoid.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.NoBricksException;

public class Bricks
{
	private List<Brick> bricks;
	private BrickMaker maker = new BrickMaker();
	private int score;

	public void hit(Point point, int radius) throws NoBricksException
	{
		for (Brick b : bricks)
		{
			if (checkBrick(point, radius, b))
			{
				break;
			}
		}
		if (areAvive())
		{
			throw new NoBricksException("Wygra³eœ!!\nTwój wynik to: "
					+ getScore());
		}
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

	public void make() throws NoBricksException
	{
		int a = ArkanoidStatic.BRICK_NUMBER;
		a += Math.random() * ArkanoidStatic.BRICK_NUMBER;
		bricks = maker.make(a);
		if (areAvive())
		{
			throw new NoBricksException("Wygra³eœ!!\nTwój wynik to: "
					+ getScore());
		}
	}

	public List<BrickMod> getBricks()
	{
		List<BrickMod> list = new LinkedList<BrickMod>();
		for (Brick e : bricks)
		{
			list.add(new BrickMod(e.getLife(), e.getPoint()));
		}
		return list;
	}

	public int getScore()
	{
		return score;
	}

	public void resetScore()
	{
		this.score = 0;
	}

	private boolean areAvive()
	{
		int count = 0;
		for (Brick b : bricks)
		{
			if (b.getLife() >= 0)
			{
				++count;
			}
		}
		return 0 == count;
	}

	private boolean checkBrick(Point point, int radius, Brick b)
	{
		if (b.isHit(point, radius))
		{
			setScore(getScore() + b.getLife() * 10);
			if (!b.hit())
			{
				bricks.remove(b);
				return true;
			}
		}
		return false;
	}

	private void setScore(int score)
	{
		this.score = score;
	}
}
