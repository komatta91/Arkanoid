package arkaoid.controller;

import arkaoid.model.Model;
import arkaoid.view.View;

public class Controller implements Runnable 
{
	/** Obiekt model */
	private Model model;
	/** Obiekt widok */
	private View view;

	/**
	 * Bezparametrowy konstruktor obiektu kontrolera
	 */
	public Controller()
	{
		
	}
	
	/**
	 * Kontruktor obiektu kontrolera z parametrami
	 * @param view
	 * @param model
	 */
	public Controller(View view, Model model)
	{
		this.view = view;
		this.model = model;
	}
	
	@Override
	public void run() 
	{
		// TODO Auto-generated method stub
		view.setVisableMainMenu(true);
	}
	
	/**
	 * Medoda ustawiająca pole model dla kontrolera
	 * @param model
	 */
	public void setModel(Model model)
	{
		this.model = model;
	}

	/**
	 * Metoda ustawiająca widok dla kontrolera
	 * @param view
	 */
	public void setView(View view)
	{
		this.view = view;
	}

	/**
	 * Metoda zwracająda obiekt model kontrolera
	 * @return Model
	 */
	public Model getModel()
	{
		return model;
	}

	/**
	 * Metoda zwracająca obiekt widok kontrolera
	 * @return
	 */
	public View getView()
	{
		return view;
	}


}
