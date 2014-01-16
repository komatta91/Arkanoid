package arkaoid.model.strategy;

import arkaoid.model.Model;

public class MouseMoveLeftStrategy extends MouseMoveStrategy
{

	public MouseMoveLeftStrategy(int dx)
	{
		super(dx);
	}

	@Override
	public void doStrategy(Model model)
	{
		model.doStrategy(this);
	}

}
