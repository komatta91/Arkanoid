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

public class Controller extends Thread
{
	private final Model model;
	private final View view;
	private final BlockingQueue<AbstractGameAction> bq;
	private final Map<AbstractGameAction, AbstractStrategy> map = new HashMap<AbstractGameAction, AbstractStrategy>();

	public Controller(BlockingQueue<AbstractGameAction> bq, Model model,
			View view)
	{
		this.model = model;
		this.view = view;
		this.bq = bq;
		makeActionStrategy();
	}

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
						@Override
						public void run()
						{
							view.loos(e.getMessage());
						}

					});
					new StartStrategy().doStrategy(model);

				} catch (final NoBricksException e)
				{
					EventQueue.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{
							view.winn(e.getMessage());
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
