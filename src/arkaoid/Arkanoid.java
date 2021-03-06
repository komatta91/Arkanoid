package arkaoid;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import arkaoid.controller.Controller;
import arkaoid.model.Model;
import arkaoid.view.View;
import arkaoid.view.action.AbstractGameAction;

public class Arkanoid
{

	public static void main(String[] args)
	{
		final BlockingQueue<AbstractGameAction> bq = new LinkedBlockingQueue<AbstractGameAction>();
		Model model = new Model();
		View widok = new View(bq);
		Controller controler = new Controller(bq, model, widok);
		model.setController(controler);
		controler.start();
		
	}

}
