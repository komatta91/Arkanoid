package arkaoid.view;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class View extends Thread
{
	/** Obiekt kontroler */
	// private Controller controller;
	private MainMenu mainMenu;
	private final BlockingQueue<AbstractGameAction> bq;

	/**
	 * Bezparametrowy konstruktor obiektu widoku
	 */
	public View(BlockingQueue<AbstractGameAction> bq)
	{
		this.bq = bq;
		this.initComponents();
	}

	/**
	 * Konstruktor obiektu widoku z parametrem
	 * 
	 * @param controller
	 */
	// public View(Controller controller)
	// {
	// this.controller = controller;
	// this.initComponents();
	// }

	@Override
	public void run()
	{
		// TODO Auto-generated method stub

	}

	public BlockingQueue<AbstractGameAction> getBQ()
	{
		return bq;
	}

	/**
	 * Medoda inicjuj¹ca koponenty widoku
	 */
	private void initComponents()
	{
		mainMenu = new MainMenu(bq);
		mainMenu.setVisible(true);
		return;
	}
}
