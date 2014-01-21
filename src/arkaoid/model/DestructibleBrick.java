package arkaoid.model;

import java.awt.Point;

/**
 * klasa reprez�tuj�ca zniszczalen klocki.
 * @author Karol
 *
 */
public class DestructibleBrick extends Brick
{
	/**
	 * ilo�� �y� klocka klocek pozostaje �ywy 
	 * je�li jego liczba �y� jest wi�ksza od zera.
	 */
	private int life;

	public DestructibleBrick(int life, Point point)
	{
		super(point);
		this.life = life;
	}

	public DestructibleBrick(int life, int x, int y)
	{
		super(new Point(x, y));
		this.life = life;
	}
 
	/**
	 * metoda odejmuje jedno �ycie klocka i zwraca czy klocek jest
	 * ci�gle �ywy.
	 * @return
	 */
	public boolean hit()
	{
		return (decreasLife() > 0);
	}

	@Override
	public int getLife()
	{
		return life;
	}

	/**
	 * odejmuje jedno �ycie z puli
	 * i zwraca ilo�� pozosta�ych.
	 * @return
	 */
	private int decreasLife()
	{
		return --this.life;

	}

	/**
	 * czy klocek jest zniszczalny
	 * zawsze zwraca prawda.
	 */
	@Override
	public boolean isDestructible()
	{
		return true;
	}

}
