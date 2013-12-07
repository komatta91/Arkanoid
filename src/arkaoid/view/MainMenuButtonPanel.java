package arkaoid.view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.ExitButtonAction;
import arkaoid.view.action.NewGameButtonAction;

@SuppressWarnings("serial")
public class MainMenuButtonPanel extends JPanel
{

	private List<JButton> przyciski = new LinkedList<JButton>();
	private BufferedImage image;
	private int imageX = 0; //(MainMenu.DEFAULT_WIDTH - image.getWidth()) / 2;
	private int imageY = 10;
	//Point p;

	public MainMenuButtonPanel(final BlockingQueue<AbstractGameAction> bq)
	{
		imageInit();
		initLayoutMenager();
		//
		addButton("Nowa Gra").addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				bq.add(new NewGameButtonAction());
			}

		});
		addButton("Zakoñcz").addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				bq.add(new ExitButtonAction());
			}

		});
		for (JButton b : przyciski)
		{
			this.add(b);
		}
	}

	private void initLayoutMenager()
	{
		LayoutMenuMenager mgr = new LayoutMenuMenager();
		mgr.setImageBottom(getImageBottom());
		this.setLayout(mgr);
	}

	private void imageInit()
	{
		File imageFile = new File("images/Arkanoid.jpg");
		try
		{
			image = ImageIO.read(imageFile);
			imageX = (MainMenu.DEFAULT_WIDTH - image.getWidth()) / 2;
		} catch (IOException e)
		{
			System.err.println("Blad odczytu obrazka");
			e.printStackTrace();
		}
	}
	

	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, imageX, imageY, this);
	}
	
	public int getImageBottom()
	{
		return image.getHeight() + imageY;
	}
	
	private JButton addButton(String name)
	{
		JButton nowy = new JButton(name);
		przyciski.add(nowy);
		return nowy;
	}
}
