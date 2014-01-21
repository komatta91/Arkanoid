package arkaoid.controller;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import arkaoid.Exceptons.ExitException;
import arkaoid.Exceptons.GameOverException;
import arkaoid.Exceptons.NoBricksException;
import arkaoid.model.Dummy;
import arkaoid.model.Model;
import arkaoid.model.strategy.AbstractStrategy;
import arkaoid.model.strategy.ExitStrategy;
import arkaoid.model.strategy.MouseMoveStrategy;
import arkaoid.model.strategy.NewGameStrategy;
import arkaoid.model.strategy.StartMoveStrategy;
import arkaoid.model.strategy.StartStrategy;
import arkaoid.model.strategy.TimerStrategy;
import arkaoid.view.View;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.ExitButtonAction;
import arkaoid.view.action.MouseMoveAction;
import arkaoid.view.action.MouseMoveLeftAction;
import arkaoid.view.action.MouseMoveRightAction;
import arkaoid.view.action.NewGameButtonAction;
import arkaoid.view.action.PlayAction;
import arkaoid.view.action.StartAction;
import arkaoid.view.action.TimerAction;

/**
 * Klasa kontrolera. Odpowiedzialna za komunikacjê pomiêdzy widokiem i modelem.
 * @author Karol
 *
 */
public class Controller extends Thread
{
	private final Model model;
	private final View view;
	///Kolejka blokuj¹ca przekazuj¹ca akcje które wyst¹pi³y w widoku.
	private final BlockingQueue<AbstractGameAction> bq;
	///Mapa akcji i odpowiadaj¹cych i strategii.
	private final Map<AbstractGameAction, AbstractStrategy> map = new HashMap<AbstractGameAction, AbstractStrategy>();

	public Controller(BlockingQueue<AbstractGameAction> bq, Model model,
			View view)
	{
		this.model = model;
		this.view = view;
		this.bq = bq;
		makeActionStrategy();
	}

	/**
	 * G³ówna pêtla programu. Odpowiedzialna za pobranie kolejnych
	 * zdarzeñ z widoku. Rozpoznanie ich i wykonanie
	 * odpowiadaj¹cych im strategii.
	 */
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		new StartStrategy().doStrategy(model);
		while (true)
		{

			try
			{
				AbstractGameAction action = bq.take();
				AbstractStrategy s = map.get(action);
				///Przekazanie prametru przesuniêcia z akcji do strategii.
				if (s instanceof MouseMoveStrategy)
				{
					((MouseMoveStrategy) s).setDx(((MouseMoveAction) action)
							.getDx());
				}
				try
				{
					s.doStrategy(model);
				} catch (final GameOverException e)
				{
					EventQueue.invokeLater(new Runnable()
					{
						///Nast¹pi³ wyj¹tek przegranej.
						@Override
						public void run()
						{
							view.showMessage(e.getMessage());
						}

					});
					new StartStrategy().doStrategy(model);

				} catch (final NoBricksException e)
				{
					///Nast¹pi³ wyj¹tek zwyciêstwa.
					EventQueue.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{
							view.showMessage(e.getMessage());
						}

					});
					new StartStrategy().doStrategy(model);
				}

			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

		}
	}

	public Model getModel()
	{
		return model;
	}
	
	/**
	 * Metoda przekazuj¹ca makiete do widoku.
	 * @param dummy makieta pochodz¹ca z modelu.
	 */
	public void passDummy(final Dummy dummy)
	{
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					view.checkDummy(dummy);
				} catch (ExitException e)
				{
					System.exit(0);
				}

			}

		});
	}

	/**
	 * Medtoda odpowiedzialna za utworzenie mapy akcji i odpowiadaj¹cym
	 * im strategii.
	 */
	private void makeActionStrategy()
	{
		map.put(new NewGameButtonAction(), new NewGameStrategy());
		map.put(new ExitButtonAction(), new ExitStrategy());
		map.put(new TimerAction(), new TimerStrategy());
		map.put(new StartAction(), new StartStrategy());
		map.put(new PlayAction(), new StartMoveStrategy());
		map.put(new MouseMoveLeftAction(), new MouseMoveStrategy());
		map.put(new MouseMoveRightAction(), new MouseMoveStrategy());
	}

}
