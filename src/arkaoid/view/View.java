package arkaoid.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import arkaoid.ArkanoidStatic;
import arkaoid.ExitException;
import arkaoid.model.Dummy;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.TimerAction;

public class View extends Thread
{
	private MainMenu mainMenu;
	private GameFrame gameFrame;
	private final BlockingQueue<AbstractGameAction> bq;
	private Timer timer;
	
	public View(BlockingQueue<AbstractGameAction> bq)
	{
		this.bq = bq;
		this.initComponents();
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub

	}

	public BlockingQueue<AbstractGameAction> getBQ()
	{
		return bq;
	}

	public void checkDummy(Dummy dummy) throws ExitException
	{
		mainMenu.setVisible(dummy.isMenu());
		if (dummy.isExit())
		{
			closing();
		}
		if (dummy.isTimer())
		{
			gameFrame.repaint();
			timer.start();
		} else
		{
			timer.stop();
		}
		gameFrame.setVisible(dummy.isGame());
		if (dummy.getPalette() != null)
		{
			//
			gameFrame. setPaleteCentre(dummy.getPalette());
		}
		if (dummy.getBall() != null)
		{
			//
			gameFrame. setBallCentre(dummy.getBall());
		}
		if (dummy.getPoints() != null)
		{
			gameFrame.setPoints(dummy.getPoints());
		}
		
		gameFrame.setLife(dummy.getLife());
		gameFrame.setScore(dummy.getScore());

	}

	/**
	 * Medoda inicjuj¹ca koponenty widoku
	 */
	private void initComponents()
	{
		mainMenu = new MainMenu(bq);

		timer = new Timer(20, new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				bq.add(new TimerAction());
			}

		});

		gameFrame = new GameFrame(bq);

		return;
	}

	private void closing() throws ExitException
	{
		Object[] options = { "Tak", "Nie" };
		int ans = JOptionPane.showOptionDialog(mainMenu, "Czy na pewno zamkn¹æ Arkanoid?", "Pytanie?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		switch (ans)
		{
			case JOptionPane.YES_OPTION:
				mainMenu.dispose();
				gameFrame.dispose();
				throw new ExitException();
			case JOptionPane.NO_OPTION:
				break;
		}

	}
	public void winn()
	{
		JOptionPane.showMessageDialog(null, "Wygra³eœ.");
	}
	
	public void loos()
	{
		JOptionPane.showMessageDialog(null, "Przegra³eœ.");
	}

}
