package arkaoid.model.strategy;

import arkaoid.Exceptons.GameOverException;
import arkaoid.Exceptons.NoBricksException;
import arkaoid.model.Model;

/**
 * Abstrakcyjna klasa bazowa hierarchi strategii wystêpuj¹cych w grze.
 * @author Karol
 *
 */
public abstract class AbstractStrategy
{
	/**
	 * metoda wywo³uj¹ca odpowiedni¹ metodê obs³ugi strategii
	 * w modelu
	 * @param model referencja na model
 	 * @throws GameOverException wyj¹tek przegranej
	 * @throws NoBricksException wygranej
	 */
	public abstract void doStrategy(Model model) throws GameOverException,
			NoBricksException;
}
