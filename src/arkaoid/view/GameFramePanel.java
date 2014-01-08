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
	// /public static final int DEFAULT_WIDTH = (int)(GameFrame.DEFAULT_WIDTH *
	// 0.8);
	// public static final int DEFAULT_HEIGHT = GameFrame.DEFAULT_HEIGHT;
	private Point palette = new Point();
	private Point ballCentre = new Point();
	List<BrickMod> points;

	public GameFramePanel(final BlockingQueue<AbstractGameAction> bq)
	{
		setSize(ArkanoidStatic.GAME_PANEL_DIMENSION);
		setBackground(new Color(133, 133, 233));
		addMouseMotionListener(new GameMouseListener(bq));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rec = new Rectangle2D.Double();
		rec.setFrame(palette, ArkanoidStatic.PALETTE_DIMENSION);
		g2.setColor(Color.BLACK);
		g2.fill(rec);
		g2.draw(rec);
		
		
		Ellipse2D kolo = new Ellipse2D.Double(ballCentre.x, ballCentre.y, ArkanoidStatic.BALL_RADIUS, ArkanoidStatic.BALL_RADIUS);
		g2.setColor(Color.YELLOW);
		g2.fill(kolo);
		g2.draw(kolo);
		
		//Rectangle2D rect = new Rectangle2D.Double();
		//rect.setFrame(new Point(00,20), ArkanoidStatic.BRICK_DIMENSION);
		//g2.fill(rect);
		//g2.draw(rect);
		if (points != null)
			
			
		for (BrickMod p : points)
		{
			Rectangle2D rect = new Rectangle2D.Double();
			rect.setFrame(p.getPoint(), ArkanoidStatic.BRICK_DIMENSION);
			Rectangle2D rectFrame = new Rectangle2D.Double();
			rectFrame.setFrame(rect);
			switch (p.getLife())
			{
				case 1: g2.setColor(Color.MAGENTA); break;
				case 2: g2.setColor(Color.GRAY); break;
				case 3: g2.setColor(Color.GREEN); break;
				default: g2.setColor(Color.ORANGE); break;
			}
			//g2.setColor(Color.MAGENTA);
			g2.fill(rect);
			g2.draw(rect);
			g2.setColor(Color.BLACK);
			g2.draw(rectFrame);
		}
		
	}

	public void setPaleteCentre(Point paletteCentre)
	{
		int x = paletteCentre.x - ArkanoidStatic.PALETTE_DIMENSION.width / 2;
		int y = paletteCentre.y;
		this.palette = new Point(x,y);
		
		//paintComponent(getGraphics());
	}
	
	public void setBallCentre(Point ballCentre)
	{
		this.ballCentre.setLocation(ballCentre.x, ballCentre.y);
	}
	
	public void setPoints(List<BrickMod> points)
	{
		this.points = points;
	}
}
