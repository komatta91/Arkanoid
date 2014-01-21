package arkaoid.view;

import java.awt.Color;
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

import arkaoid.ArkanoidStatic;
import arkaoid.view.action.AbstractGameAction;
import arkaoid.view.action.ExitButtonAction;
import arkaoid.view.action.NewGameButtonAction;

/**
 * klasa reprezentuj¹ca panel menu g³ównego
 * @author Karol
 *
 */
@SuppressWarnings("serial")
public class MainMenuButtonPanel extends JPanel
{

	/**
	 * kolekcja przycisków
	 */
	private List<JButton> przyciski = new LinkedList<JButton>();
	/**
	 * obraz z manu
	 */
	private BufferedImage image;
	/**
	 * po³o¿enie obrazka
	 */
	private int imageX = 0;
	private int imageY = 10;

	/**
	 * konstruktor tworzy panel i przyciski które zawiera i dodaje
	 * do nich s³uchaczy zdarzeñ
	 * @param bq
	 */
	public MainMenuButtonPanel(final BlockingQueue<AbstractGameAction> bq)
	{
		imageInit();
		initLayoutMenager();
		setBackground(Color.WHITE);
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
			add(b);
		}
	}
	/**
	 * metoda rysuj¹ca komponent
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(image, imageX, imageY, this);
	}

	/**
	 * metoda inicjalizuje menagera rozk³adu
	 */
	private void initLayoutMenager()
	{
		LayoutMenuMenager mgr = new LayoutMenuMenager();
		mgr.setImageBottom(getImageBottom());
		setLayout(mgr);
	}

	/**
	 * metoda inicjalizuje obraz z menu gry
	 */
	private void imageInit()
	{
		File imageFile = new File("images/Arkanoid.jpg");
		try
		{
			image = ImageIO.read(imageFile);
			imageX = (int) ((ArkanoidStatic.MENU_DIMENSION.getWidth() - image
					.getWidth()) / 2);
		} catch (IOException e)
		{
			System.err.println("Blad odczytu obrazka");
		}
	}

	
	/**
	 * metoda zwraca wysokoœæ na której znajduj siê obrazek
	 * @return
	 */
	private int getImageBottom()
	{
		return image.getHeight() + imageY;
	}

	/**
	 * metoda tworzy przycisk i dodaje go do kolekcji
	 * @param name etykieta przycisku
	 * @return utworzony przycisk
	 */
	private JButton addButton(String name)
	{
		JButton nowy = new JButton(name);
		przyciski.add(nowy);
		return nowy;
	}
}
