package arkaoid.model.strategy;

import arkaoid.model.Model;

public class MouseMoveRightStrategy extends MouseMoveStrategy
{

	public MouseMoveRightStrategy(int dx)
	{
		super(dx);
	}

	@Override
	public void doStrategy(Model model)
	{
		model.doStrategy(this);
	}

}
