package arkaoid.view;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.concurrent.BlockingQueue;

import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.MouseMoveAction;

public class GameMouseListener implements MouseMotionListener
{
	final BlockingQueue<AbstractGameAction> bq;
	
	public GameMouseListener(final BlockingQueue<AbstractGameAction> bq)
	{
		this.bq = bq;
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
		
		bq.add(new MouseMoveAction(point));
	}

}
