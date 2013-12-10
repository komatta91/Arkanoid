package arkaoid.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;

import arkaoid.ArkanoidStatic;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.ExitButtonAction;

@SuppressWarnings("serial")
public class MainMenu extends JFrame
{
	/** Wysokoœæ okna */
	//public static final int DEFAULT_HEIGHT = 400;
	/** Szerokoœæ okna */
	//public static final int DEFAULT_WIDTH = 300;

	/** Komponent zawieraj¹cy przyciski */
	private MainMenuButtonPanel buttonPanel;

	// private BlockingQueue<AbstractGameAction> bq;

	/** Konstruktor okna MainFrame */
	public MainMenu(final BlockingQueue<AbstractGameAction> bq)
	{
		buttonPanel = new MainMenuButtonPanel(bq);
		
		
		add(buttonPanel);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Arkanoid- menu");
		this.
		setSize(ArkanoidStatic.MENU_DIMENSION);
		//validate();
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
