package arkaoid.model;

import java.awt.Point;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import arkaoid.ArkanoidStatic;

/**
 * Abstrakcyjna klasa bazowa do hierarchii reprez�tuj�cej kloceki.
 * @author Karol
 *
 */
public abstract class Brick
{
	/**
	 * Punkt prawego g�rnego rogu
	 */
	private Point point;
	/**
	 * wysoko��
	 */
	private int height = ArkanoidStatic.BRICK_DIMENSION.height;
	/**
	 * d�ugo��
	 */
	private int width = ArkanoidStatic.BRICK_DIMENSION.width;

	/**
	 * metoda abstrakcyjna wywo�ywana w wypadku zderzenie. Inne zachowanei dla r�nych klock�w.
	 * @return czy lkocek po zderzeniu jest je�cze �ywy.
	 */
	abstract public boolean hit();

	/**
	 * liczba pozosta�ych �y�.
	 * @return
	 */
	public abstract int getLife();
	
	/**
	 * test czy klocek jest zniszczalny.
	 * @return
	 */
	public abstract boolean isDestructible();

	public Brick(Point point)
	{
		this.point = point;
	}

	public Brick(int x, int y)
	{
		this.point = new Point(x, y);
	}
	
	/**
	 * Metoda wykrywaj�ca zderzenei w okr�giem.
	 * @param point �rodek testowanego okr�gu
	 * @param radius promie� testowanego okr�gu
	 * @return czy nast�pi�o zderzenie
	 */
	public boolean isHit(Point point, int radius)
	{
		Ellipse2D ball = new Ellipse2D.Double();
		ball.setFrame(point.x, point.y, radius, radius);
		Rectangle2D brick = new Rectangle2D.Double(this.point.x, this.point.y,
				width, height);
		Area area = new Area(ball);
		return area.intersects(brick);
	}

	public Point getPoint()
	{
		return (Point) this.point.clone();
	}
}