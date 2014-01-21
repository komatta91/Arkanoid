package arkaoid.model;

import java.awt.Point;

/**
 * klasa reprezêtuj¹ca zniszczalen klocki.
 * @author Karol
 *
 */
public class DestructibleBrick extends Brick
{
	/**
	 * iloœæ ¿yæ klocka klocek pozostaje ¿ywy 
	 * jeœli jego liczba ¿yæ jest wiêksza od zera.
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
	 * metoda odejmuje jedno ¿ycie klocka i zwraca czy klocek jest
	 * ci¹gle ¿ywy.
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
	 * odejmuje jedno ¿ycie z puli
	 * i zwraca iloœæ pozosta³ych.
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
