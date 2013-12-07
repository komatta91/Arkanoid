package arkaoid.model.strategy;

import arkaoid.model.Model;

public class StartStrategy extends AbstractStrategy
{

	@Override
	public void doStrategy(Model model)
	{
		model.doStrategy(this);

	}

}
