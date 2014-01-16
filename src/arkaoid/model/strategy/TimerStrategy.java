package arkaoid.model.strategy;

import arkaoid.Exceptons.GameOverException;
import arkaoid.Exceptons.NoBricksException;
import arkaoid.model.Model;

public class TimerStrategy extends AbstractStrategy
{

	@Override
	public void doStrategy(Model model) throws GameOverException,
			NoBricksException
	{
		model.doStrategy(this);
	}

}
