package arkaoid.model.strategy;

import arkaoid.model.Model;

public class StartMoveStrategy extends AbstractStrategy
{

	@Override
	public void doStrategy(Model model)
	{
		model.doStrategy(this);
	}

}
