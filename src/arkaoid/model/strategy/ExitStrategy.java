package arkaoid.model.strategy;

import arkaoid.model.Model;

public class ExitStrategy extends AbstractStrategy
{

	@Override
	public void doStrategy(Model model)
	{
		model.doStrategy(this);
	}

}
