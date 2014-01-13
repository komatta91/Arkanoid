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

public class GameMouseListener implements MouseListener, MouseMotionListener
{
	final BlockingQueue<AbstractGameAction> bq;
	private Robot robot;
	private Point centerPoint = new Point(ArkanoidStatic.GAME_PANEL_DIMENSION.width/2,ArkanoidStatic.GAME_PANEL_DIMENSION.height/2);
	
	public GameMouseListener(final BlockingQueue<AbstractGameAction> bq)
	{
		this.bq = bq;
		try
		{
			robot = new Robot();
		} catch (AWTException e1)
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
			throw new RuntimeException();
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		// TODO Auto-generated method stub
		Point point = e.getPoint();
		
		
		Point p = null;
		if (e.getComponent().isVisible())
		{
			p = e.getComponent().getLocationOnScreen();
		}
		if (p != null)
		{
			p.x+=centerPoint.x;
			p.y+=centerPoint.y;
			robot.mouseMove(p.x, p.y);
			if (point.x > centerPoint.x)
			{
				//System.out.println("W lewo");
				bq.add(new MouseMoveLeftAction(point.x - centerPoint.x));
				///TODO Zmieniæ przemieszczanie paletki na dyskretne w lewo w prawo;
			} else
			if (point.x < centerPoint.x) 
			{
				//System.out.println("W Prawo");
				bq.add(new MouseMoveRightAction(point.x - centerPoint.x));
			}
		}
		
		//bq.add(new MouseMoveAction(point));
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		// TODO Auto-generated method stub
		bq.add(new PlayAction());
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		// TODO Auto-generated method stub
		//System.out.println("Wszed³em");
		int[] pixels = new int[16 * 16];
	    Image image = Toolkit.getDefaultToolkit().createImage(
	        new MemoryImageSource(16, 16, pixels, 0, 16));
	    Cursor transparentCursor = Toolkit.getDefaultToolkit().createCustomCursor(
	        image, new Point(0, 0), "invisibleCursor");
		e.getComponent().setCursor(transparentCursor);
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		// TODO Auto-generated method stub
		//System.out.println("Wyszed³em");
		e.getComponent().setCursor(Cursor.getDefaultCursor());
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
