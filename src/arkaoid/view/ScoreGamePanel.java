package arkaoid.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import arkaoid.ArkanoidStatic;

/**
 * klasa reprezentuj¹ca panel punktów
 * @author Karol
 *
 */
@SuppressWarnings("serial")
public class ScoreGamePanel extends JPanel
{
	/**
	 * ¿ycie gracza
	 */
	private int life;
	/**
	 * liczba punktów zdobyta przez gracza
	 */
	private int score;

	public ScoreGamePanel()
	{
		setSize(ArkanoidStatic.GAME_FRAME_DIMENSION);
		setBackground(Color.LIGHT_GRAY);
	}

	/**
	 * metoda rysuj¹ca panel
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.drawString("¯ycia: " + life, 50, 300);
		g2.drawString("Punkty: " + score, 50, 330);
	}

	public void setLife(int life)
	{
		this.life = life;
	}

	public void setScore(int score)
	{
		this.score = score;
	}
}
