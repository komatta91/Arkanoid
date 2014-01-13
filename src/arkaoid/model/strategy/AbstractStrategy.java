package arkaoid.model.strategy;

import arkaoid.Exceptons.GameOverException;
import arkaoid.Exceptons.NoBricksException;
import arkaoid.model.Model;

public abstract class AbstractStrategy
{
	public abstract void doStrategy(Model model) throws GameOverException, NoBricksException;
}
