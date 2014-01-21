package arkaoid.view;

import java.awt.AWTException;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.MemoryImageSource;
import java.util.concurrent.BlockingQueue;

import arkaoid.ArkanoidStatic;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.MouseMoveLeftAction;
import arkaoid.view.action.MouseMoveRightAction;
import arkaoid.view.action.PlayAction;

/**
 * Klasa obs³uguj¹ca gesty myszy.
 * @author Karol
 *
 */
public class GameMouseListener implements MouseListener, MouseMotionListener
{
	/**
	 * kolejka blokuj¹ca
	 */
	private final BlockingQueue<AbstractGameAction> bq;
	/**
	 * robot
	 */
	private final Robot robot;
	/**
	 * œrodek paneku gry
	 */
	private final Point centerPoint = new Point(
			ArkanoidStatic.GAME_PANEL_DIMENSION.width / 2,
			ArkanoidStatic.GAME_PANEL_DIMENSION.height / 2);

	public GameMouseListener(final BlockingQueue<AbstractGameAction> bq)
	{
		this.bq = bq;
		try
		{
			robot = new Robot();
		} catch (AWTException e1)
		{
			e1.printStackTrace();
			throw new RuntimeException();
		}

	}

	@Override
	public void mouseDragged(MouseEvent e)
	{

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		Point point = e.getPoint();
		Point p = null;
		if (e.getComponent().isVisible())
		{
			p = e.getComponent().getLocationOnScreen();
		}
		if (p != null)
		{
			addAction(point, p);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		bq.add(new PlayAction());
	}

	/**
	 * metoda chowa kursor gdy mysz wejdzie w komponent
	 */
	@Override
	public void mouseEntered(MouseEvent e)
	{
		int[] pixels = new int[16 * 16];
		Image image = Toolkit.getDefaultToolkit().createImage(
				new MemoryImageSource(16, 16, pixels, 0, 16));
		Cursor transparentCursor = Toolkit.getDefaultToolkit()
				.createCustomCursor(image, new Point(0, 0), "invisibleCursor");
		e.getComponent().setCursor(transparentCursor);
	}

	/**
	 * metoda przywraca domyœlny kursor gdy mysz opuœci komponent
	 */
	@Override
	public void mouseExited(MouseEvent e)
	{
		e.getComponent().setCursor(Cursor.getDefaultCursor());
	}

	@Override
	public void mousePressed(MouseEvent e)
	{

	}

	@Override
	public void mouseReleased(MouseEvent e)
	{

	}

	/**
	 * metoda podaje odpowiedni¹ akcjê do kolejki blokuj¹cej i przesuwa
	 * kursor na œrodek komponentu
	 * @param eventPoint punks eventu
	 * @param windowPoint punkt œrodka ekranu
	 */
	private void addAction(Point eventPoint, Point windowPoint)
	{
		windowPoint.x += centerPoint.x;
		windowPoint.y += centerPoint.y;
		robot.mouseMove(windowPoint.x, windowPoint.y);
		if (eventPoint.x > centerPoint.x)
		{
			bq.add(new MouseMoveLeftAction(eventPoint.x - centerPoint.x));
		} else if (eventPoint.x < centerPoint.x)
		{
			bq.add(new MouseMoveRightAction(eventPoint.x - centerPoint.x));
		}
	}

}
