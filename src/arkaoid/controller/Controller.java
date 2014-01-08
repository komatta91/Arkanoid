package arkaoid.controller;

import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import arkaoid.ExitException;
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
				
				try
				{
					MouseMoveStrategy st = (MouseMoveStrategy)s;
					MouseMoveAction act = (MouseMoveAction)action;
					st.setPoint(act.getPoint());
					st.doStrategy(model);
					
				}catch(ClassCastException e)
				{
					//e.printStackTrace();
					s.doStrategy(model);
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
		map.put(new MouseMoveAction(), new MouseMoveStrategy());
		map.put(new PlayAction(), new StartMoveStrategy());
	}

}
