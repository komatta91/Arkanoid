package arkaoid.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import arkaoid.ExitException;
import arkaoid.model.Dummy;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.TimerAction;

public class View extends Thread
{
	private MainMenu mainMenu;
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
			timer.start();
		} else
		{
			timer.stop();
		}

	}

	/**
	 * Medoda inicjuj�ca koponenty widoku
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
		// mainMenu.setVisible(true);
		return;
	}

	private void closing() throws ExitException
	{
		Object[] options = { "Tak", "Nie" };
		int ans = JOptionPane.showOptionDialog(mainMenu, "Czy na pewno zamkn�� Arkanoid?", "Pytanie?",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, null);
		switch (ans)
		{
			case JOptionPane.YES_OPTION:
				mainMenu.dispose();
				throw new ExitException();
			case JOptionPane.NO_OPTION:
				break;
		}

	}

}
