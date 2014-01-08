package arkaoid.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import arkaoid.ArkanoidStatic;

@SuppressWarnings("serial")
public class ScoreGamePanel extends JPanel
{
	//public static final int DEFAULT_WIDTH = GameFrame.DEFAULT_WIDTH - GameFramePanel.DEFAULT_WIDTH;
	//public static final int DEFAULT_HEIGHT = GameFrame.DEFAULT_HEIGHT;
	
	private Dimension dimension = new Dimension((int)(ArkanoidStatic.GAME_FRAME_DIMENSION.getWidth() - ArkanoidStatic.GAME_PANEL_DIMENSION.getWidth()),
												(int)ArkanoidStatic.GAME_FRAME_DIMENSION.getHeight());
	public ScoreGamePanel()
	{
		setSize(dimension);
		setBackground(Color.LIGHT_GRAY);
	}
}
