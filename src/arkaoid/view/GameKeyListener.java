package arkaoid.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.concurrent.BlockingQueue;

import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.PlayAction;
import arkaoid.view.action.StartAction;

/**
 * klasa s³uchacza zdarzeñ klawiatury
 * @author Karol
 *
 */
public class GameKeyListener implements KeyListener
{
	private final BlockingQueue<AbstractGameAction> bq;

	public GameKeyListener(final BlockingQueue<AbstractGameAction> bq)
	{
		this.bq = bq;
	}

	/**
	 * metoda wstawia do kolejki blokuj¹cej odpowiednie akcje
	 */
	@Override
	public void keyPressed(KeyEvent e)
	{
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
		{
			bq.add(new StartAction());
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE)
		{
			bq.add(new PlayAction());
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}
}
