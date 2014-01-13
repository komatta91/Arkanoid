package arkaoid.model.strategy;

import arkaoid.model.Model;

public class MouseMoveRightStrategy extends MouseMoveStrategy
{

	public MouseMoveRightStrategy(int dx)
	{
		super(dx);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doStrategy(Model model)
	{
		// TODO Auto-generated method stub
		model.doStrategy(this);
	}

}
