package arkaoid.controller;

import java.util.concurrent.BlockingQueue;

import arkaoid.model.Model;
import arkaoid.view.AbstractGameAction;

public class Controller extends Thread
{
	/** Obiekt model */
	private final Model model;

	private BlockingQueue<AbstractGameAction> bq;

	public Controller(BlockingQueue<AbstractGameAction> bq, Model model)
	{
		this.model = model;
		this.bq = bq;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while (true)
		{
			try
			{
				//System.out.println("Take");
				AbstractGameAction action = bq.take();
				System.out.println(action);
				//if (action.toString() == "Zakoñcz")
					//break;
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

}
