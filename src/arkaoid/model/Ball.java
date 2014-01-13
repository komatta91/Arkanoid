package arkaoid.model;

import java.awt.Point;

import arkaoid.ArkanoidStatic;

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
		// /TODO Przenieœæ do klasy zajmuj¹cej siê fizyk¹
		double random = Math.random();
//		random *= 357;
//		random %= 7;
//		// if (Math.random() > 0.5) random = -random;
//
//		// System.out.println((int)-random);
//		dy = (int) -random;
//		random = Math.round(Math.sqrt(36 - random * random));
//		// random = random - (random % 1);
//		if (Math.random() > 0.5)
//			random = -random;
//		dx = (int) random;
//		if (dx == 0 || dy == 0)
//			reRandom();
		// /Test
		int n = 0;
		if (random < 0.16)
		{
			dy = -1;
			dx = (int) Math.round(Math.sqrt(36 - 1));
			if (Math.random() > 0.5) dx = -dx;
			
		} else
		if (random < 0.32)
		{
			dy = -2;
			dx = (int) Math.round(Math.sqrt(36 - 4));
			if (Math.random() > 0.5) dx = -dx;
		} else
		if (random < 0.48)
		{
			dy = -3;
			dx = (int) Math.round(Math.sqrt(36 - 9));
			if (Math.random() > 0.5) dx = -dx;
		} else
		if (random < 0.64)
		{
			dy = -4;
			dx = (int) Math.round(Math.sqrt(36 - 16));
			if (Math.random() > 0.5) dx = -dx;
		} else
		if (random < 0.80)
		{
			dy = -5;
			dx = (int) Math.round(Math.sqrt(36 - 25));
			if (Math.random() > 0.5) dx = -dx;
		} else
		{
			dy = -6;
			dx = 0;
			//if (Math.random() > 0.5) dx = -dx;
		}
		//System.out.println("dx = "+dx + ", dy = " + dy);
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
		/*if (isMoving)
		{
			// TODO Jeœli siê porusza
			if (!(this.center.x + dx > 0 && this.center.x < ArkanoidStatic.GAME_PANEL_DIMENSION.height))
			{
				//this.dx = -this.dx;
			}

			//this.center.x += dx;
			// System.out.println("move");

		} else*/
		{
			// Point newPoint = new Point(p.x-radius, p.y-radius);
			center.setLocation(p.x - radius / 2, p.y - (ArkanoidStatic.PALETTE_DIMENSION.height + 1));
			// System.out.println("dont move");
		}
	}

	public void move() throws FailException
	{
		if (!(this.center.x + dx > 0 && this.center.x < ArkanoidStatic.GAME_PANEL_DIMENSION.width - radius))
		{
			this.dx = -this.dx;
		}

		if (!(this.center.y + dy > 0 && this.center.y < ArkanoidStatic.GAME_PANEL_DIMENSION.height - radius))
		{
			if (this.center.y > ArkanoidStatic.GAME_PANEL_DIMENSION.height - radius -10)
			{
				throw new FailException();
			}
			this.dy = -this.dy;
			
		}

		// System.out.println("from move");
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
		Point p = new Point(center.x, center.y-dy);
		if (!bricks.isHit(p, radius))
		{
			this.dy = -this.dy;
			return;
		}
		p = new Point(center.x-dx, center.y);
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
//		Point p = new Point(center.x, center.y-dy);
//		if (!palette.isHit(p, radius))
//		{
//			this.dy = -this.dy;
//			return;
//		}
		
		///Opcja Druga
		/*int lenght = ArkanoidStatic.PALETTE_DIMENSION.width / 12;
		palette.getPalette();
		if (palette.getPalette().x < this.center.x)
		{
			int len = this.center.x - palette.getPalette().x;
			//System.out.println(len);
			for (int i = 1; i < 7; ++i)
			{
				if (i*lenght > len ) 
				{
					setDx(i-1);
					break;
				}
			}
		} else
		{
			int len = palette.getPalette().x - this.center.x;
			//System.out.println(len);
			for (int i = 1; i < 7; ++i)
			{
				if (i*lenght > len )
				{
					setDx(-(i-1));
					break;
				}
			}
		}*/
		int newDx =  this.center.x-palette.getPalette().x ;
		int lenght = ArkanoidStatic.PALETTE_DIMENSION.width / 12;
		
		int tmp = newDx/lenght + 1;
		//System.out.println(tmp);
		if (tmp > 6) tmp = 6;
		if (tmp < -6) tmp = -6;
		setDx(tmp);
	}
	private void setDx(int dx)
	{
		this.dx = dx;
		dy = (int) Math.round(Math.sqrt(36 - dx));
		if (dy > 0) dy = - dy;
	}
}
