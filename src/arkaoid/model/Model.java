package arkaoid.model;

import arkaoid.ArkanoidStatic;
import arkaoid.Exceptons.FailException;
import arkaoid.Exceptons.GameOverException;
import arkaoid.Exceptons.NoBricksException;
import arkaoid.controller.Controller;
import arkaoid.model.strategy.ExitStrategy;
import arkaoid.model.strategy.MouseMoveStrategy;
import arkaoid.model.strategy.NewGameStrategy;
import arkaoid.model.strategy.StartMoveStrategy;
import arkaoid.model.strategy.StartStrategy;
import arkaoid.model.strategy.TimerStrategy;

public class Model
{
	private Controller controller;
	private Palette palette = new Palette();
	private Ball ball = new Ball();
	/**
	 * czy gra jest zatrzymana
	 */
	private boolean gamePause = true;
	private Bricks bricks = new Bricks();
	/**
	 * liczba ¿yæ gracza
	 */
	private int life = ArkanoidStatic.LIFE_NUMBER;

	public Model()
	{

	}

	public Model(Controller controller)
	{
		this.controller = controller;
	}

	public Controller getController()
	{
		return controller;
	}

	public void setController(Controller controller)
	{
		this.controller = controller;
	}

	/**
	 * Dalej wystêpuj¹ metody obs³uguj¹ce ró¿ne strategi niezbêdne
	 * do dzia³ania aplikacji.
	 */
	
	/**
	 * metoda obs³uguj¹ca strategiê nowej gry
	 * @param s strategia nowej gry
	 * @throws NoBricksException
	 */
	public void doStrategy(NewGameStrategy s) throws NoBricksException
	{

		gamePause = false;
		bricks.make();
		gamePause = false;
		ball.stopMoving();
		ball.reRandom();
		ball.setPointFromPalette(palette.getPalette());
		Dummy dummy = new Dummy();
		dummy.setGame(true);
		dummy.setTimer(true);
		this.life = ArkanoidStatic.LIFE_NUMBER;
		bricks.resetScore();
		controller.passDummy(dummy);
	}

	/**
	 * metoda obs³uguj¹ca strategiê zamkniêcia gry.
	 * @param s strategia zamkniêcia
	 */
	public void doStrategy(ExitStrategy s)
	{
		gamePause = true;
		Dummy dummy = new Dummy();
		dummy.setExit(true);
		dummy.setMenu(true);
		controller.passDummy(dummy);
	}

	/**
	 * metoda obs³uguj¹ca strategiê czasu
	 * @param s strategia czasu
	 * @throws GameOverException wyj¹tek przegranej
	 * @throws NoBricksException wyj¹tek wygranej
	 */
	public void doStrategy(TimerStrategy s) throws GameOverException,
			NoBricksException
	{
		Dummy dummy = new Dummy();
		dummy.setGame(true);
		dummy.setTimer(true);
		dummy.setPalette(palette.getPalette());

		if ((bricks.isHit(ball.getPoint(), ArkanoidStatic.BALL_RADIUS)))
		{
			ball.bounce(bricks);
			bricks.hit(ball.getPoint(), ArkanoidStatic.BALL_RADIUS);
		}
		if (palette.isHit(ball.getPoint(), ArkanoidStatic.BALL_RADIUS)
				&& ball.isMoving())
		{
			ball.bounce(palette);
		}
		try
		{
			ball.move();
		} catch (FailException e)
		{
			if (ball.isMoving() && --life == 0)
			{
				throw new GameOverException("Przegra³eœ!! \n Twój wynik to: "
						+ bricks.getScore());
			}
			ball.stopMoving();
			ball.setPointFromPalette(palette.getPalette());
		}
		dummy.setBall(ball.getPoint());

		dummy.setPoints(bricks.getBricks());
		dummy.setScore(bricks.getScore());
		dummy.setLife(life);
		controller.passDummy(dummy);
	}

	/**
	 * metoda obs³uguj¹ca strategiê startu aplikacji
	 * @param s
	 */
	public void doStrategy(StartStrategy s)
	{
		this.life = ArkanoidStatic.LIFE_NUMBER;
		bricks.resetScore();
		Dummy dummy = new Dummy();
		dummy.setMenu(true);
		controller.passDummy(dummy);
	}

	/**
	 * metoda obs³uguj¹ca strategiê startu poruszania siê pi³ki
	 * @param s
	 */
	public void doStrategy(StartMoveStrategy s)
	{
		if (!ball.isMoving() && !gamePause)
		{
			ball.startMoving();
		}
	}

	/**
	 * metoda obs³uguj¹ca strategiê poruszenia myszki
	 * @param s
	 */
	public void doStrategy(MouseMoveStrategy s)
	{
		if (!gamePause)
		{
			palette.move(s.getDx());
			if (!ball.isMoving())
			{
				ball.setPointFromPalette(palette.getPalette());
			}
		}
	}
}
