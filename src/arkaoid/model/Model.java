package arkaoid.model;

import arkaoid.ArkanoidStatic;
import arkaoid.GameOverException;
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
	private boolean gamePause = true;
	private Bricks bricks = new Bricks();
	private int life = ArkanoidStatic.LIFE_NUMBER;

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
		//System.out.println("New Game");
		gamePause = false;
		//bricks.
		//System.out.println(bricks.count());
		bricks.make();
		//bricks.print();
		gamePause = false;
		ball.stopMoving();
		ball.reRandom();
		ball.setPoint(palette.getPalette());
		Dummy dummy = new Dummy();
		dummy.setGame(true);
		dummy.setTimer(true);
		controller.passDummy(dummy);
		this.life = ArkanoidStatic.LIFE_NUMBER;
		bricks.resetScore();
	}

	public void doStrategy(ExitStrategy s)
	{
		//System.out.println("Exit");
		gamePause = true;
		Dummy dummy = new Dummy();
		dummy.setExit(true);
		dummy.setMenu(true);
		controller.passDummy(dummy);
	}

	public void doStrategy(TimerStrategy s) throws GameOverException, NoBricksException
	{
		// System.out.println("Time");
		//ball.reRandom();
		Dummy dummy = new Dummy();
		dummy.setGame(true);
		dummy.setTimer(true);
		dummy.setPalette(palette.getPalette());
		
		
			if ((bricks.isHit(ball.getPoint(), ArkanoidStatic.BALL_RADIUS)))
			{
				//TODO Odbicie od klocka
				ball.bounce(bricks);
				bricks.hit(ball.getPoint(), ArkanoidStatic.BALL_RADIUS);
				
				

				//ball.move();
			}
			if (palette.isHit(ball.getPoint(), ArkanoidStatic.BALL_RADIUS) && ball.isMoving())
			{
				//System.out.println("Paletka");
				ball.bounce(palette);
			}
			try
			{
				ball.move();
			} catch (FailException e)
			{
				// TODO Auto-generated catch block
				//System.out.println("Skucha!!!");
				//System.out.println(life-1);
				if (ball.isMoving() && --life == 0)
				{
					throw new GameOverException();
				}
				ball.stopMoving();
				ball.setPoint(palette.getPalette());
			}
		dummy.setBall(ball.getPoint());
		
		dummy.setPoints(bricks.getBricks());
		//bricks.print();
		dummy.setScore(bricks.getScore());
		dummy.setLife(life);
		controller.passDummy(dummy);
	}

	public void doStrategy(StartStrategy s)
	{
		//System.out.println("Start");
		this.life = ArkanoidStatic.LIFE_NUMBER;
		bricks.resetScore();
		Dummy dummy = new Dummy();
		dummy.setMenu(true);
		controller.passDummy(dummy);
	}


	public void doStrategy(StartMoveStrategy s)
	{
		// System.out.println("MouseMove");
		if (!ball.isMoving() && !gamePause)
		{
			ball.startMoving();
		}
	}

	public void doStrategy(MouseMoveStrategy s)
	{
		// TODO Auto-generated method stub
		if (!gamePause)
		{
			palette.move(s.getDx());
			if (!ball.isMoving())
			{
				ball.setPoint(palette.getPalette());
			}
		}
	}
}
