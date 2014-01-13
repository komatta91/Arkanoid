package arkaoid.controller;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.swing.JOptionPane;

import arkaoid.ExitException;
import arkaoid.GameOverException;
import arkaoid.model.Dummy;
import arkaoid.model.Model;
import arkaoid.model.NoBricksException;
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
	/** Obiekt model */
	private final Model model;
	private final View view;
	private Dummy dummy;
	private final BlockingQueue<AbstractGameAction> bq;
	private final Map<AbstractGameAction, AbstractStrategy> map = new HashMap<AbstractGameAction, AbstractStrategy>();

	public Controller(BlockingQueue<AbstractGameAction> bq, Model model, View view)
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
				// System.out.println("Take");
				AbstractGameAction action = bq.take();
				AbstractStrategy s = map.get(action);
				
				if (s instanceof MouseMoveStrategy)
				{
					MouseMoveAction a = (MouseMoveAction) action;
					((MouseMoveStrategy) s).setDx(((MouseMoveAction) action).getDx());
				}
				//e.printStackTrace();
				try
				{
					s.doStrategy(model);
				} catch (GameOverException e)
				{
					// TODO Auto-generated catch block
					//System.out.println("Przegra³eœ!!!");
					EventQueue.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{
							view.loos();;
						}

					});
					new StartStrategy().doStrategy(model);
					
				} catch (NoBricksException e)
				{
					// TODO Auto-generated catch block
					//System.out.println("Wygra³eœ!!!");
					EventQueue.invokeLater(new Runnable()
					{
						@Override
						public void run()
						{
							view.winn();;
						}

					});
					new StartStrategy().doStrategy(model);
				}
				
				
				
				// if (action.toString() == "Zakoñcz")
				// break;
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public Model getModel()
	{
		return model;
	}

	public void passDummy(Dummy dummyIn)
	{
		this.dummy = dummyIn;
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
					// TODO Auto-generated catch block
					System.out.println("Zamkniêcie");
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
		//map.put(new MouseMoveAction(), new MouseMoveStrategy());
		map.put(new PlayAction(), new StartMoveStrategy());
		map.put(new MouseMoveLeftAction(), new MouseMoveStrategy());
		map.put(new MouseMoveRightAction(), new MouseMoveStrategy());
	}

}
