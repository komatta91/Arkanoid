package arkaoid.model;

import java.awt.Point;

import arkaoid.ArkanoidStatic;
import arkaoid.controller.Controller;
import arkaoid.model.strategy.ExitStrategy;
import arkaoid.model.strategy.MouseMoveStrategy;
import arkaoid.model.strategy.NewGameStrategy;
import arkaoid.model.strategy.StartMoveStrategy;
import arkaoid.model.strategy.StartStrategy;
import arkaoid.model.strategy.TimerStrategy;

public class Model extends Thread
{
	/** Obiekt kontrolera */
	private Controller controller;
	private Palette palette = new Palette();
	private Ball ball = new Ball();
	private boolean gamePause = false;
	private Bricks bricks = new Bricks();

	public Model()
	{

	}

	public Model(Controller controller)
	{
		this.controller = controller;
	}

	@Override
	public void run()
	{
		// TODO Auto-generated method stub

	}

	public Controller getController()
	{
		return controller;
	}

	public void setController(Controller controller)
	{
		this.controller = controller;
	}

	public void doStrategy(NewGameStrategy s)
	{
		System.out.println("New Game");
		//System.out.println(bricks.count());
		bricks.make();
		//bricks.print();
		gamePause = false;
		ball.stopMoving();
		ball.reRandom();
		Dummy dummy = new Dummy();
		dummy.setGame(true);
		dummy.setTimer(true);
		controller.passDummy(dummy);
	}

	public void doStrategy(ExitStrategy s)
	{
		System.out.println("Exit");
		Dummy dummy = new Dummy();
		dummy.setExit(true);
		dummy.setMenu(true);
		controller.passDummy(dummy);
	}

	public void doStrategy(TimerStrategy s)
	{
		// System.out.println("Time");
		//ball.reRandom();
		Dummy dummy = new Dummy();
		dummy.setGame(true);
		dummy.setTimer(true);
		dummy.setPalette(palette.getPalette());
		ball.move();
		while ((bricks.isHit(ball.getPoint(), ArkanoidStatic.BALL_RADIUS)))
		{
			//ball.change();
			ball.move();
		}
		dummy.setBall(ball.getPoint());
		
		dummy.setPoints(bricks.getBricks());
		//bricks.print();
		controller.passDummy(dummy);
	}

	public void doStrategy(StartStrategy s)
	{
		System.out.println("Start");
		Dummy dummy = new Dummy();
		dummy.setMenu(true);
		controller.passDummy(dummy);
	}

	public void doStrategy(MouseMoveStrategy s)
	{
		// System.out.println("MouseMove");
		if (!gamePause)
		{
			palette.setPoint(s.getPoint());
			if (!ball.isMoving())
			{
				ball.setPoint(palette.getPalette());
			}
		}
	}

	public void doStrategy(StartMoveStrategy s)
	{
		// System.out.println("MouseMove");
		if (!ball.isMoving() && !gamePause)
		{
			ball.startMoving();
		}
	}
}
