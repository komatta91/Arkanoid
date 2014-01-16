package arkaoid.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import arkaoid.Exceptons.ExitException;
import arkaoid.model.Dummy;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.TimerAction;

public class View
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

	public BlockingQueue<AbstractGameAction> getBQ()
	{
		return bq;
	}

	public void checkDummy(Dummy dummy) throws ExitException
	{
		mainMenu.setVisible(dummy.isMenu());
		gameFrame.setVisible(dummy.isGame());
		gameFrame.setLife(dummy.getLife());
		gameFrame.setScore(dummy.getScore());
		if (dummy.isExit())
		{
			closing();
		}
		if (dummy.getPalette() != null)
		{
			gameFrame.setPaleteCentre(dummy.getPalette());
		}
		if (dummy.getBall() != null)
		{
			gameFrame.setBallCentre(dummy.getBall());
		}
		if (dummy.getPoints() != null)
		{
			gameFrame.setPoints(dummy.getPoints());
		}
		if (dummy.isTimer())
		{
			gameFrame.repaint();
			timer.start();
		} else
		{
			timer.stop();
		}
	}

	private void initComponents()
	{
		mainMenu = new MainMenu(bq);

		timer = new Timer(20, new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				bq.add(new TimerAction());
			}
		});
		gameFrame = new GameFrame(bq);
		return;
	}

	private void closing() throws ExitException
	{
		Object[] options = { "Tak", "Nie" };
		int ans = JOptionPane.showOptionDialog(mainMenu,
				"Czy na pewno zamkn¹æ Arkanoid?", "Pytanie?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				options, null);

		if (JOptionPane.YES_OPTION == ans)
		{
			mainMenu.dispose();
			gameFrame.dispose();
			throw new ExitException();
		}
	}

	public void winn(String s)
	{
		JOptionPane.showMessageDialog(null, s);
	}

	public void loos(String s)
	{
		JOptionPane.showMessageDialog(null, s);
	}

}
