package arkaoid.model;

import arkaoid.controller.Controller;

public class Model extends Thread
{
	/** Obiekt kontrolera */
	private Controller controller;

	/**
	 * Konstruktor bezparametrowy modelu
	 */
	public Model()
	{

	}

	/**
	 * Konstruktor obieltu model z parametrem
	 * 
	 * @param controller
	 */
	public Model(Controller controller)
	{
		this.controller = controller;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub

	}

	/**
	 * Metoda zwracaj¹ca kontroler modelu
	 * 
	 * @return Controller
	 */
	public Controller getController()
	{
		return controller;
	}

	/**
	 * Metoda ustawiaj¹ca kontroler modelu
	 * 
	 * @param controller
	 */
	public void setController(Controller controller)
	{
		this.controller = controller;
	}
}
