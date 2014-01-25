package arkaoid.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.ExitException;
import arkaoid.model.Dummy;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.TimerAction;

/**
 * klasa reprezentuj¹ca widok
 * @author Karol
 *
 */
public class View
{
	/**
	 * Menu g³ówne
	 */
	private MainMenu mainMenu;
	/**
	 * okno gry
	 */
	private GameFrame gameFrame;
	/**
	 * kolejka blokuj¹ca
	 */
	private final BlockingQueue<AbstractGameAction> bq;
	/**
	 * zegar
	 */
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
	
	/**
	 * metoda pokazuj¹ca komunikat
	 * @param s komunikat
	 */	
	public void showMessage(String s)
	{
		gameFrame.setVisible(false);
		mainMenu.setVisible(false);
		JOptionPane.showMessageDialog(null, s);
	}

	/**
	 * metoda rozpoznaj¹ca makiete
	 * @param dummy makieta
	 * @throws ExitException wyj¹tek wyjœcia z aplikacji
	 */
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

	/**
	 * metoda inicjalizuj¹ca komponenty
	 */
	private void initComponents()
	{
		mainMenu = new MainMenu(bq);

		timer = new Timer(ArkanoidStatic.FPS, new ActionListener()
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

	/**
	 * metoda pokazuj¹za komunikat z zapytaniem o zamkniêcie.
	 * @throws ExitException wyj¹tek zamkniêcia palikacji
	 */
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

	

}
