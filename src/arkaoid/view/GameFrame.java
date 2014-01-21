package arkaoid.view;

import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;

import arkaoid.ArkanoidStatic;
import arkaoid.model.BrickMod;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.StartAction;

/**
 * Klasa reprezêtuj¹ca okno gry
 * @author Karol
 *
 */
@SuppressWarnings("serial")
public class GameFrame extends JFrame
{
	/**
	 * panel gry
	 */
	private GameFramePanel gamePanel;
	/**
	 * panel punktów
	 */
	private ScoreGamePanel scorePanel = new ScoreGamePanel();

	public GameFrame(final BlockingQueue<AbstractGameAction> bq)
	{
		gamePanel = new GameFramePanel(bq);
		addKeyListener(new GameKeyListener(bq));
		setSize(ArkanoidStatic.GAME_FRAME_DIMENSION);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setName("Arkanoid - Gra");
		setResizable(false);
		setLocationRelativeTo(null);
		add(gamePanel);
		add(scorePanel);
		scorePanel.setLocation(new Point(
				ArkanoidStatic.GAME_PANEL_DIMENSION.width, 0));
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent evt)
			{
				bq.add(new StartAction());
			}
		});
	}

	public void setPaleteCentre(Point palette)
	{
		gamePanel.setPaleteCentre(palette);
	}

	public void setBallCentre(Point ball)
	{
		gamePanel.setBallCentre(ball);
	}

	public void setPoints(List<BrickMod> points)
	{
		gamePanel.setPoints(points);
	}

	public void setLife(int life)
	{
		scorePanel.setLife(life);
	}

	public void setScore(int score)
	{
		scorePanel.setScore(score);
	}
}
