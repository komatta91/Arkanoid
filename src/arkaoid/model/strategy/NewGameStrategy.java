package arkaoid.model.strategy;

import arkaoid.Exceptons.NoBricksException;
import arkaoid.model.Model;

public class NewGameStrategy extends AbstractStrategy
{

	@Override
	public void doStrategy(Model model) throws NoBricksException
	{
		model.doStrategy(this);

	}

}
