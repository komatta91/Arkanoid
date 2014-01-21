package arkaoid.model.strategy;

import arkaoid.Exceptons.GameOverException;
import arkaoid.Exceptons.NoBricksException;
import arkaoid.model.Model;

/**
 * Abstrakcyjna klasa bazowa hierarchi strategii wyst�puj�cych w grze.
 * @author Karol
 *
 */
public abstract class AbstractStrategy
{
	/**
	 * metoda wywo�uj�ca odpowiedni� metod� obs�ugi strategii
	 * w modelu
	 * @param model referencja na model
 	 * @throws GameOverException wyj�tek przegranej
	 * @throws NoBricksException wygranej
	 */
	public abstract void doStrategy(Model model) throws GameOverException,
			NoBricksException;
}
