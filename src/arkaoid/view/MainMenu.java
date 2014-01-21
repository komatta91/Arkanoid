package arkaoid.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;

import arkaoid.ArkanoidStatic;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.ExitButtonAction;

/**
 * klasa reprezentuj¹ca megu g³ówne gry
 * @author Karol
 *
 */
@SuppressWarnings("serial")
public class MainMenu extends JFrame
{
	private MainMenuButtonPanel buttonPanel;

	public MainMenu(final BlockingQueue<AbstractGameAction> bq)
	{
		buttonPanel = new MainMenuButtonPanel(bq);
		add(buttonPanel);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Arkanoid- menu");
		this.setSize(ArkanoidStatic.MENU_DIMENSION);
		setLocationRelativeTo(null);
		setResizable(false);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				bq.add(new ExitButtonAction());
			}
		});
	}
}
