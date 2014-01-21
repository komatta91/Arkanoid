package arkaoid.model;

import java.awt.Point;
import java.util.List;

/**
 * klasa reprez�tuj�ca makiet� modelu.
 * @author Karol
 *
 */
public class Dummy
{
	/**
	 * czy ma by� pokazane menu
	 */
	private boolean menu = false;
	/**
	 * czy ma by� pokazane zapytanie o zamkni�cie.
	 */
	private boolean exit = false;
	/**
	 * czy zegar ma by� w��czony
	 */
	private boolean timer = false;
	/**
	 * czy ma by� pokazane okno gry
	 */
	private boolean game = false;
	/**
	 * punkt ppeprezentuj�cy paletk�
	 */
	private Point palette = null;
	/**
	 * punkt reprezentuj�cy pi�k�
	 */
	private Point ball = null;
	/**
	 * makieta klock�w
	 */
	private List<BrickMod> points;
	/**
	 * ilo�� �y� gracza
	 */
	private int life;
	/**
	 * wynik gracza
	 */
	private int score;

	public boolean isMenu()
	{
		return menu;
	}

	public void setMenu(boolean menu)
	{
		this.menu = menu;
	}

	public boolean isExit()
	{
		return exit;
	}

	public void setExit(boolean exit)
	{
		this.exit = exit;
	}

	public boolean isTimer()
	{
		return timer;
	}

	public void setTimer(boolean timer)
	{
		this.timer = timer;
	}

	public boolean isGame()
	{
		return game;
	}

	public void setGame(boolean game)
	{
		this.game = game;
	}

	public Point getPalette()
	{
		return palette;
	}

	public void setPalette(Point palette)
	{
		this.palette = palette;
	}

	public Point getBall()
	{
		return ball;
	}

	public void setBall(Point ball)
	{
		this.ball = ball;
	}

	public List<BrickMod> getPoints()
	{
		return points;
	}

	public void setPoints(List<BrickMod> list)
	{
		this.points = list;
	}

	public int getLife()
	{
		return life;
	}

	public void setLife(int life)
	{
		this.life = life;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}

}
