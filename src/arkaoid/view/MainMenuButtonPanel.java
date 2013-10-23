package arkaoid.view;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MainMenuButtonPanel extends JPanel
{
	/** Domyœlna wysokoœæ przycisku */
	public static final int DEFAULT_BUTTON_HEIGHT = 50;
	/** Domyœlna szerokoœæ przycisku stanowi¹ca 75% szerokoœci okna*/
	public static final int DEFAULT_BUTTON_WIDTH = MainMenu.DEFAULT_WIDTH * 3 / 4;
	/** Przycisk nowej gry */
	private JButton newGameButton;
	/** Przycisk najlepszych wyników */
	private JButton bestScoreButton;
	/** Przycisk do wychodzenia z gry */
	//TO_DO Przerobiæ na plik graficzny
	private JButton exitButton;
	/** Tytu³ Gry */
	private JButton tytul;

	public MainMenuButtonPanel()
	{
		super(null);
		//TO-DO
		int bound = ((MainMenu.DEFAULT_HEIGHT - 20) / 4 - DEFAULT_BUTTON_HEIGHT) * 2;
		int x = (MainMenu.DEFAULT_WIDTH - DEFAULT_BUTTON_WIDTH) / 2;
		//System.out.println(bound);
		int y = 20;
		this.tytul = new JButton("Arkanoid");
		this.tytul.setEnabled(false);
		this.tytul.setBounds(x, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
		y += bound;
		
		this.newGameButton = new JButton("Nowa Gra");
		this.newGameButton.setBounds(x, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
		y += bound;
				
		this.bestScoreButton = new JButton("Najlepsze Wyniki");
		this.bestScoreButton.setBounds(x, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);		
		y += bound;
		
		this.exitButton = new JButton("Zakoñcz");
		this.exitButton.setBounds(x, y, DEFAULT_BUTTON_WIDTH, DEFAULT_BUTTON_HEIGHT);
				
				
		//buttonPanel.setLayout(new GridLayout(4,1));
		this.add(this.tytul);
		this.add(this.newGameButton);
		this.add(this.bestScoreButton);
		this.add(this.exitButton);				
	}
}