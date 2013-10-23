package arkaoid.view;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MainMenu extends JFrame
{
	/** Wysoko�� okna */
	public static final int DEFAULT_HEIGHT = 400;
	/** Szeroko�� okna */
	public static final int DEFAULT_WIDTH = 300;
	
	/** Komponent zawieraj�cy przyciski */
	private MainMenuButtonPanel buttonPanle = new MainMenuButtonPanel();



	/** Konstruktor okna MainFrame */
	public MainMenu()
	{
		//Drobna zmiana
		this.add(buttonPanle);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Arkanoid- menu");
		this.setLocationByPlatform(true);
		//this.setLocationRelativeTo(null);
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setResizable(false);
		//initComponents();
	}
	
}
