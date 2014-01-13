package arkaoid.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import arkaoid.ArkanoidStatic;

@SuppressWarnings("serial")
public class ScoreGamePanel extends JPanel
{
	//public static final int DEFAULT_WIDTH = GameFrame.DEFAULT_WIDTH - GameFramePanel.DEFAULT_WIDTH;
	//public static final int DEFAULT_HEIGHT = GameFrame.DEFAULT_HEIGHT;
	private int life;
	private int score;
	
	private Dimension dimension = new Dimension((int)(ArkanoidStatic.GAME_FRAME_DIMENSION.getWidth() - ArkanoidStatic.GAME_PANEL_DIMENSION.getWidth()),
												(int)ArkanoidStatic.GAME_FRAME_DIMENSION.getHeight());
	public ScoreGamePanel()
	{
		setSize(dimension);
		setBackground(Color.LIGHT_GRAY);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("¯ycia: "+life, 50, 300);
		g2.drawString("Punkty: "+score, 50, 330);
	}

	public void setLife(int life)
	{
		// TODO Auto-generated method stub
		this.life = life;
	}

	public void setScore(int score)
	{
		// TODO Auto-generated method stub
		this.score = score;
	}
}
