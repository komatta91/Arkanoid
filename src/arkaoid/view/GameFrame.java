package arkaoid.view;

import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;

import arkaoid.ArkanoidStatic;
import arkaoid.model.BrickMod;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.StartAction;

@SuppressWarnings("serial")
public class GameFrame extends JFrame
{
	/** Wysokoœæ okna */
	// public static final int DEFAULT_HEIGHT = 600;
	/** Szerokoœæ okna */

	// public static final int DEFAULT_WIDTH = 800;

	private GameFramePanel gamePanel;
	private ScoreGamePanel scorePanel = new ScoreGamePanel();

	public GameFrame(final BlockingQueue<AbstractGameAction> bq)
	{
		gamePanel = new GameFramePanel(bq);
		addKeyListener(new GameKeyListener(bq));
		//addMouseMotionListener(new GameMouseListener(bq));
		setSize(ArkanoidStatic.GAME_FRAME_DIMENSION);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setLayout(null);
		setName("Arkanoid - Gra");
		setResizable(false);
		setLocationRelativeTo(null);
		// add(gamePanel);
		add(gamePanel);
		add(scorePanel);
		scorePanel.setLocation(new Point((int) ArkanoidStatic.GAME_PANEL_DIMENSION.getWidth(), 0));
		// scorePanel.setLocation(new Point(DEFAULT_WIDTH-ScoreGamePanel.));
		// scorePanel.setMaximumSize(new Dimension(10, 10));
		// scorePanel.setSize(new Dimension(10, 10));
		// add(scorePanel);
		
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
		// TODO Auto-generated method stub
		 gamePanel.setPaleteCentre(palette);
	}
	
	public void setBallCentre(Point ball)
	{
		// TODO Auto-generated method stub
		 gamePanel.setBallCentre(ball);
	}
	
	public void setPoints(List<BrickMod> points)
	{
		gamePanel.setPoints(points);
	}

	public void setLife(int life)
	{
		// TODO Auto-generated method stub
		scorePanel.setLife(life);
	}

	public void setScore(int score)
	{
		// TODO Auto-generated method stub
		scorePanel.setScore(score);
	}
}
