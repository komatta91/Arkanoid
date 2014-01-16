package arkaoid.model;

import java.awt.Point;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.FailException;

public class Ball
{
	private Point center = new Point();
	private int radius = ArkanoidStatic.BALL_RADIUS;
	private boolean isMoving = false;
	private int dy = 0;
	private int dx = 0;

	public boolean isMoving()
	{
		return isMoving;
	}

	public void reRandom()
	{
		double random = Math.random();
		for (int i = 1; i < 7; ++i)
		{
			System.out.println(i);
			if (random < i * 0.17)
			{
				setDy(-i);
				break;
			}
		}

	}

	private void setDy(int dy)
	{
		this.dy = dy;
		dx = (int) Math.round(Math.sqrt(36 - (dy * dy)));
		if (Math.random() > 0.5)
			dx = -dx;
	}

	public void startMoving()
	{
		isMoving = true;
	}

	public void stopMoving()
	{
		isMoving = false;
	}

	public void setPoint(Point p)
	{
		center.setLocation(p.x - radius / 2, p.y
				- (ArkanoidStatic.PALETTE_DIMENSION.height + 1));

	}

	public void move() throws FailException
	{
		if (!(this.center.x + dx > 0 && this.center.x < ArkanoidStatic.GAME_PANEL_DIMENSION.width
				- radius))
		{
			this.dx = -this.dx;
		}
		if (!(this.center.y + dy > 0 && this.center.y < ArkanoidStatic.GAME_PANEL_DIMENSION.height
				- radius))
		{
			if (this.center.y > ArkanoidStatic.GAME_PANEL_DIMENSION.height
					- radius - 10)
			{
				throw new FailException();
			}
			this.dy = -this.dy;
		}
		if (isMoving)
		{
			this.center.x += dx;
			this.center.y += dy;
		}
	}

	public Point getPoint()
	{
		return (Point) center.clone();
	}

	public void bounce(Bricks bricks)
	{
		Point p = new Point(center.x, center.y - dy);
		if (!bricks.isHit(p, radius))
		{
			this.dy = -this.dy;
			return;
		}
		p = new Point(center.x - dx, center.y);
		if (!bricks.isHit(p, radius))
		{
			this.dx = -this.dx;
			return;
		}
		dx = -dx;
		dy = -dy;
	}

	public void bounce(Palette palette)
	{
		int newDx = this.center.x - palette.getPalette().x;
		int lenght = ArkanoidStatic.PALETTE_DIMENSION.width / 12;
		int tmp = newDx / lenght + 1;
		if (tmp > 6)
		{
			tmp = 6;
		}
		if (tmp < -6)
		{
			tmp = -6;
		}
		setDx(tmp);
	}

	private void setDx(int dx)
	{
		this.dx = dx;
		dy = (int) Math.round(Math.sqrt(36 - dx));
		if (dy > 0)
		{
			dy = -dy;
		}
	}
}
