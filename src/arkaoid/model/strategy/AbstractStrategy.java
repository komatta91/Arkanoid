package arkaoid.model.strategy;

import arkaoid.GameOverException;
import arkaoid.model.Model;
import arkaoid.model.NoBricksException;

public abstract class AbstractStrategy
{
	public abstract void doStrategy(Model model) throws GameOverException, NoBricksException;
}
