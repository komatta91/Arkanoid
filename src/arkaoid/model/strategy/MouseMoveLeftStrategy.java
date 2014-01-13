package arkaoid.model.strategy;

import arkaoid.model.Model;

public class MouseMoveLeftStrategy extends MouseMoveStrategy
{

	public MouseMoveLeftStrategy(int dx)
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
