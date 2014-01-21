package arkaoid.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import arkaoid.ArkanoidStatic;

/**
 * Klasa odpowiedzialan za tworzenie klocków.
 * @author Karol
 *
 */
public class BrickMaker
{
	/**
	 * mapa punktów w których mog¹ byæ zaczepione klocki.
	 */
	Map<Long, Point> points = new TreeMap<Long, Point>();
	/**
	 * liczba mo¿liwych do utworzenie klocków
	 */
	int count;

	/**
	 * metoda tworz¹ca listê klocków.
	 * @param n liczba klocków mo¿liwych do utworzenia.
	 * @return lista utworzonych klocków.
	 */
	public List<Brick> make(int n)
	{
		makePoints();
		List<Brick> bricks = new LinkedList<Brick>();

		for (int i = 0; i < n; ++i)
		{
			long l = Math.round((Math.random() * points.size()));
			bricks.add(makeBrick(l));
		}
		return bricks;
	}

	/**
	 * klasa tworz¹ca mapê punktów w których mog¹ byæ utworzone 
	 * klocki na podstawie wielkoœci klocków i ramki gry.
	 */
	private void makePoints()
	{
		int count = 1;
		int x = 0;
		int y = 20;
		int dx = ArkanoidStatic.BRICK_DIMENSION.width;
		int dy = ArkanoidStatic.BRICK_DIMENSION.height;
		int inLine = ArkanoidStatic.GAME_PANEL_DIMENSION.width
				/ ArkanoidStatic.BRICK_DIMENSION.width;
		int lines = 10;
		for (int j = 0; j < lines; ++j)
		{
			for (int i = 0; i < inLine; ++i)
			{
				points.put((long) count, new Point(x, y));
				x += dx;
				++count;
			}
			x = 0;
			y += dy;
		}
		this.count = points.size();
	}

	/**
	 * metoda tworz¹ca klocek i dodaj¹ca go do kolekcji.
	 * @param i indeks punktu w mapie w którym ma byæ zaczepiony klocek o ile jest to mo¿liwe.
	 * 
	 * @return klocek zniszczalny lub niezniszczalny.
	 */
	private Brick makeBrick(long i)
	{
		if (ArkanoidStatic.ARE_INDESTRUCTIBLE && Math.random() > 0.9)
		{
			return new IndestructibleBrock(getPoint(i));
		} else
		{
			return new DestructibleBrick(getLife(), getPoint(i));
		}
	}
	
	/**
	 * petoda zwracaj¹ca punkt z mapy dostêpnych lub jeœli to niemo¿liwe wyszukuje kolejny
	 * wolny punkt usuwa fo z poœród dostêpnych i zwraca go.
	 * @param i indeks punktu do pobrania o ile jest to mo¿liwe.
	 * @return punkt dostêpny w mapie.
	 */
	private Point getPoint(long i)
	{
		Point p = points.get(i++);
		while (p == null)
		{
			p = points.get(i++);
			if (i > this.count)
			{
				i = 0;
			}
		}
		points.remove(--i);
		return p;
	}
	
	/**
	 * metoda losuj¹ca iloœæ ¿yæ klocka.
	 * @return
	 */
	private int getLife()
	{
		int life = 1;
		for (int j = 0; j < 2; ++j)
		{
			if (Math.random() > 0.5)
			{
				++life;
			}
		}
		return life;
	}
}
