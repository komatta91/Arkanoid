package arkaoid.model;

import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import arkaoid.ArkanoidStatic;

public class Palette
{
	private Point point = new Point(
			ArkanoidStatic.GAME_PANEL_DIMENSION.width / 2,
			(int) (ArkanoidStatic.GAME_PANEL_DIMENSION.getHeight()
					- ArkanoidStatic.PALETTE_DIMENSION.getHeight() - 10));

	public Point getPalette()
	{
		return (Point) point.clone();
	}

	public void setPoint(Point newPoint)
	{
		int ods = (int) ArkanoidStatic.PALETTE_DIMENSION.getWidth() / 2;
		if (newPoint.x < ods)
		{
			this.point = new Point(ods, this.point.y);
			return;
		}
		int tmp = (int) (ArkanoidStatic.GAME_PANEL_DIMENSION.getWidth() - ods);
		if (newPoint.x > tmp)
		{
			this.point = new Point(tmp, this.point.y);
			return;
		}
		this.point = new Point(newPoint.x, point.y);

	}

	public boolean isHit(Point point, int radius)
	{
		Rectangle2D palette = new Rectangle2D.Double();
		int x = this.point.x - ArkanoidStatic.PALETTE_DIMENSION.width / 2;
		int y = this.point.y;
		palette.setFrame(new Point(x, y), ArkanoidStatic.PALETTE_DIMENSION);
		Ellipse2D ball = new Ellipse2D.Double();
		ball.setFrame(point.x, point.y, radius, radius);
		Area area = new Area(ball);
		return area.intersects(palette);
	}

	public void move(int dx)
	{
		point.x -= dx;
		if (point.x < ArkanoidStatic.PALETTE_DIMENSION.width / 2)
		{
			point.x = ArkanoidStatic.PALETTE_DIMENSION.width / 2;
		}
		if (point.x > ArkanoidStatic.GAME_PANEL_DIMENSION.width
				- ArkanoidStatic.PALETTE_DIMENSION.width / 2)
		{
			point.x = ArkanoidStatic.GAME_PANEL_DIMENSION.width
					- ArkanoidStatic.PALETTE_DIMENSION.width / 2;
		}
	}
}
