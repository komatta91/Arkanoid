package arkaoid.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.NoBricksException;

/**
 * Klasa reprezentuj¹ca klocki w grze.
 * @author Karol
 *
 */
public class Bricks
{
	/**
	 * lista klocków
	 */
	private List<Brick> bricks;
	/**
	 * klasa do tworzenia klocków
	 */
	private BrickMaker maker = new BrickMaker();
	/**
	 * wynik uzyskany przez gracza.
	 */
	private int score;

	/**
	 * metoda która reaguje na zderzenie z okrêgiem jeœli takie nastêpuje.
	 * @param point œrodek okrêgu
	 * @param radius promieñ
	 * @throws NoBricksException wyj¹tek rzucany w wpadku zbicia wszystkich klocków.
	 */
	public void hit(Point point, int radius) throws NoBricksException
	{
		for (Brick b : bricks)
		{
			if (checkBrick(point, radius, b))
			{
				break;
			}
		}
		if (areAvive())
		{
			throw new NoBricksException("Wygra³eœ!!\nTwój wynik to: "
					+ getScore());
		}
	}

	/**
	 * metoda która testuje zderzenie z okrêgiem
	 * @param point œrodek okrêgu
	 * @param radius promieñ
	 * @return czy wyst¹pi³o zderzenie.
	 */
	public boolean isHit(Point point, int radius)
	{
		for (Brick b : bricks)
		{
			if (b.isHit(point, radius))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * metoda tworz¹ca now¹ kolekcjê klocków.
	 * @throws NoBricksException jeœli wylosowano same klocki niezniszczalne
	 * lub nie uda³o siê utworzyæ kolekcji klocków.
	 */
	public void make() throws NoBricksException
	{
		int a = ArkanoidStatic.BRICK_NUMBER;
		a += Math.random() * ArkanoidStatic.BRICK_NUMBER;
		bricks = maker.make(a);
		if (areAvive())
		{
			throw new NoBricksException("Pzepraszamy nastapi³ przeœciowy problem.");
		}
	}

	/**
	 * zwraca makietê klocków.
	 * @return
	 */
	public List<BrickMod> getBricks()
	{
		List<BrickMod> list = new LinkedList<BrickMod>();
		for (Brick e : bricks)
		{
			list.add(new BrickMod(e.getLife(), e.getPoint()));
		}
		return list;
	}

	public int getScore()
	{
		return score;
	}

	public void resetScore()
	{
		this.score = 0;
	}

	/**
	 * metoda zliczaj¹ca ile klocków pozostaje jeszcze do  zbicia.
	 * @return iloœæ klocków do zbicia
	 */
	private boolean areAvive()
	{
		int count = 0;
		for (Brick b : bricks)
		{
			if (b.getLife() >= 0)
			{
				++count;
			}
		}
		return 0 == count;
	}

	/**
	 * metoda sprawdzaj¹ca czy nast¹pi³o zderzenie ko³a z  klockiem
	 * jeœli tak to dodaje odpowiedni¹ iloœæ punktów i jeœli klocek umiera 
	 * usuwa go z kolekcji ¿ywych.
	 * @param point œrodek ko³a
	 * @param radius promieñ
	 * @param b klocek
	 * @return
	 */
	private boolean checkBrick(Point point, int radius, Brick b)
	{
		if (b.isHit(point, radius))
		{
			setScore(getScore() + b.getLife() * 10);
			if (!b.hit())
			{
				bricks.remove(b);
				return true;
			}
		}
		return false;
	}

	private void setScore(int score)
	{
		this.score = score;
	}
}
