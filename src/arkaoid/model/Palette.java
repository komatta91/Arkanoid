package arkaoid.model;

import java.awt.Point;

import arkaoid.ArkanoidStatic;

public class Palette
{
	private Point point = new Point(0,
			(int) (ArkanoidStatic.GAME_PANEL_DIMENSION.getHeight() - ArkanoidStatic.PALETTE_DIMENSION.getHeight() - 10));

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
}
