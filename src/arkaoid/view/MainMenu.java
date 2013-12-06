package arkaoid.view;

import java.awt.Color;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.BlockingQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class MainMenu extends JFrame
{
	/** Wysokoœæ okna */
	public static final int DEFAULT_HEIGHT = 400;
	/** Szerokoœæ okna */
	public static final int DEFAULT_WIDTH = 300;

	/** Komponent zawieraj¹cy przyciski */
	private MainMenuButtonPanel buttonPanle;
	//private BlockingQueue<AbstractGameAction> bq;

	/** Konstruktor okna MainFrame */
	public MainMenu(final BlockingQueue<AbstractGameAction> bq)
	{
		buttonPanle = new MainMenuButtonPanel(bq);
		//this.bq = bq;
		// Drobna zmiana
		this.setBackground(Color.WHITE);
		this.add(buttonPanle);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setTitle("Arkanoid- menu");
		// this.setLocationByPlatform(true);
		this.setLocationRelativeTo(null);
		this.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		this.setResizable(false);
		addWindowListener(new WindowAdapter()
		{
			 public void windowClosing(WindowEvent evt)
			 {
				 bq.add(new WindowAction("WINDOW_CLOSING"));
				 formWindowClosing(evt);
			 }
		});
		// initComponents();
	}
	private void formWindowClosing(WindowEvent evt) {
        int ans = JOptionPane.showConfirmDialog(this, "Czy na pewno zamkn¹æ to okno?", "Pytanie?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
 
        if (ans == JOptionPane.YES_OPTION)
        {
            dispose();
        }
    }
}
