package arkaoid.model;

import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import arkaoid.ArkanoidStatic;

/**
 * klasa reprezentuj�ca paletk�.
 * @author Karol
 *
 */
public class Palette
{
	/**
	 * punkt �rodkowy g�rnej kraw�dzi paletki.
	 */
	private Point point = new Point(
			ArkanoidStatic.GAME_PANEL_DIMENSION.width / 2,
			(int) (ArkanoidStatic.GAME_PANEL_DIMENSION.getHeight()
					- ArkanoidStatic.PALETTE_DIMENSION.getHeight() - 10));

	public Point getPalette()
	{
		return (Point) point.clone();
	}

	/**
	 * Metoda ustawiaj�ca nowy punkt �rodkowy paletki o ile
	 * poletka nie wypad�aby poza ramk�.
	 * @param newPoint nowy punkt �rodkowy paletki do test�w.
	 */
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

	/**
	 * metoda testuj�ca czy nast�pi�o zderzenie z ko�em
	 * @param point �rodek ko�a
	 * @param radius promie�
	 * @return czy jest zderzenie
	 */
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

	/**
	 * metoda poruszaj�ca paletk� w p�aszczy�nie poziomej
	 * o ile nie wypadnie poza ramk�;
	 * @param dx przemieszczenie
	 */
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
