package arkaoid.view;

import arkaoid.controller.Controller;

public class View implements Runnable 
{
	/** Obiekt kontroler */
	private Controller controller;
	private MainMenu mainMenu;
	
	/**
	 * Bezparametrowy konstruktor obiektu widoku
	 */
	public View()
	{
		this.initComponents();
	}
	
	/**
	 * Konstruktor obiektu widoku z parametrem
	 * @param controller
	 */
	public View(Controller controller)
	{
		this.controller = controller;
		this.initComponents();
	}
	

	@Override
	public void run() 
	{
		// TODO Auto-generated method stub

	}
	
	/**
	 * Metoda zwracaj�ca kontroler widoku
	 * @return Controller
	 */
	public Controller getController()
	{
		return controller;
	}

	/**
	 * Metoda ustawiaj�ca kontrolera widoku
	 * @param controller
	 */
	public void setController(Controller controller)
	{
		this.controller = controller;
	}
	
	/**
	 * Metoda pokazuj�ca menu g��wne
	 */
	public void setVisableMainMenu(boolean visable)
	{
		mainMenu.setVisible(visable);
	}

	/**
	 * Medoda inicjuj�ca koponenty widoku
	 */
	private void initComponents()
	{
		mainMenu = new MainMenu();
		return;
	}
}
