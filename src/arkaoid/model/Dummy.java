package arkaoid.model;

import java.awt.Point;
import java.util.List;

public class Dummy
{
	private boolean menu = false;
	private boolean exit = false;
	private boolean timer = false;
	private boolean game = false;
	private Point palette = null;
	private Point ball = null;
	private List<BrickMod> points;

	public boolean isMenu()
	{
		return menu;
	}

	public void setMenu(boolean menu)
	{
		this.menu = menu;
	}

	public boolean isExit()
	{
		return exit;
	}

	public void setExit(boolean exit)
	{
		this.exit = exit;
	}

	public boolean isTimer()
	{
		return timer;
	}

	public void setTimer(boolean timer)
	{
		this.timer = timer;
	}

	public boolean isGame()
	{
		return game;
	}

	public void setGame(boolean game)
	{
		this.game = game;
	}

	public Point getPalette()
	{
		return palette;
	}

	public void setPalette(Point palette)
	{
		this.palette = palette;
	}

	public Point getBall()
	{
		return ball;
	}

	public void setBall(Point ball)
	{
		this.ball = ball;
	}

	public List<BrickMod> getPoints()
	{
		return points;
	}

	public void setPoints(List<BrickMod> list)
	{
		this.points = list;
	}

}
