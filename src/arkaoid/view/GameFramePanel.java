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

@SuppressWarnings("serial")
public class GameFramePanel extends JPanel
{
	private Point palette = new Point();
	private Point ballCentre = new Point();
	private List<BrickMod> points;

	public GameFramePanel(final BlockingQueue<AbstractGameAction> bq)
	{
		setSize(ArkanoidStatic.GAME_PANEL_DIMENSION);
		setBackground(new Color(133, 133, 233));
		GameMouseListener ml = new GameMouseListener(bq);
		addMouseMotionListener(ml);
		addMouseListener(ml);
	}

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

	private void paintBricks(Graphics2D g2)
	{
		for (BrickMod p : points)
		{
			paintBrick(g2, p);
		}
	}

	private void paintBrick(Graphics2D g2, BrickMod brick)
	{
		Rectangle2D rect = new Rectangle2D.Double();
		rect.setFrame(brick.getPoint(), ArkanoidStatic.BRICK_DIMENSION);
		g2.setColor(checkColor(brick.getLife()));
		g2.fill(rect);
		g2.draw(rect);
		paintBrickFrame(g2, rect);
	}

	private void paintBrickFrame(Graphics2D g2, Rectangle2D rectangle)
	{
		Rectangle2D rectFrame = new Rectangle2D.Double();
		rectFrame.setFrame(rectangle);
		g2.setColor(Color.BLACK);
		g2.draw(rectFrame);
	}

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

	private void paintBall(Graphics2D g2)
	{
		Ellipse2D kolo = new Ellipse2D.Double(ballCentre.x, ballCentre.y,
				ArkanoidStatic.BALL_RADIUS, ArkanoidStatic.BALL_RADIUS);
		g2.setColor(Color.YELLOW);
		g2.fill(kolo);
		g2.draw(kolo);
	}

	private void paintPalette(Graphics2D g2)
	{
		Rectangle2D rec = new Rectangle2D.Double();
		rec.setFrame(palette, ArkanoidStatic.PALETTE_DIMENSION);
		g2.setColor(Color.BLACK);
		g2.fill(rec);
		g2.draw(rec);
	}
}
