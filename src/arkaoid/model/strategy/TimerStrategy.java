package arkaoid.model.strategy;

import arkaoid.GameOverException;
import arkaoid.model.Model;
import arkaoid.model.NoBricksException;

public class TimerStrategy extends AbstractStrategy
{

	@Override
	public void doStrategy(Model model) throws GameOverException, NoBricksException
	{
		// TODO Auto-generated method stub
		model.doStrategy(this);
	}

}
