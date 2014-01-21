package arkaoid.model;

import java.awt.Point;

/**
 * klasa reprezentuj�ca klocki niezniszczalne
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
	 * metoda reaguj�ca na uderzenie
	 * poniewa� klocek jest niezniszczalny nigdy nie b�dzie 
	 * martwy metoda zawsze wraca prawda
	 */
	public boolean hit()
	{
		return true;
	}

	/**
	 * metoda zwracaj�ca ilo�� �y� klocka
	 * poniewa� klocek jest niezniszczalny
	 * zwraca watro�� -1 kt�ra nie mo�e wyst�pi� 
	 * w przypadku klock�w zniszczalnych.
	 */
	@Override
	public int getLife()
	{
		return -1;
	}

	/**
	 * metoda testuj�ca czy klocek jest zniszczalny
	 * zawsze zwraca false.
	 */
	@Override
	public boolean isDestructible()
	{
		return false;
	}

}
