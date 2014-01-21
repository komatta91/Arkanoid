package arkaoid.model;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.NoBricksException;

/**
 * Klasa reprezentuj�ca klocki w grze.
 * @author Karol
 *
 */
public class Bricks
{
	/**
	 * lista klock�w
	 */
	private List<Brick> bricks;
	/**
	 * klasa do tworzenia klock�w
	 */
	private BrickMaker maker = new BrickMaker();
	/**
	 * wynik uzyskany przez gracza.
	 */
	private int score;

	/**
	 * metoda kt�ra reaguje na zderzenie z okr�giem je�li takie nast�puje.
	 * @param point �rodek okr�gu
	 * @param radius promie�
	 * @throws NoBricksException wyj�tek rzucany w wpadku zbicia wszystkich klock�w.
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
			throw new NoBricksException("Wygra�e�!!\nTw�j wynik to: "
					+ getScore());
		}
	}

	/**
	 * metoda kt�ra testuje zderzenie z okr�giem
	 * @param point �rodek okr�gu
	 * @param radius promie�
	 * @return czy wyst�pi�o zderzenie.
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
	 * metoda tworz�ca now� kolekcj� klock�w.
	 * @throws NoBricksException je�li wylosowano same klocki niezniszczalne
	 * lub nie uda�o si� utworzy� kolekcji klock�w.
	 */
	public void make() throws NoBricksException
	{
		int a = ArkanoidStatic.BRICK_NUMBER;
		a += Math.random() * ArkanoidStatic.BRICK_NUMBER;
		bricks = maker.make(a);
		if (areAvive())
		{
			throw new NoBricksException("Pzepraszamy nastapi� prze�ciowy problem.");
		}
	}

	/**
	 * zwraca makiet� klock�w.
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
	 * metoda zliczaj�ca ile klock�w pozostaje jeszcze do  zbicia.
	 * @return ilo�� klock�w do zbicia
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
	 * metoda sprawdzaj�ca czy nast�pi�o zderzenie ko�a z  klockiem
	 * je�li tak to dodaje odpowiedni� ilo�� punkt�w i je�li klocek umiera 
	 * usuwa go z kolekcji �ywych.
	 * @param point �rodek ko�a
	 * @param radius promie�
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
