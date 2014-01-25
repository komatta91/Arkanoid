package arkaoid.model;

import java.awt.Point;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.FailException;

/**
 * Klasa reprezentuj�ca pi�k� w modelu.
 * @author Karol
 *
 */
public class Ball
{
	/**
	 * punkt reprezentuj�cy �rodek pi�ki
	 */
	private Point center = new Point();
	/**
	 * promie� pi�ki
	 */
	private int radius = ArkanoidStatic.BALL_RADIUS;
	/**
	 * czy pi�ka si� porusza
	 */
	private boolean isMoving = false;
	/**
	 * pr�dko�� w p�aszczy�nie pionowej
	 */
	private int dy = 0;
	/**
	 * pr�dko�� w p�aszczy�nie poziomej
	 */
	private int dx = 0;

	public boolean isMoving()
	{
		return isMoving;
	}

	/**
	 * medtoda losuj�ca parametry startowe pr�dko�ci pi�ki
	 * w obu p�aszczyznach.
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
	 * metoda ustawiaj�ca pozycj� �rodka pi�ki wzgl�dem paletki.
	 * Dzia�a tylko je�li pi�ka nie jest w ruchu.
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
	 * metoda odpowiedzialna za ruch pi�ki dodaj�c po wsp��dnych
	 * �rodka warto�ci p�l dx i dy. sprawdzaj�c jednocze�nie czy pi�ka nie wypada
	 * poza graniice ramki.
	 * @throws FailException rzucany gdy pi�ka upadnie na ziemi�.
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
	 * metoda wyliczaj�ca nowy kierunek po odbiciu pi�ki od klocka
	 * @param bricks klicki gry od kt�rych mo�e odbi� si� pi�ka.
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
	 * metoda obliczaj�a odbicie od paletki. Umo�liwia praste sterowanie r�chem pi�ki.
	 * im odbicie nast�pi dalej od �odka tym pi�ka poleci pod wi�kszym kontem i nieco szybciej.
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
	 * ustawia warto�� pr�dko�ci w zale�no�ci od dx
	 * @param dx pr�dko�� pozioma.
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
	 * ustawia warto�� pr�dko�ci w zale�no�ci od dy
	 * @param dy pr�dko�� pionowa.
	 */
	private void setDy(int dy)
	{
		this.dy = dy;
		dx = (int) Math.round(Math.sqrt(36 - (dy * dy)));
		if (Math.random() > 0.5)
			dx = -dx;
	}
}
