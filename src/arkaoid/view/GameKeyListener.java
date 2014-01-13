package arkaoid.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.BlockingQueue;

import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.PlayAction;
import arkaoid.view.action.StartAction;

public class GameKeyListener implements KeyListener
{
	private final BlockingQueue<AbstractGameAction> bq;

	public GameKeyListener(final BlockingQueue<AbstractGameAction> bq)
	{
		this.bq = bq;
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			bq.add(new StartAction());
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			System.out.println("Spacja");
			bq.add(new PlayAction());
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e)
	{
		// TODO Auto-generated method stub

	}
}
