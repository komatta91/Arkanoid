package arkaoid.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.swing.JPanel;

import arkaoid.ArkanoidStatic;
import arkaoid.model.BrickMod;
import arkaoid.view.action.AbstractGameAction;

/**
 * Klasa reprezêtuj¹ca panel w którym rozgrywa siê gra.
 * @author Karol
 *
 */
@SuppressWarnings("serial")
public class GameFramePanel extends JPanel
{
	/**
	 * lewy górny róg paletki
	 */
	private Point palette = new Point();
	/**
	 * œrodek pi³ki
	 */
	private Point ballCentre = new Point();
	/**
	 * kolekcja lewych górnych rógów klocków
	 */
	private List<BrickMod> points;

	public GameFramePanel(final BlockingQueue<AbstractGameAction> bq)
	{
		setSize(ArkanoidStatic.GAME_PANEL_DIMENSION);
		setBackground(new Color(133, 133, 233));
		GameMouseListener ml = new GameMouseListener(bq);
		addMouseMotionListener(ml);
		addMouseListener(ml);
	}

	/**
	 * metoda odpowiedzialna za rysowanie zawartoœci
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		paintPalette(g2);
		paintBall(g2);
		if (points != null)
		{
			paintBricks(g2);
		}
	}

	public void setPaleteCentre(Point paletteCentre)
	{
		int x = paletteCentre.x - ArkanoidStatic.PALETTE_DIMENSION.width / 2;
		int y = paletteCentre.y;
		this.palette = new Point(x, y);
	}

	public void setBallCentre(Point ballCentre)
	{
		this.ballCentre.setLocation(ballCentre.x, ballCentre.y);
	}

	public void setPoints(List<BrickMod> points)
	{
		this.points = points;
	}

	/**
	 * metoda odpowiedzialna za rysowanie klocków
	 * @param g2 
	 */
	private void paintBricks(Graphics2D g2)
	{
		for (BrickMod p : points)
		{
			paintBrick(g2, p);
		}
	}

	/**
	 * metoda odpowiedzialna za rysowanie klocka
	 * @param g2
	 * @param brick klocek
	 */
	private void paintBrick(Graphics2D g2, BrickMod brick)
	{
		Rectangle2D rect = new Rectangle2D.Double();
		rect.setFrame(brick.getPoint(), ArkanoidStatic.BRICK_DIMENSION);
		g2.setColor(checkColor(brick.getLife()));
		g2.fill(rect);
		g2.draw(rect);
		paintBrickFrame(g2, rect);
	}

	/**
	 * metoda odpowiedziala za rysowanie obramowania klocka
	 * @param g2
	 * @param rectangle kszta³t klocka
	 */
	private void paintBrickFrame(Graphics2D g2, Rectangle2D rectangle)
	{
		Rectangle2D rectFrame = new Rectangle2D.Double();
		rectFrame.setFrame(rectangle);
		g2.setColor(Color.BLACK);
		g2.draw(rectFrame);
	}

	/**
	 * metoda wybieraj¹ca kolor t³a klocka na podstawie jego punktów ¿ycia.
	 * @param life
	 * @return
	 */
	private Color checkColor(int life)
	{
		switch (life)
		{
		case 1:
			return Color.PINK;
		case 2:
			return Color.MAGENTA;
		case 3:
			return new Color(248, 88, 35);
		case -1:
			return Color.ORANGE;
		default:
			return Color.BLACK;
		}
	}

	/**
	 * metoda odpowiedzialna za rysowanie pi³ki
	 * @param g2
	 */
	private void paintBall(Graphics2D g2)
	{
		Ellipse2D kolo = new Ellipse2D.Double(ballCentre.x, ballCentre.y,
				ArkanoidStatic.BALL_RADIUS, ArkanoidStatic.BALL_RADIUS);
		g2.setColor(Color.YELLOW);
		g2.fill(kolo);
		g2.draw(kolo);
	}

	/**
	 * metoda odpowiedzialna za rysowanie paletki
	 * @param g2
	 */
	private void paintPalette(Graphics2D g2)
	{
		Rectangle2D rec = new Rectangle2D.Double();
		rec.setFrame(palette, ArkanoidStatic.PALETTE_DIMENSION);
		g2.setColor(Color.BLACK);
		g2.fill(rec);
		g2.draw(rec);
	}
}
