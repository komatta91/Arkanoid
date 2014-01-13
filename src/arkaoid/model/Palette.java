package arkaoid.model;

import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import arkaoid.ArkanoidStatic;

public class Palette
{
	private Point point = new Point(ArkanoidStatic.GAME_PANEL_DIMENSION.width / 2,
			(int) (ArkanoidStatic.GAME_PANEL_DIMENSION.getHeight() - ArkanoidStatic.PALETTE_DIMENSION.getHeight() - 10));
	private final int dx = 10;
	public Point getPalette()
	{
		return (Point) point.clone();
	}

	public void setPoint(Point newPoint)
	{
		int ods = (int) ArkanoidStatic.PALETTE_DIMENSION.getWidth() / 2;
		if (newPoint.x < ods)
		{
			this.point = new Point(ods,this.point.y);
			return;
		}
		int tmp = (int) (ArkanoidStatic.GAME_PANEL_DIMENSION.getWidth() - ods);
		if (newPoint.x > tmp)
		{
			this.point = new Point(tmp, this.point.y);
			return;
		}
		this.point = new Point(newPoint.x, point.y);
		//System.out.println(point);
		
	}
	
	public boolean isHit(Point point, int radius)
	{
		Rectangle2D palette = new Rectangle2D.Double();
		int x = this.point.x - ArkanoidStatic.PALETTE_DIMENSION.width / 2;
		int y = this.point.y;
		palette.setFrame(new Point(x,y), ArkanoidStatic.PALETTE_DIMENSION);
		//Rectangle2D brick = new Rectangle2D.Double(this.point.x, this.point.y, width, height);
		
		Ellipse2D ball = new Ellipse2D.Double();
		ball.setFrame(point.x, point.y, radius, radius);
		Area area = new Area(ball);
		return area.intersects(palette);
		//Rectangle2D brick = new Rectangle2D.Double(this.point.x, this.point.y, width, height);
		//Area area = new Area(ball);
		//if (area.intersects(brick)) System.out.println("x = " + this.point.x + ", y =" + this.point.y);
		//return area.intersects(brick);
	}

	public void moveLeft()
	{
		// TODO Auto-generated method stub
		point.x -= dx;
	}

	public void moveRight()
	{
		// TODO Auto-generated method stub
		point.x += dx;
	}

	public void move(int dx)
	{
		// TODO Auto-generated method stub
		point.x -= dx;
		if (point.x < ArkanoidStatic.PALETTE_DIMENSION.width/2)
		{
			point.x = ArkanoidStatic.PALETTE_DIMENSION.width/2;
		}
		if (point.x > ArkanoidStatic.GAME_PANEL_DIMENSION.width - ArkanoidStatic.PALETTE_DIMENSION.width/2)
		{
			point.x = ArkanoidStatic.GAME_PANEL_DIMENSION.width - ArkanoidStatic.PALETTE_DIMENSION.width/2;
		}
	}
}
