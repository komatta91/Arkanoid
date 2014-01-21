package arkaoid.model;

import java.awt.Point;

/**
 * klasa reprezentuj¹ca klocki niezniszczalne
 * @author Karol
 *
 */
public class IndestructibleBrock extends Brick
{

	public IndestructibleBrock(Point point)
	{
		super(point);
	}

	public IndestructibleBrock(int x, int y)
	{
		super(x, y);
	}

	/**
	 * metoda reaguj¹ca na uderzenie
	 * poniewa¿ klocek jest niezniszczalny nigdy nie bêdzie 
	 * martwy metoda zawsze wraca prawda
	 */
	public boolean hit()
	{
		return true;
	}

	/**
	 * metoda zwracaj¹ca iloœæ ¿yæ klocka
	 * poniewa¿ klocek jest niezniszczalny
	 * zwraca watroœæ -1 która nie mo¿e wyst¹piæ 
	 * w przypadku klocków zniszczalnych.
	 */
	@Override
	public int getLife()
	{
		return -1;
	}

	/**
	 * metoda testuj¹ca czy klocek jest zniszczalny
	 * zawsze zwraca false.
	 */
	@Override
	public boolean isDestructible()
	{
		return false;
	}

}
