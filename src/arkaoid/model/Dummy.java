package arkaoid.model;

import java.awt.Point;
import java.util.List;

/**
 * klasa reprezêtuj¹ca makietê modelu.
 * @author Karol
 *
 */
public class Dummy
{
	/**
	 * czy ma byæ pokazane menu
	 */
	private boolean menu = false;
	/**
	 * czy ma byæ pokazane zapytanie o zamkniêcie.
	 */
	private boolean exit = false;
	/**
	 * czy zegar ma byæ w³¹czony
	 */
	private boolean timer = false;
	/**
	 * czy ma byæ pokazane okno gry
	 */
	private boolean game = false;
	/**
	 * punkt ppeprezentuj¹cy paletkê
	 */
	private Point palette = null;
	/**
	 * punkt reprezentuj¹cy pi³kê
	 */
	private Point ball = null;
	/**
	 * makieta klocków
	 */
	private List<BrickMod> points;
	/**
	 * iloœæ ¿yæ gracza
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
