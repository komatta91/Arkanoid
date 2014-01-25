package arkaoid.model;

import java.awt.Point;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.FailException;

/**
 * Klasa reprezentuj¹ca pi³kê w modelu.
 * @author Karol
 *
 */
public class Ball
{
	/**
	 * punkt reprezentuj¹cy œrodek pi³ki
	 */
	private Point center = new Point();
	/**
	 * promieñ pi³ki
	 */
	private int radius = ArkanoidStatic.BALL_RADIUS;
	/**
	 * czy pi³ka siê porusza
	 */
	private boolean isMoving = false;
	/**
	 * prêdkoœæ w p³aszczyŸnie pionowej
	 */
	private int dy = 0;
	/**
	 * prêdkoœæ w p³aszczyŸnie poziomej
	 */
	private int dx = 0;

	public boolean isMoving()
	{
		return isMoving;
	}

	/**
	 * medtoda losuj¹ca parametry startowe prêdkoœci pi³ki
	 * w obu p³aszczyznach.
	 */
	public void reRandom()
	{
		double random = Math.random();
		for (int i = 1; i < 7; ++i)
		{
			//System.out.println(i);
			if (random < i * 0.17)
			{
				setDy(-i);
				break;
			}
		}

	}

	
	
	public void startMoving()
	{
		isMoving = true;
	}

	public void stopMoving()
	{
		isMoving = false;
	}
	
	/**
	 * metoda ustawiaj¹ca pozycjê œrodka pi³ki wzglêdem paletki.
	 * Dzia³a tylko jeœli pi³ka nie jest w ruchu.
	 * @param p punkt centralny paletki.
	 */
	public void setPointFromPalette(Point p)
	{
		if (isMoving) 
		{
			return;
		}
		center.setLocation(p.x - radius / 2, p.y
				- (ArkanoidStatic.PALETTE_DIMENSION.height + 1));

	}
	/**
	 * metoda odpowiedzialna za ruch pi³ki dodaj¹c po wspó³¿êdnych
	 * œrodka wartoœci pól dx i dy. sprawdzaj¹c jednoczeœnie czy pi³ka nie wypada
	 * poza graniice ramki.
	 * @throws FailException rzucany gdy pi³ka upadnie na ziemiê.
	 */
	public void move() throws FailException
	{
		if (!(this.center.x + dx > 0 && this.center.x < ArkanoidStatic.GAME_PANEL_DIMENSION.width
				- radius))
		{
			this.dx = -this.dx;
		}
		if (!(this.center.y + dy > 0 && this.center.y < ArkanoidStatic.GAME_PANEL_DIMENSION.height
				- radius))
		{
			if (this.center.y > ArkanoidStatic.GAME_PANEL_DIMENSION.height
					- radius - 10)
			{
				throw new FailException();
			}
			this.dy = -this.dy;
		}
		if (isMoving)
		{
			this.center.x += dx;
			this.center.y += dy;
		}
	}

	public Point getPoint()
	{
		return (Point) center.clone();
	}
	/**
	 * metoda wyliczaj¹ca nowy kierunek po odbiciu pi³ki od klocka
	 * @param bricks klicki gry od których mo¿e odbiæ siê pi³ka.
	 */
	public void bounce(Bricks bricks)
	{
		Point p = new Point(center.x, center.y - dy);
		if (!bricks.isHit(p, radius))
		{
			this.dy = -this.dy;
			return;
		}
		p = new Point(center.x - dx, center.y);
		if (!bricks.isHit(p, radius))
		{
			this.dx = -this.dx;
			return;
		}
		dx = -dx;
		dy = -dy;
	}

	/**
	 * metoda obliczaj¹a odbicie od paletki. Umo¿liwia praste sterowanie róchem pi³ki.
	 * im odbicie nast¹pi dalej od œodka tym pi³ka poleci pod wiêkszym kontem i nieco szybciej.
	 * @param palette paletka
	 */
	public void bounce(Palette palette)
	{
		int newDx = this.center.x - palette.getPalette().x;
		int lenght = ArkanoidStatic.PALETTE_DIMENSION.width / 12;
		int tmp = newDx / lenght + 1;
		if (tmp > 6)
		{
			tmp = 6;
		}
		if (tmp < -6)
		{
			tmp = -6;
		}
		setDx(tmp);
	}
	
	/**
	 * ustawia wartoœæ prêdkoœci w zale¿noœci od dx
	 * @param dx prêdkoœæ pozioma.
	 */
	private void setDx(int dx)
	{
		this.dx = dx;
		dy = (int) Math.round(Math.sqrt(36 - dx));
		if (dy > 0)
		{
			dy = -dy;
		}
	}
	
	/**
	 * ustawia wartoœæ prêdkoœci w zale¿noœci od dy
	 * @param dy prêdkoœæ pionowa.
	 */
	private void setDy(int dy)
	{
		this.dy = dy;
		dx = (int) Math.round(Math.sqrt(36 - (dy * dy)));
		if (Math.random() > 0.5)
			dx = -dx;
	}
}
